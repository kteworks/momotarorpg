package dao;

import model.Account;
import model.Enemy;
import model.Message;
import model.Player;
import model.Quest;
import model.Sync;

public class StatusDAO {

	public int[] HPMPup(int[] status) {

		status[3] += 2;
		status[4] += 1;
		
		return status;
	}
	
	public void statusUp(Account account, Player player, String str) {

		int[] pStatus = player.getStatus();

		int num = 0;// Integer.parseInt(str);
		if(str.equals(Message.statusName()[0]))
			num = 0;
		else if(str.equals(Message.statusName()[1]))
			num = 1;
		else if(str.equals(Message.statusName()[2]))
			num = 2;

		pStatus[num] += 1;

		player.setStatus(pStatus);
		Sync sync = new Sync();
		sync.statusSync(account, player);
		account.setSkillPoint(account.getSkillPoint() - 1);
		sync.skillPointSync(account);
	}
	
	public void statusUp(Quest quest, String str) {

		statusUp(quest.getAccount(), quest.getPlayer(), str);
	}

	public void enemyAdjustStatus(Enemy enemy) {

		// 敵ステータスの取得
		int[] eStatus = enemy.getStatus();
		// 敵スキルポイントの取得
		int skillPoint = (enemy.getLv() - 1)*2;
		// スキルポイントの割り当て
		for (int i = 0; i < skillPoint; i++) {
			// HP MP
			eStatus = HPMPup(eStatus);
			// ランダムのステータスに割り当て
			int j = (int) Math.floor(Math.random() * 3);
			eStatus[j] += 1;
		}

		// 敵ステータスへの適用
		enemy.setStatus(eStatus);
	}
	
	public void statusAllocation(Account account, Player player, int status0, int status1, int status2) {
		for(;status0 > 0;status0--) {
			statusUp(account, player, "攻撃力");
		}
		for(;status1 > 0;status1--) {
			statusUp(account, player, "防御力");
		}
		for(;status2 > 0;status2--) {
			statusUp(account, player, "素早さ");
		}
	}
	
	public void statusAllocation(Quest quest, int status0, int status1, int status2) {
		statusAllocation(quest.getAccount(), quest.getPlayer(), status0, status1, status2);
	}
	
}

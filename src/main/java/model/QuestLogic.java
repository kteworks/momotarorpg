package model;

import java.util.ArrayList;
import java.util.List;

import dao.PlayerDAO;
import dao.StatusDAO;

public class QuestLogic {

	public int levelUpCheck(Quest quest) {
		PlayerDAO dao = new PlayerDAO();
		int pLv = quest.getPlayer().getLv();
		int Lv = dao.getLevel(quest.getPlayer().getLv(), quest.getPlayer().getExp());
		if (pLv != Lv) {
			quest.getPlayer().setLv(Lv);
			Sync sync = new Sync();
			sync.levelSync(quest);
		}
		return Lv - pLv;
	}

	public int expLevelLogic(Quest quest) {
		int Exp = quest.getPlayer().getExp() + quest.getEnemy().getGetExp();
		if (Exp > Database.maxExp)
			Exp = Database.maxExp;
		quest.getPlayer().setExp(Exp);
		Sync sync = new Sync();
		sync.expSync(quest.getAccount(), quest.getPlayer());
		return levelUpCheck(quest);
	}

	public int victory(Quest quest) {
		Sync sync = new Sync();
		List<String> battlelog = new ArrayList<String>();
		battlelog.add(quest.getEnemy().getEnemy_name()+Message.downMsg());
		int upLv = 0;
		if (quest.getAccount().getExp() != Database.maxExp) {
			upLv = expLevelLogic(quest);
			battlelog.add("<span style=\"color : #ff00ff\">"+quest.getEnemy().getGetExp()+ "</span>" +Message.getExpMsg());
			if (upLv > 0) {
				quest.getAccount().setSkillPoint(quest.getAccount().getSkillPoint() + (upLv*2));
				sync.skillPointSync(quest.getAccount());
				StatusDAO dao = new StatusDAO();
				for (int i = 0; i < upLv; i++) {
					quest.getPlayer().setStatus(dao.HPMPup(quest.getPlayer().getStatus()));
					quest.getAccount().setStatus(dao.HPMPup(quest.getAccount().getStatus()));
				}
				sync.statusSync(quest.getAccount());
				quest.setpRemainHP(quest.getPlayer().getStatus()[3]);
				battlelog.add(
						"<span style=\"color : #ff00ff\">" + quest.getPlayer().getLv() + "</span>" + Message.lvUpMsg());
			}
		} else {
			battlelog.add(Message.stopExpMsg());
		}
		battlelog.add("<span style=\"color : #ffd700\">" + quest.getEnemy().getGetMoney() + "</span>"
				+ Message.getMoneyMsg());
		quest.setBattlelog(battlelog);
		MoneyLogic moneyLogic = new MoneyLogic();
		moneyLogic.DropMoney(quest);
		return upLv;
	}

	public void lose(Quest quest) {
		MoneyLogic moneyLogic = new MoneyLogic();
		moneyLogic.LostMoney(quest);
		List<String> battlelog = new ArrayList<String>();
		battlelog.add("しょじきんが " + quest.getAccount().getMoney() + Message.reduceMoneyMsg());
		battlelog.add(Message.gameOverMsg());
		quest.setBattlelog(battlelog);
	}

	public Quest initializeQuest(Account account, Player player, String difficulty) {
		Quest quest = new Quest();
		EnemyLogic eLogic = new EnemyLogic();
		quest.setStage(1);
		quest.setAccount(account);
		quest.setPlayer(player);
		quest.setpRemainHP(player.getStatus()[3]);
		quest.setpRemainMP(player.getStatus()[4]);
		quest.setTurn(0);
		quest.setDifficulty(difficulty);
		quest.setEnemy(eLogic.initializeEnemy(quest));
		quest.seteRemainHP(quest.getEnemy().getStatus()[3]);
		quest.seteRemainMP(quest.getEnemy().getStatus()[4]);
		List<String> battlelog = new ArrayList<String>();
		battlelog.add(quest.getEnemy().getEnemy_name() + Message.encountEnemyMsg());
		quest.setBattlelog(battlelog);
		return quest;
	}

	public Quest nextStage(Quest quest) {
		quest.setStage(quest.getStage() + 1);
		EnemyLogic eLogic = new EnemyLogic();
		if (quest.getStage() == 3) {
			// bossセット
			quest.setEnemy(eLogic.initializeBoss(quest));

		} else {
			quest.setEnemy(eLogic.initializeEnemy(quest));
		}
		quest.seteRemainHP(quest.getEnemy().getStatus()[3]);
		quest.seteRemainMP(quest.getEnemy().getStatus()[4]);
		quest.setTurn(0);

		List<String> battlelog = new ArrayList<String>();
		battlelog.add(quest.getEnemy().getEnemy_name() + Message.encountEnemyMsg());
		quest.setBattlelog(battlelog);
		return quest;
	}
}
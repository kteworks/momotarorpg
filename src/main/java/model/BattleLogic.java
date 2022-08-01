package model;

import java.util.ArrayList;
import java.util.List;

public class BattleLogic {

	public int damage(int atk, int def) {
		int damage = atk - (def / 2);
		if(damage<=0) {damage=1;}
		return damage;
	}

	public int magicDamage(int atk, int def) {
		return (int) Math.floor(damage(atk, def) * 2);
	}

	public void playerAttack(Quest quest) {
		int damage = damage(quest.getPlayer().getStatus()[0], quest.getEnemy().getStatus()[1]);
		quest.seteRemainHP(quest.geteRemainHP() - damage);
		if (quest.geteRemainHP() < 0) {
			quest.seteRemainHP(0);
		}
		List<String> battlelog = quest.getBattlelog();
		battlelog.add(quest.getPlayer().getAccount_name() + Message.atkMsg());
		battlelog.add(quest.getEnemy().getEnemy_name() + " に " + damage + Message.damageMsg());
		quest.setBattlelog(battlelog);
	}

	public void playerMagicAttack(Quest quest) {
		int magicDamage = magicDamage(quest.getPlayer().getStatus()[0], quest.getEnemy().getStatus()[1]);
		quest.seteRemainHP(quest.geteRemainHP() - magicDamage);
		quest.setpRemainMP(quest.getpRemainMP() - 1);
		if (quest.geteRemainHP() < 0) {
			quest.seteRemainHP(0);
		}
		int[] status = quest.getPlayer().getStatus();
		status[4]--;
		quest.getPlayer().setStatus(status);
		List<String> battlelog = quest.getBattlelog();
		battlelog.add(quest.getPlayer().getAccount_name() + Message.atkMsg());
		battlelog.add(quest.getEnemy().getEnemy_name() + " に " + magicDamage + Message.damageMsg());
		quest.setBattlelog(battlelog);
	}

	public void enemyAttack(Quest quest) {
		int damage = damage(quest.getEnemy().getStatus()[0], quest.getPlayer().getStatus()[1]);
		quest.setpRemainHP(quest.getpRemainHP() - damage);
		if (quest.getpRemainHP() < 0) {
			quest.setpRemainHP(0);
		}
		List<String> battlelog = quest.getBattlelog();
		battlelog.add(quest.getEnemy().getEnemy_name() + Message.atkMsg());
		battlelog.add(quest.getPlayer().getAccount_name() + " に " + damage + Message.damageMsg());
		quest.setBattlelog(battlelog);
	}

	public void action(Quest quest, String act) {
		List<String> battlelog = new ArrayList<String>();
		quest.setBattlelog(battlelog);
		ItemLogic itemLogic = new ItemLogic();
		if (act.equals("魔法攻撃") && quest.getPlayer().getStatus()[4]<=0) {
			battlelog.add(Message.notMp());
			quest.setBattlelog(battlelog);
			return;
		}
		
		quest.setTurn(quest.getTurn() + 1);
		int first = quest.getPlayer().getStatus()[2] - quest.getEnemy().getStatus()[2];
		if (act.equals("攻撃")) {
			if (first >= 0) {
				playerAttack(quest);
				if (!enemyDownCheck(quest)) {
					enemyAttack(quest);
					if (playerDownCheck(quest));
				}
			} else {
				enemyAttack(quest);
				if (!playerDownCheck(quest)) {
					playerAttack(quest);
					if (enemyDownCheck(quest));
				}
			}
		} else if (act.equals("魔法攻撃")) {
			if (first >= 0) {
				playerMagicAttack(quest);
				if (!enemyDownCheck(quest)) {
					enemyAttack(quest);
					if (playerDownCheck(quest));
				}
			} else {
				enemyAttack(quest);
				if (!playerDownCheck(quest)) {
					playerMagicAttack(quest);
					if (enemyDownCheck(quest));
				}
			}
		} else if (act.equals("0")) {
			itemLogic.useItem1(quest);
			enemyAttack(quest);
			if (playerDownCheck(quest));
		} else if (act.equals("1")) {
			itemLogic.useItem2(quest);
			enemyAttack(quest);
			if (playerDownCheck(quest));
		} else if (act.equals("2")) {
			itemLogic.useItem3(quest);
			enemyAttack(quest);
			if (playerDownCheck(quest));
		} else if (act.equals("3")) {
			itemLogic.useItem4(quest);
			enemyAttack(quest);
			if (playerDownCheck(quest));
		} else if (act.equals("4")) {
			itemLogic.useItem5(quest);
			enemyAttack(quest);
			if (playerDownCheck(quest));
		} else if (act.equals("5")) {
			itemLogic.useItem6(quest);
			enemyAttack(quest);
			if (playerDownCheck(quest));
		} else if (act.equals("逃げる")) {
			battlelog.add(quest.getAccount().getName() + Message.runMsg());
			quest.setBattlelog(battlelog);
		}
	}

	public boolean enemyDownCheck(Quest quest) {
		if (quest.geteRemainHP() == 0) {
			List<String> battlelog = quest.getBattlelog();
			battlelog.add(quest.getEnemy().getEnemy_name() + Message.downMsg());
			quest.setBattlelog(battlelog);
			return true;
		}
		return false;
	}
	
	public boolean playerDownCheck(Quest quest) {
		if (quest.getpRemainHP() == 0) {
			List<String> battlelog = quest.getBattlelog();
			battlelog.add(quest.getAccount().getName() + Message.downMsg());
			quest.setBattlelog(battlelog);
			return true;
		}
		return false;
	}

}

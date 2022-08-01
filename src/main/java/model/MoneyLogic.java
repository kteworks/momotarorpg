package model;

public class MoneyLogic {

	public void DropMoney(Quest quest) {

		quest.getPlayer().setMoney(quest.getEnemy().getGetMoney() + quest.getPlayer().getMoney());
		Sync sync = new Sync();
		sync.moneySync(quest.getAccount(), quest.getPlayer());
	}

	public void LostMoney(Quest quest) {

		quest.getPlayer().setMoney(quest.getPlayer().getMoney() / 2);
		Sync sync = new Sync();
		sync.moneySync(quest.getAccount(), quest.getPlayer());
	}
}

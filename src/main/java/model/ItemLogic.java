package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemLogic {
	private final int i = 2;

	public String getItemName(int id) {
		try (Connection conn = DriverManager.getConnection(Database.getJDBC_URL(), Database.getDB_USER(),
				Database.getDB_PASS())) {

			String sql = "SELECT item_name FROM ITEMLIST where item_id=" + id;
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				return rs.getString("item_name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void useItem1(Quest quest) {
		int[] status = quest.getPlayer().getStatus();
		status[0] += i;
		int[] items = quest.getPlayer().getItem();
		items[0]--;
		quest.getPlayer().setItem(items);
		Sync sync = new Sync();
		sync.itemSync(quest.getAccount(), quest.getPlayer());
		List<String> battlelog = new ArrayList<String>();
		battlelog.add(getItemName(0) + Message.eatItemMsg());
		battlelog.add(Message.statusName()[0] + " が " + i + Message.upStatMsg());
		quest.setBattlelog(battlelog);
		quest.getPlayer().setStatus(status);
	}

	public void useItem2(Quest quest) {
		int[] status = quest.getPlayer().getStatus();
		status[1] += i;
		int[] items = quest.getPlayer().getItem();
		items[1]--;
		quest.getPlayer().setItem(items);
		Sync sync = new Sync();
		sync.itemSync(quest.getAccount(), quest.getPlayer());
		List<String> battlelog = new ArrayList<String>();
		battlelog.add(getItemName(1) + Message.eatItemMsg());
		battlelog.add(Message.statusName()[1] + " が " + i + Message.upStatMsg());
		quest.setBattlelog(battlelog);
		quest.getPlayer().setStatus(status);
	}

	public void useItem3(Quest quest) {
		int[] status = quest.getPlayer().getStatus();
		status[2] += i;
		int[] items = quest.getPlayer().getItem();
		items[2]--;
		quest.getPlayer().setItem(items);
		Sync sync = new Sync();
		sync.itemSync(quest.getAccount(), quest.getPlayer());
		List<String> battlelog = new ArrayList<String>();
		battlelog.add(getItemName(2) + Message.eatItemMsg());
		battlelog.add(Message.statusName()[2] + " が " + i + Message.upStatMsg());
		quest.setBattlelog(battlelog);
		quest.getPlayer().setStatus(status);
	}

	public void useItem4(Quest quest) {
		int[] status = quest.getPlayer().getStatus();
		quest.setpRemainHP(quest.getpRemainHP() + (int) Math.floor(status[3] * 0.3));
		int[] items = quest.getPlayer().getItem();
		items[3]--;
		quest.getPlayer().setItem(items);
		Sync sync = new Sync();
		sync.itemSync(quest.getAccount(), quest.getPlayer());
		List<String> battlelog = new ArrayList<String>();
		battlelog.add(getItemName(3) + Message.eatItemMsg());
		battlelog.add(Message.statusName()[3] + " が " + (int) Math.floor(status[3] * 0.3) + Message.healMsg());
		quest.setBattlelog(battlelog);
	}

	public void useItem5(Quest quest) {
		quest.setpRemainMP(quest.getpRemainMP() + 2);
		int[] items = quest.getPlayer().getItem();
		items[4]--;
		quest.getPlayer().setItem(items);
		Sync sync = new Sync();
		sync.itemSync(quest.getAccount(), quest.getPlayer());
		List<String> battlelog = new ArrayList<String>();
		battlelog.add(getItemName(4) + Message.eatItemMsg());
		battlelog.add(Message.statusName()[4] + " が " + i + Message.healMsg());
		quest.setBattlelog(battlelog);
	}

	public void useItem6(Quest quest) {
		int j = (int)Math.floor(Math.random()*3);
		int[] status = quest.getPlayer().getStatus();
		status[j] += i;
		int[] items = quest.getPlayer().getItem();
		items[5]--;
		quest.getPlayer().setItem(items);
		Sync sync = new Sync();
		sync.itemSync(quest.getAccount(), quest.getPlayer());
		List<String> battlelog = new ArrayList<String>();
		battlelog.add(getItemName(5) + Message.eatItemMsg());
		battlelog.add(Message.statusName()[j] + " が " + i + Message.upStatMsg());
		quest.setBattlelog(battlelog);	
		quest.getPlayer().setStatus(status);
	}
}

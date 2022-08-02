package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Sync {
	public void expSync(Account account, Player player) {
		if (account.getExp() != player.getExp()) {
			account.setExp(player.getExp());
			try (Connection conn = DriverManager.getConnection(Database.getJDBC_URL(), Database.getDB_USER(),
					Database.getDB_PASS())) {

				String sql = "UPDATE userdata SET exp=" + player.getExp() + "where username='" + account.getName()
						+ "'";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void itemSync(Account account, Player player) {
		int[] items = player.getItem();
		account.setItem(items);
		try (Connection conn = DriverManager.getConnection(Database.getJDBC_URL(), Database.getDB_USER(),
				Database.getDB_PASS())) {

			String sql = "UPDATE userdata SET item1=" + items[0] + ",item2=" + items[1] + ",item3=" + items[2]
					+ ",item4="
					+ items[3] + ",item5=" + items[4] + ",item6=" + items[5] + " where username='"
					+ account.getName() + "'";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void itemSync(Account account) {
		int[] items = account.getItem();
		try (Connection conn = DriverManager.getConnection(Database.getJDBC_URL(), Database.getDB_USER(),
				Database.getDB_PASS())) {

			String sql = "UPDATE userdata SET item1=" + items[0] + ",item2=" + items[1] + ",item3=" + items[2]
					+ ",item4="
					+ items[3] + ",item5=" + items[4] + ",item6=" + items[5] + " where username='"
					+ account.getName() + "'";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void moneySync(Account account, Player player) {
		int money = player.getMoney();
		if (account.getMoney() != money) {
			account.setMoney(money);
			try (Connection conn = DriverManager.getConnection(Database.getJDBC_URL(), Database.getDB_USER(),
					Database.getDB_PASS())) {
				String sql = "UPDATE userdata SET money=" + money + " where username='" + account.getName() + "'";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void moneySync(Account account) {
		int money = account.getMoney();
		try (Connection conn = DriverManager.getConnection(Database.getJDBC_URL(), Database.getDB_USER(),
				Database.getDB_PASS())) {
			String sql = "UPDATE userdata SET money=" + money + " where username='" + account.getName() + "'";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void moneySync(Quest quest) {
		int money = quest.getPlayer().getMoney();
		if (quest.getAccount().getMoney() != money) {
			quest.getAccount().setMoney(money);
			try (Connection conn = DriverManager.getConnection(Database.getJDBC_URL(), Database.getDB_USER(),
					Database.getDB_PASS())) {
				String sql = "UPDATE userdata SET money=" + money + " where username='" + quest.getAccount().getName()
						+ "'";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void statusSync(Account account, Player player) {
		int[] status = player.getStatus();
		account.setStatus(status);
		statusSync(account);
	}

	public void statusSync(Account account) {
		int[] status = account.getStatus();
		try (Connection conn = DriverManager.getConnection(Database.getJDBC_URL(), Database.getDB_USER(),
				Database.getDB_PASS())) {
			String sql = "UPDATE userdata set atk=" + status[0] + ", def=" + status[1] + ",spd=" + status[2]
					+ ", mp="
					+ status[4] + ", hp=" + status[3] + " where username='" + account.getName() + "'";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void skillPointSync(Account account) {
		try (Connection conn = DriverManager.getConnection(Database.getJDBC_URL(), Database.getDB_USER(),
				Database.getDB_PASS())) {
			String sql = "UPDATE userdata set skillpoint=" + account.getSkillPoint() + " where username='"
					+ account.getName() + "'";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void levelSync(Quest quest) {
		int lv = quest.getPlayer().getLv();
		if (quest.getAccount().getLv() != lv) {
			quest.getAccount().setLv(lv);
			try (Connection conn = DriverManager.getConnection(Database.getJDBC_URL(), Database.getDB_USER(),
					Database.getDB_PASS())) {
				String sql = "UPDATE userdata set level=" + lv + " where username='" + quest.getAccount().getName()
						+ "'";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
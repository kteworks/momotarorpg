package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;
import model.Database;
import model.Player;

public class PlayerDAO {
	private final String JDBC_URL = Database.getJDBC_URL();
	private final String DB_USER = Database.getDB_USER();
	private final String DB_PASS = Database.getDB_PASS();

	public String getName(int character_id) {
		try (Connection conn = DriverManager.getConnection(Database.getJDBC_URL(), Database.getDB_USER(),
				Database.getDB_PASS())) {

			String sql = "SELECT character_name from character_base WHERE character_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, character_id);
			ResultSet rs = pStmt.executeQuery();

			if (rs.next()) {
				String name = rs.getString("character_name");
				return name;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public Player initializePlayer(Account account) {

		Player player = new Player();
		player.setAccount_name(account.getName());
		String name = getName(account.getJob_id());
		player.setJob_name(name);
		int exp = account.getExp();
		player.setExp(exp);
		int lv = getLevel(1, exp);
		if(lv == 0)
			lv = 1;
		player.setLv(lv);
		int money = account.getMoney();
		player.setMoney(money);

		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT job_id, Exp, Money, atk, def, spd, hp, mp, item1, item2, item3, item4, item5, item6 from userdata WHERE UserName = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, account.getName());
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				int atk = rs.getInt("atk");
				int def = rs.getInt("def");
				int spd = rs.getInt("spd");
				int hp = rs.getInt("hp");
				int mp = rs.getInt("mp");
				int[] status = { atk, def, spd, hp, mp };
				player.setStatus(status);
				int item1 = rs.getInt("item1");
				int item2 = rs.getInt("item2");
				int item3 = rs.getInt("item3");
				int item4 = rs.getInt("item4");
				int item5 = rs.getInt("item5");
				int item6 = rs.getInt("item6");
				int[] item = { item1, item2, item3, item4, item5, item6 };
				player.setItem(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return player;
	}

	public int getLevel(int level, int exp) {
		
		if(exp==Database.maxExp) {
			return Database.maxLv;
		}
		
		int dbExp = 0;
		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT LV,TOTALEXP FROM EXP_TABLE where Lv=" + level;
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				dbExp = rs.getInt("TOTALEXP");
			}
			while (exp > dbExp) {
				sql = "SELECT LV,TOTALEXP FROM EXP_TABLE where Lv=" + (++level);
				pStmt = conn.prepareStatement(sql);
				rs = pStmt.executeQuery();
				if (rs.next()) {
					dbExp = rs.getInt("totalexp");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return --level;
	}
}

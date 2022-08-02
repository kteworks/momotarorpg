package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;
import model.Database;

public class RegisterDAO {
	private final String JDBC_URL = Database.getJDBC_URL();
	private final String DB_USER = Database.getDB_USER();
	private final String DB_PASS = Database.getDB_PASS();

	public Account Register(Account account) {

		if (account.getName().length() < 1 || account.getName().length() > 20 || account.getPass().length() < 6
				|| account.getPass().length() > 10) {
			return null;
		}

		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT username FROM userdata WHERE USERNAME = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, account.getName());

			ResultSet rs = pStmt.executeQuery();
			AccountDAO dao = new AccountDAO();
			if (rs.next()) {
				return null;
			} else {
				sql = "insert into userdata values (?, ?, -1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)";
				pStmt = conn.prepareStatement(sql);
				pStmt = conn.prepareStatement(sql);
				pStmt.setString(1, account.getName());
				pStmt.setString(2, dao.pass2Hex(account.getPass()));
				pStmt.execute();
				String username = account.getName();
				
				String password = dao.pass2Hex(account.getPass());
				int job_id = -1;
				int exp = 0;
				int lv = 1;
				int money = 0;
				int skillPoint = 0;
				int[] item = new int[6];
				int[] status = new int[5];
				account = new Account(username, password, job_id, exp, lv, money, skillPoint, item, status);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return account;
	}

	public void characterMake(Account account, String cName) {
		if (account.getJob_id() == -1) {
			if (cName.equals("ももたろう")) {
				account.setJob_id(0);
			} else if (cName.equals("きんたろう")) {
				account.setJob_id(1);
			} else if (cName.equals("うらたろう")) {
				account.setJob_id(2);
			}
		}
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "update userdata set job_id = ? where username = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, account.getJob_id());
			pStmt.setString(2, account.getName());
			pStmt.execute();
			sql = "SELECT atk,def,spd,hp,mp FROM character_base WHERE character_id = ?";
			pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, account.getJob_id());
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				int atk = rs.getInt("atk");
				int def = rs.getInt("def");
				int spd = rs.getInt("spd");
				int hp = rs.getInt("hp");
				int mp = rs.getInt("mp");
				int[] status = { atk, def, spd, hp, mp };
				account.setStatus(status);
				pStmt = conn.prepareStatement("update userdata set atk = ? where username = ?");
				pStmt.setInt(1, atk);
				pStmt.setString(2, account.getName());
				pStmt.execute();
				pStmt = conn.prepareStatement("update userdata set def = ? where username = ?");
				pStmt.setInt(1, def);
				pStmt.setString(2, account.getName());
				pStmt.execute();
				pStmt = conn.prepareStatement("update userdata set spd = ? where username = ?");
				pStmt.setInt(1, spd);
				pStmt.setString(2, account.getName());
				pStmt.execute();
				pStmt = conn.prepareStatement("update userdata set hp = ? where username = ?");
				pStmt.setInt(1, hp);
				pStmt.setString(2, account.getName());
				pStmt.execute();
				pStmt = conn.prepareStatement("update userdata set mp = ? where username = ?");
				pStmt.setInt(1, mp);
				pStmt.setString(2, account.getName());
				pStmt.execute();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

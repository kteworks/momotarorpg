package dao;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;
import model.Database;

public class AccountDAO {

	private final String JDBC_URL = Database.getJDBC_URL();
	private final String DB_USER = Database.getDB_USER();
	private final String DB_PASS = Database.getDB_PASS();

	public Account findByLogin(Account account) {
		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			String sq1 = "SELECT UserName, Password, job_id,Exp,level, Money, skillpoint, atk, def, spd, mp, hp, item1, item2, item3, item4, item5, item6 from userdata WHERE UserName =? AND Password =?";
			PreparedStatement pStmt = conn.prepareStatement(sq1);
			pStmt.setString(1, account.getName());
			pStmt.setString(2, pass2Hex(account.getPass()));

			ResultSet rs = pStmt.executeQuery();

			if (rs.next()) {
				String username = rs.getString("UserName");
				String password = rs.getString("Password");
				int job_id = rs.getInt("job_id");
				int exp = rs.getInt("Exp");
				int lv = rs.getInt("level");
				int money = rs.getInt("Money");
				int skillPoint = rs.getInt("skillpoint");
				int[] item = { rs.getInt("item1"), rs.getInt("item2"), rs.getInt("item3"), rs.getInt("item4"),
						rs.getInt("item5"), rs.getInt("item6") };
				int[] status = { rs.getInt("atk"), rs.getInt("def"), rs.getInt("spd"), rs.getInt("hp"),
						rs.getInt("mp") };
				account = new Account(username, password, job_id, exp, lv, money, skillPoint, item, status);
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return account;
	}
	
	public String pass2Hex(String pass) {
		MessageDigest md;
		try {
		  md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
		  throw new RuntimeException(e);
		}
		md.update(pass.getBytes(Charset.forName("UTF-8")));
		StringBuilder sb = new StringBuilder();
		for (byte b : md.digest()) {
		  sb.append(String.format("%02x", b & 0xff)); // String#format に修正
		}
		return sb.toString();
	}
}

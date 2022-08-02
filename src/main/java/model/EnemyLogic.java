package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.StatusDAO;

public class EnemyLogic {

	public int getExpAlgorithm(Quest quest, Enemy enemy) {
		if(quest.getPlayer().getLv() == Database.maxLv)
			return 0;
			
		double exp = 0;
		try (Connection conn = DriverManager.getConnection(Database.getJDBC_URL(), Database.getDB_USER(),
				Database.getDB_PASS())) {
			String sql = "select exp from exp_table where lv="+(quest.getPlayer().getLv()+1);
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			if(rs.next()) {
				exp = (double)rs.getInt("exp");
			}
			
			exp = exp / 10 * (((double)enemy.getLv()-(double)quest.getPlayer().getLv())  / 10 + 1.0);
			if(exp < 1.0) {
				exp = 1.0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return (int)Math.floor(exp);
	}
	
	public Enemy initializeEnemy(Quest quest) {
		Enemy enemy = new Enemy();
//		int enemy_id = (int) Math.floor((Math.random() * 0));
		int lv = quest.getPlayer().getLv();
		String enemy_type = "";
		String[] difficultys = Message.difficultys();
		String difficulty = quest.getDifficulty();
		if (difficulty.equals(difficultys[0])) {
			lv += (int) Math.floor((Math.random() * 3));
			if(quest.getStage()==1) {enemy_type = Message.enemyTypes()[0];}
			else if(quest.getStage()==2) {enemy_type = Message.enemyTypes()[1];}
		} else if(difficulty.equals(difficultys[1])) {
			lv += 3 + (int) Math.floor((Math.random() * 3));
			if(quest.getStage()==1) {enemy_type = Message.enemyTypes()[2];}
			else if(quest.getStage()==2) {enemy_type = Message.enemyTypes()[3];}
		} else if(difficulty.equals(difficultys[2])) {
			lv += 6 + (int) Math.floor((Math.random() * 3));
			if(quest.getStage()==1) {enemy_type = Message.enemyTypes()[4];}
			else if(quest.getStage()==2) {enemy_type = Message.enemyTypes()[5];}
		} 
		enemy.setType(enemy_type);
		enemy.setLv(lv);
		enemy.setGetMoney(lv * 10);
		enemy.setGetExp(getExpAlgorithm(quest, enemy));

		try (Connection conn = DriverManager.getConnection(Database.getJDBC_URL(), Database.getDB_USER(), Database.getDB_PASS())) {
			String sql = "select enemy_name,atk,def,spd,hp,mp FROM ENEMY_LIST where type='" + enemy_type + "'";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				String enemy_name = rs.getString("enemy_name");
				enemy.setEnemy_name(enemy_name);
				int atk = rs.getInt("atk");
				int def = rs.getInt("def");
				int spd = rs.getInt("spd");
				int hp = rs.getInt("hp");
				int mp = rs.getInt("mp");
				int[] status = { atk, def, spd, hp, mp };
				enemy.setStatus(status);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		StatusDAO dao = new StatusDAO();
		dao.enemyAdjustStatus(enemy);
		return enemy;
	}
	
	public Enemy initializeBoss(Quest quest) {
		Enemy enemy = new Enemy();
//		int enemy_id = (int) Math.floor((Math.random() * 0));
		int lv = quest.getPlayer().getLv();
		String enemy_type = "";
		String[] difficultys = Message.difficultys();
		if (quest.getDifficulty().equals(difficultys[0])) {
			lv += (int) Math.floor((Math.random() * 3));
			enemy_type = Message.bossTypes()[0];
		} else if(quest.getDifficulty().equals(difficultys[1])) {
			lv += 3 + (int) Math.floor((Math.random() * 3));
			enemy_type = Message.bossTypes()[1];
		} else if(quest.getDifficulty().equals(difficultys[2])) {
			lv += 6 + (int) Math.floor((Math.random() * 3));
			enemy_type = Message.bossTypes()[2];
		} 
		enemy.setType(enemy_type);
		enemy.setLv(lv);
		enemy.setGetMoney(lv * 10);
		enemy.setGetExp(getExpAlgorithm(quest, enemy)*15/10);

		try (Connection conn = DriverManager.getConnection(Database.getJDBC_URL(), Database.getDB_USER(), Database.getDB_PASS())) {
			String sql = "select enemy_name,atk,def,spd,hp,mp,type FROM BOSS_LIST where type='" + enemy_type + "'";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				String enemy_name = rs.getString("enemy_name");
				enemy.setEnemy_name(enemy_name);
				int atk = rs.getInt("atk");
				int def = rs.getInt("def");
				int spd = rs.getInt("spd");
				int hp = rs.getInt("hp");
				int mp = rs.getInt("mp");
				int[] status = { atk, def, spd, hp, mp };
				enemy.setStatus(status);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		StatusDAO dao = new StatusDAO();
		dao.enemyAdjustStatus(enemy);
		return enemy;
	}
}

package model;

import java.io.Serializable;
import java.util.List;

public class Quest implements Serializable {
	private int turn;
	private int stage;
	private String difficulty;
	private Account account;
	private Enemy enemy;
	private Player player;
	private int pRemainHP;
	private int pRemainMP;
	private int eRemainHP;
	private int eRemainMP;
	private List<String> battlelog;
	
	
	public int getpRemainMP() {
		return pRemainMP;
	}
	public void setpRemainMP(int pRemainMP) {
		this.pRemainMP = pRemainMP;
	}
	public int geteRemainMP() {
		return eRemainMP;
	}
	public void seteRemainMP(int eRemainMP) {
		this.eRemainMP = eRemainMP;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public int getpRemainHP() {
		return pRemainHP;
	}
	public void setpRemainHP(int pRemainHP) {
		this.pRemainHP = pRemainHP;
	}
	public int geteRemainHP() {
		return eRemainHP;
	}
	public void seteRemainHP(int eRemainHP) {
		this.eRemainHP = eRemainHP;
	}
	public Enemy getEnemy() {
		return enemy;
	}
	public void setEnemy(Enemy enemy) {
		this.enemy = enemy;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	
	public List<String> getBattlelog() {
		return battlelog;
	}
	public void setBattlelog(List<String> battlelog) {
		this.battlelog = battlelog;
	}
	public int getTurn() {
		return turn;
	}
	public void setTurn(int turn) {
		this.turn = turn;
	}
	public int getStage() {
		return stage;
	}
	public void setStage(int stage) {
		this.stage = stage;
	}
	public String getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
}

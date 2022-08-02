package model;

import java.io.Serializable;

public class Enemy implements Serializable{
	private String enemy_name;
	private int getExp;
	private int lv;
	private int getMoney;
	private int[] status;
	private String type;
	private int[] dropItem;
	
	public Enemy() {}
	public Enemy(String enemy_name, int getExp, int lv, int getMoney, int[] status, String type, int[] dropItem) {
		this.enemy_name = enemy_name;
		this.getExp = getExp;
		this.lv = lv;
		this.getMoney = getMoney;
		this.status = status;
		this.type = type;
		this.dropItem = dropItem;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int[] getDropItem() {
		return dropItem;
	}
	public void setDropItem(int[] dropItem) {
		this.dropItem = dropItem;
	}
	public String getEnemy_name() {
		return enemy_name;
	}
	public void setEnemy_name(String enemy_name) {
		this.enemy_name = enemy_name;
	}
	public int getGetExp() {
		return getExp;
	}
	public void setGetExp(int getExp) {
		this.getExp = getExp;
	}
	public int getLv() {
		return lv;
	}
	public void setLv(int lv) {
		this.lv = lv;
	}
	public int getGetMoney() {
		return getMoney;
	}
	public void setGetMoney(int getMoney) {
		this.getMoney = getMoney;
	}
	public int[] getStatus() {
		return status;
	}
	public void setStatus(int[] status) {
		this.status = status;
	}

}

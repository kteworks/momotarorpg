package model;

import java.io.Serializable;

public class Player implements Serializable {
	private String account_name;
	private String job_name;
	private int exp;
	private int lv;
	private int money;
	private int[] status;
	private int[] item;
	
	public Player() {}
	public Player(String account_name, String job_name, int exp, int lv, int money, int[] status, int[] item) {
		this.account_name = account_name;
		this.job_name = job_name;
		this.exp = exp;
		this.lv = lv;
		this.money = money;
		this.status = status;
		this.item = item;
	}
	
	public String getAccount_name() {
		return account_name;
	}
	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}
	public String getJob_name() {
		return job_name;
	}
	public void setJob_name(String job_name) {
		this.job_name = job_name;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public int getLv() {
		return lv;
	}
	public void setLv(int lv) {
		this.lv = lv;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int[] getStatus() {
		return status;
	}
	public void setStatus(int[] status) {
		this.status = status;
	}
	public int[] getItem() {
		return item;
	}
	public void setItem(int[] item) {
		this.item = item;
	}
	
}

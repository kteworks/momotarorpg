package model;

import java.io.Serializable;

public class Account implements Serializable {

	private String name;
	private String pass;
	private int job_id;
	private int exp;
	private int lv;
	private int money;
	private int[] item;
	private int[] status;
	private int skillPoint;

	
	public Account(String name, String pass) {
		this.name = name;
		this.pass = pass;
	}
	public Account(String name, String pass, int job_id, int exp, int lv, int money, int skillPoint, int[] item, int[] status) {
		
		this.name = name;
		this.pass = pass;
		this.job_id = job_id;
		this.exp = exp;
		this.lv = lv;
		this.money = money;
		this.skillPoint = skillPoint;
		this.item = item;
		this.status = status;
	}
	
	
	
	public int getLv() {
		return lv;
	}
	public void setLv(int lv) {
		this.lv = lv;
	}
	public int getSkillPoint() {
		return skillPoint;
	}
	public void setSkillPoint(int skillPoint) {
		this.skillPoint = skillPoint;
	}
	public int[] getStatus() {
		return status;
	}

	public void setStatus(int[] status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getJob_id() {
		return job_id;
	}

	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int[] getItem() {
		return item;
	}

	public void setItem(int[] item) {
		this.item = item;
	}

}

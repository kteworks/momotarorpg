package model;

import java.io.Serializable;

public class BuyItem implements Serializable {
	
	private int price;
	private int item_id;
	private String itemName;
	
	public BuyItem() {}
	public BuyItem(String item_id) {
		this.item_id = Integer.parseInt(item_id);
	}
	public BuyItem(int item_id) {
		this.item_id = item_id;
	}
	public BuyItem(int price, int item_id, String buyItem) {
		this.price = price;
		this.item_id = item_id;
		this.itemName = buyItem;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}

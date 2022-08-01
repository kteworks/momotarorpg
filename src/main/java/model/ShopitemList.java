package model;

import java.io.Serializable;
import java.util.List;

public class ShopitemList implements Serializable {
	private List<String>[] ShopitemList;

	public ShopitemList(){}
	public ShopitemList(List<String>[] ShopitemList) {
		this.ShopitemList = ShopitemList;
		
}
	public List<String>[] getShopitemList() {
		return ShopitemList;
	}
	public void setShopitemList(List<String>[] ShopitemList) {
		this.ShopitemList = ShopitemList;
	}
	
}
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ItemList implements Serializable {

	private List<String> ItemList;

public ItemList(){}
public ItemList(ArrayList<String> ItemList) {
	this.ItemList = ItemList;
	
}
public List<String> getItemList() {
	return ItemList;
}
public void setItemList(ArrayList<String> ItemList) {
	this.ItemList = ItemList;
}


}
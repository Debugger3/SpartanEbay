package org.struts.model;

public class Items
{
	private String itemId;
	private String itemName; 
	private int rowItemId;
	Items(String itemId,String itemName,int rowItemId)
	{
		this.itemId=itemId;
		this.itemName=itemName;
		this.rowItemId=rowItemId;
	}
	public int getRowItemId() {
		return rowItemId;
	}
	public void setRowItemId(int rowItemId) {
		this.rowItemId = rowItemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
}
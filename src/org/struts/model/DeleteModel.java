package org.struts.model;

import java.util.*;

public class DeleteModel{
	private List<String> itemNameList;
	private ArrayList<Items> itemIdList1;//= new ArrayList<String>();
	private String itemName;
	private String itemId;
	public List<String> getItemIdList() {
		return itemNameList;
	}

	public void setItemIdList(ArrayList<String> itemIdList) {
		this.itemNameList = itemIdList;
	}
	public ArrayList<Items> getItemIdList1() {
		return itemIdList1;
	}
	
	public void setItemIdList1(ArrayList<Items> itemIdList1) {
		this.itemIdList1 = itemIdList1;
	}
	public void addItemIdList(String itemId,String itemName,int rowItemId) {
		Items it=new Items(itemId,itemName,rowItemId);
		if(itemIdList1==null)
			{
			itemIdList1=new ArrayList<Items>();
			}
		this.itemIdList1.add(it);
	    //System.out.println("this.itemIdList size"+this.itemIdList.size());
		//this.itemId=itemId;
	}
	public void addItemNameList(String itemName) {
		//Items it=new Items(itemId,itemName,rowItemId);
		if(itemNameList==null)
			{
			itemNameList=new ArrayList<String>();
			}
		itemNameList.add(itemName);
		//this.itemIdList.add(it);
	    //System.out.println("this.itemIdList size"+this.itemIdList.size());
		
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
	 
	
/*	private void assignValues(){
        if (.equals("A")){
            test2 = "A was chosen, do something";
        } else if (test1.equals("B")){
            test2 = "B was chosen, do something else";
        } else if (test1.equals("C")){
            test2 = "C was chosen, what's next?";
        }
	*/
	/*
	 * 
	 * 
	 * if (test1.length()>0)
            assignValues();
	 * */
	 
}

package org.struts.model;

import java.sql.Blob;
import java.util.ArrayList;

public class AddToCartModel {

	private ArrayList<Test> itemList;
	private String itemId,SellerId,offer;
	private int total_cost,cost,quantity,total_discount,final_total_cost,tax;
	public  static ArrayList<String> dealItemList;
	
	public ArrayList<Test> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<Test> itemList) {
		this.itemList = itemList;
	}

	
	public void addItemIdList(ArrayList<Test> t) {
	//	Item it=new Item(itemId,itemName);
		if(itemList==null)
			{
		itemList=new ArrayList<Test>();
			}
		this.itemList.addAll(t);
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getSellerId() {
		return SellerId;
	}

	public void setSellerId(String sellerId) {
		SellerId = sellerId;
	}

	public int getTotal_cost() {
		return total_cost;
	}

	public void setTotal_cost(int total_cost) {
		this.total_cost = total_cost;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getFinal_total_cost() {
		return final_total_cost;
	}

	public void setFinal_total_cost(int final_total_cost) {
		this.final_total_cost = final_total_cost;
	}

	public int getTotal_discount() {
		return total_discount;
	}

	public void setTotal_discount(int total_discount) {
		this.total_discount = total_discount;
	}

	
	public int getTax() {
		return tax;
	}

	public void setTax(int tax) {
		this.tax = tax;
	}

	public static ArrayList<String> getDealItemList() {
		return dealItemList;
	}

	public static void setDealItemList(ArrayList<String> dealItemList) {
		AddToCartModel.dealItemList = dealItemList;
	}

	public String getOffer() {
		return offer;
	}

	public void setOffer(String offer) {
		this.offer = offer;
	}

		
}

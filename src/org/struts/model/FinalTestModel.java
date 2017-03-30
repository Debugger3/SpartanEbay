package org.struts.model;

public class FinalTestModel {
	private int sno;
	
	private String sellerId,sellerName;
	private Float avgPrice;
	
	private String itemId,dealId,freeItemId;
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getDealId() {
		return dealId;
	}
	public void setDealId(String dealId) {
		this.dealId = dealId;
	}
	public String getFreeItemId() {
		return freeItemId;
	}
	public void setFreeItemId(String freeItemId) {
		this.freeItemId = freeItemId;
	}
	public String getSellerId() {
		return sellerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public Float getAvgPrice() {
		return avgPrice;
	}
	public void setAvgPrice(Float avgPrice) {
		this.avgPrice = avgPrice;
	}
}

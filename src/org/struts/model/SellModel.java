package org.struts.model;

import java.util.ArrayList;

public class SellModel {
private String itemId,itemName,itemWeight,sellerId,sellerAddress,srNo,sellerName;
private ArrayList<SellModel> reportList;

public String getItemName() {
	return itemName;
}

public void setItemName(String itemName) {
	this.itemName = itemName;
}

public String getItemWeight() {
	return itemWeight;
}

public void setItemWeight(String itemWeight) {
	this.itemWeight = itemWeight;
}

public String getItemId() {
	return itemId;
}

public void setItemId(String itemId) {
	this.itemId = itemId;
}

public String getSellerAddress() {
	return sellerAddress;
}

public void setSellerAddress(String sellerAddress) {
	this.sellerAddress = sellerAddress;
}

public String getSrNo() {
	return srNo;
}

public void setSrNo(String srNo) {
	this.srNo = srNo;
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

public ArrayList<SellModel> getReportList() {
	return reportList;
}

public void setReportList(ArrayList<SellModel> reportList) {
	this.reportList = reportList;
}
}

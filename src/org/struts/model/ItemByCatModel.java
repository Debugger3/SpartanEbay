package org.struts.model;
import java.sql.Blob;
import java.util.ArrayList;
public class ItemByCatModel {
	private String itemCatId,itemSubCatId;
	private String itemId,itemName,itemDesc,cost,seller_id,imagePath,image64encode;
	private String catName,subCatName,color,itemId1,itemId2,itemId3;
	private String dealCheck;
	private Blob photo;
	
	private byte[] blobAsBytes;
	private ArrayList<ItemByCatModel> itemList;
	private ArrayList<ItemByCatModel> itemList2;
	private  ArrayList<String> dealItemList;
	private boolean dealflag;
	private double rating;
	private int discount,quantity,dealCounter,ratingCount;
	private String expiryOn,cartFlag="false",quantFlag="false";
	//Lab test 
	
		private String startDate,endDate;
		
		//lAB TEST
	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Blob getPhoto() {
		return photo;
	}

	public void setPhoto(Blob photo) {
		this.photo = photo;
	}


	public byte[] getBlobAsBytes() {
		return blobAsBytes;
	}

	public void setBlobAsBytes(byte[] blobAsBytes) {
		this.blobAsBytes = blobAsBytes;
	}

	public ArrayList<ItemByCatModel> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<ItemByCatModel> itemList) {
		this.itemList = itemList;
	}

	public String getItemCatId() {
		return itemCatId;
	}

	public void setItemCatId(String itemCatId) {
		this.itemCatId = itemCatId;
	}

	public String getItemSubCatId() {
		return itemSubCatId;
	}

	public void setItemSubCatId(String itemSubCatId) {
		this.itemSubCatId = itemSubCatId;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public String getSubCatName() {
		return subCatName;
	}

	public void setSubCatName(String subCatName) {
		this.subCatName = subCatName;
	}

	public String getImage64encode() {
		return image64encode;
	}

	public void setImage64encode(String image64encode) {
		this.image64encode = image64encode;
	}



	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getExpiryOn() {
		return expiryOn;
	}

	public void setExpiryOn(String expiryOn) {
		this.expiryOn = expiryOn;
	}

	public ArrayList<ItemByCatModel> getItemList2() {
		return itemList2;
	}

	public void setItemList2(ArrayList<ItemByCatModel> itemList2) {
		this.itemList2 = itemList2;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getDealCounter() {
		return dealCounter;
	}

	public void setDealCounter(int dealCounter) {
		this.dealCounter = dealCounter;
	}

	public String getItemId3() {
		return itemId3;
	}

	public void setItemId3(String itemId3) {
		this.itemId3 = itemId3;
	}

	public String getItemId1() {
		return itemId1;
	}

	public void setItemId1(String itemId1) {
		this.itemId1 = itemId1;
	}

	public String getItemId2() {
		return itemId2;
	}

	public void setItemId2(String itemId2) {
		this.itemId2 = itemId2;
	}

	public String getDealCheck() {
		return dealCheck;
	}

	public void setDealCheck(String dealCheck) {
		this.dealCheck = dealCheck;
	}

	public boolean getDealflag() {
		return dealflag;
	}

	public void setDealflag(boolean dealflag) {
		this.dealflag = dealflag;
	}

	public ArrayList<String> getDealItemList() {
		return dealItemList;
	}

	public void setDealItemList(ArrayList<String> dealItemList) {
		this.dealItemList = dealItemList;
	}

	public String getCartFlag() {
		return cartFlag;
	}

	public void setCartFlag(String cartFlag) {
		this.cartFlag = cartFlag;
	}

	public String getQuantFlag() {
		return quantFlag;
	}

	public void setQuantFlag(String quantFlag) {
		this.quantFlag = quantFlag;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public int getRatingCount() {
		return ratingCount;
	}

	public void setRatingCount(int ratingCount) {
		this.ratingCount = ratingCount;
	}

	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


}

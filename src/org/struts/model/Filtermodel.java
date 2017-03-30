package org.struts.model;

import java.sql.Blob;
import java.util.ArrayList;

public class Filtermodel {
	
	String checkMe;
	String checkMe1;
	String checkMe2;
	String catId;
	String subcatId;
	 String color;
	public String getSubcatId() {
		return subcatId;
	}
	public void setSubcatId(String subcatId) {
		this.subcatId = subcatId;
	}
	public String getCatId() {
		return catId;
	}
	public void setCatId(String catId) {
		this.catId = catId;
	}

	private String itemCatId,itemSubCatId;
	private String itemId,itemName,itemDesc,cost,seller_id,imagePath,image64encode;
	private String catName,subCatName;
	private Blob photo;
	private byte[] blobAsBytes;
	private ArrayList<Filtermodel> itemList;
	public String getCheckMe() {
		return checkMe;
	}
	public void setCheckMe(String checkMe) {
		this.checkMe = checkMe;
	}
	public String getCheckMe1() {
		return checkMe1;
	}
	public void setCheckMe1(String checkMe1) {
		this.checkMe1 = checkMe1;
	}
	public String getCheckMe2() {
		return checkMe2;
	}
	public void setCheckMe2(String checkMe2) {
		this.checkMe2 = checkMe2;
	}
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

	public ArrayList<Filtermodel> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<Filtermodel> itemList) {
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
	public void setColor(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}


	
}

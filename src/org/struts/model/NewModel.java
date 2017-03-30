package org.struts.model;

import java.sql.Blob;
import java.util.ArrayList;

public class NewModel {
	private String itemId,itemName,itemDesc,cost,seller_id,imagePath,image64encode;
	private Blob photo;
	private byte[] blobAsBytes;
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
	
	public String getImage64encode() {
		return image64encode;
	}

	public void setImage64encode(String image64encode) {
		this.image64encode = image64encode;
	}


}

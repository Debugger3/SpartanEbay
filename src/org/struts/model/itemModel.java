package org.struts.model;

import java.sql.Blob;
import java.util.ArrayList;

public class itemModel {
	private String itemCatId,brand,advCheck,subCatId,addField1,addField2;
	private String itemId,itemName,itemDesc,seller_id,imagePath,image64encode;
	private String catName,subCatName,color,weight,conditionoftheitem;
	private int quantity,warrantyperiod,cost,itemSubCatId;
	private Blob photo;
	
	private byte[] blobAsBytes;
	private ArrayList<itemModel> itemList;
	private String attrkey1,attrval1;
	private String attrkey2,attrval2;
	private String attrkey3,attrval3;
	private String attrkey4,attrval4;
	private String attrkey5,attrval5;
	private String dealflag;
	private int discount;
	private String expiryOn;

	//Lab test 
	
	private String startDate,endDate;
	
	//lAB TEST
	public String getAttrkey1() {
		return attrkey1;
	}
	public void setAttrkey1(String attrkey1) {
		this.attrkey1 = attrkey1;
	}
	public String getAttrval1() {
		return attrval1;
	}
	public void setAttrval1(String attrval1) {
		this.attrval1 = attrval1;
	}
	public String getAttrkey2() {
		return attrkey2;
	}
	public void setAttrkey2(String attrkey2) {
		this.attrkey2 = attrkey2;
	}
	public String getAttrval2() {
		return attrval2;
	}
	public void setAttrval2(String attrval2) {
		this.attrval2 = attrval2;
	}
	public String getAttrkey3() {
		return attrkey3;
	}
	public void setAttrkey3(String attrkey3) {
		this.attrkey3 = attrkey3;
	}
	public String getAttrval3() {
		return attrval3;
	}
	public void setAttrval3(String attrval3) {
		this.attrval3 = attrval3;
	}
	public String getAttrkey4() {
		return attrkey4;
	}
	public void setAttrkey4(String attrkey4) {
		this.attrkey4 = attrkey4;
	}
	public String getAttrval4() {
		return attrval4;
	}
	public void setAttrval4(String attrval4) {
		this.attrval4 = attrval4;
	}
	public String getAttrkey5() {
		return attrkey5;
	}
	public void setAttrkey5(String attrkey5) {
		this.attrkey5 = attrkey5;
	}
	public String getAttrval5() {
		return attrval5;
	}
	public void setAttrval5(String attrval5) {
		this.attrval5 = attrval5;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		//System.out.println("iddiididiididi");
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

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
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

	public ArrayList<itemModel> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<itemModel> itemList) {
		this.itemList = itemList;
	}

	public String getItemCatId() {
		return itemCatId;
	}

	public void setItemCatId(String itemCatId) {
		this.itemCatId = itemCatId;
	}

	public int getItemSubCatId() {
		return itemSubCatId;
	}

	public void setItemSubCatId(int itemSubCatId) {
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

	

	public void setDealflag(String dealflag) {
		this.dealflag = dealflag;
	}

	public String getDealflag() {
		return dealflag;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getAdvCheck() {
		return advCheck;
	}

	public void setAdvCheck(String advCheck) {
		this.advCheck = advCheck;
	}

	public String getSubCatId() {
		return subCatId;
	}

	public void setSubCatId(String subCatId) {
		this.subCatId = subCatId;
	}

	public String getAddField1() {
		return addField1;
	}

	public void setAddField1(String addField1) {
		this.addField1 = addField1;
	}

	public String getAddField2() {
		return addField2;
	}

	public void setAddField2(String addField2) {
		this.addField2 = addField2;
	}

	public int getWarrantyperiod() {
		return warrantyperiod;
	}

	public void setWarrantyperiod(int warrantyperiod) {
		this.warrantyperiod = warrantyperiod;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getConditionoftheitem() {
		return conditionoftheitem;
	}

	public void setConditionoftheitem(String conditionoftheitem) {
		this.conditionoftheitem = conditionoftheitem;
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

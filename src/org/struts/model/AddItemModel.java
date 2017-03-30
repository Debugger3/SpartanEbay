package org.struts.model;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class AddItemModel {
	private String itemId,itemName,itemDesc,picPath,test,item;
	private String sellerId,advCheck,categoryId,subCatId,addField1,addField2;
	private int price;
	private String categoryName,subCatName;
	private ArrayList<CategoryModel> categoryList; 
	//private ArrayList<SubCatModel> subCatList;
	private Map<String,String> subCatList;
	private File pic;
	private String attrkey1,attrval1;
	private String attrkey2,attrval2;
	private String attrkey3,attrval3;
	private String attrkey4,attrval4;
	private String attrkey5,attrval5;
	private String expiryOn,dealFlag;
	private int discount;
	private int quantity,adv_Cost;
	private String warranty,color,weight,brand,condition;
	private String startDate,endDate;
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
public String getPicPath() {
	return picPath;
}
public void setPicPath(String picPath) {
	
	this.picPath = picPath;  
}
public String getAddField2() {
	return addField2;
}
public void setAddField2(String addField2) {
	this.addField2 = addField2;
}
public String getAddField1() {
	return addField1;
}
public void setAddField1(String addField1) {
	this.addField1 = addField1;
}
public String getAdvCheck() {
	return advCheck;
}
public void setAdvCheck(String advCheck) {
	this.advCheck = advCheck;
}
public String getSellerId() {
	return sellerId;
}
public void setSellerId(String sellerId) {
	this.sellerId = sellerId;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}

public File getPic() {
	return pic;
}
public void setPic(File pic) {

		 this.pic=pic;
		 System.out.println("pic.getAbsolutePath()->"+pic.getAbsolutePath());
		 System.out.println("pic.getAbsolutePath()->"+pic.getPath());
}
public String getTest() {
	return test;
}
public void setTest(String test) {
	this.test = test;
}
public String getItem() {
	return item;
}
public void setItem(String item) {
	this.item = item;
}
public String getCategoryId() {
	return categoryId;
}
public void setCategoryId(String categoryId) {
	this.categoryId = categoryId;
}
public String getSubCatId() {
	return subCatId;
}
public void setSubCatId(String subCatId) {
	this.subCatId = subCatId;
}
public ArrayList<CategoryModel> getCategoryList() {
	return categoryList;
}
public void setCategoryList(ArrayList<CategoryModel> categoryList) {
	this.categoryList = categoryList;
}
public Map<String,String> getSubCatList() {
	return subCatList;
}
public void setSubCatList(Map<String,String> subCatList) {
	this.subCatList = subCatList;
}
public String getCategoryName() {
	return categoryName;
}
public void setCategoryName(String categoryName) {
	this.categoryName = categoryName;
}
public void addCategoryList(String categoryId,String categoryName)
{
	if(categoryList==null)
		categoryList=new ArrayList<CategoryModel>();
	if(subCatList==null)
		subCatList=new HashMap<String,String>();
	CategoryModel cm=new CategoryModel(categoryId,categoryName,null);
	categoryList.add(cm);
}

public String getExpiryOn() {
	return expiryOn;
}
public void setExpiryOn(String expireOn) {
	this.expiryOn = expireOn;
}
public int getDiscount() {
	return discount;
}
public void setDiscount(int discount) {
	this.discount = discount;
}
public String getDealFlag() {
	return dealFlag;
}
public void setDealFlag(String dealFlag) {
	this.dealFlag = dealFlag;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public String getWarranty() {
	System.out.println("i m here for get warranty");
	return warranty;
}
public void setWarranty(String warranty) {
	System.out.println("i m here for set warranty");
	this.warranty = warranty;
}
public String getColor() {
	System.out.println("i m here for get color");
	return color;
}
public void setColor(String color) {
	System.out.println("i m here for set color");
	this.color = color;
}
public String getWeight() {
	System.out.println("i m here for get weight");
	return weight;
}
public void setWeight(String weight) {
	System.out.println("i m here for set weight");
	this.weight = weight;
}
public String getBrand() {
	System.out.println("i m here for get band");
	return brand;
}
public void setBrand(String brand) {
	System.out.println("i m here for set band");
	this.brand = brand;
}
public String getCondition() {
	System.out.println("i m here for get condition");
	return condition;
}
public void setCondition(String condition) {
	System.out.println("i m here for set condition");
	this.condition = condition;
}
public int getAdv_Cost() {
	System.out.println("i m here for get subcat");
	return adv_Cost;
}
public void setAdv_Cost(int adv_Cost) {
	System.out.println("i m here for set advcost");
	this.adv_Cost = adv_Cost;
}

public String getSubCatName() {
	System.out.println("i m here for get subcat");
	return subCatName;
}
public void setSubCatName(String subCatName) {
	System.out.println("i m here for set subcat");
	this.subCatName = subCatName;
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

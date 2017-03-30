package org.struts.model;

import java.io.File;
import java.util.*;

public class EditModel{
	
	private List<String> itemNameList;
	private ArrayList<Items> itemIdList1;//= new ArrayList<String>();
	private ArrayList<itemModel> itemList = new ArrayList<itemModel>();
	
	private String itemId,itemName,itemDesc,picPath,test,item;
	private String sellerId,advCheck,categoryId,addField1,addField2;
	private int price;
	private String categoryName;
	private String attrkey1,attrval1;
	private String attrkey2,attrval2;
	private String attrkey3,attrval3;
	private String attrkey4,attrval4;
	private String attrkey5,attrval5;
	private ArrayList<CategoryModel> categoryList; 
	//private ArrayList<SubCatModel> subCatList;
	private Map<String,String> subCatList;
	private File pic;
	private String expiryOn,dealFlag;
	private int discount,subCatId;
	private int quantity,warranty;
	private String color,weight,brand,condition;
	private String expiryDate;
	
	
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

	public ArrayList<itemModel> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<itemModel> itemList) {
		this.itemList = itemList;
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

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getAdvCheck() {
		return advCheck;
	}

	public void setAdvCheck(String advCheck) {
		this.advCheck = advCheck;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public int getSubCatId() {
		return subCatId;
	}

	public void setSubCatId(int subCatId) {
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
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

	public File getPic() {
		return pic;
	}

	public void setPic(File pic) {
		this.pic = pic;
	}

	public String getExpiryOn() {
		return expiryOn;
	}

	public void setExpireOn(String expiryOn) {
		this.expiryOn = expiryOn;
	}

	public String getDealFlag() {
		return dealFlag;
	}

	public void setDealFlag(String dealFlag) {
		this.dealFlag = dealFlag;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getWarranty() {
		return warranty;
	}

	public void setWarranty(int warranty) {
		this.warranty = warranty;
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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
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

package org.struts.model;
import java.util.*;
public class CallModel
{
	private String categoryId;
	private String categoryName;
	private ArrayList<CategoryModel> categoryList; 
	//private ArrayList<SubCatModel> subCatList;
	private Map<String,String> subCatList;
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public ArrayList<CategoryModel> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(ArrayList<CategoryModel> categoryList) {
		this.categoryList = categoryList;
	}
	
	public void addCategoryList(String categoryId,String categoryName)
	{
		if(categoryList==null)
			categoryList=new ArrayList<CategoryModel>();
		CategoryModel cm=new CategoryModel(categoryId,categoryName,null);
		categoryList.add(cm);
	}
	
	public String getCategoryName() {
		return categoryName;
	}
	
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Map<String,String> getSubCatList() {
		return subCatList;
	}
	public void setSubCatList(Map<String,String> subCatList) {
		this.subCatList = subCatList;
	}
	
	
}



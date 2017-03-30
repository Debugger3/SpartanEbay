package org.struts.model;
import java.util.ArrayList;
public class CategoryModel {
	private String catName;
	private String catId;
	private ArrayList<SubCatModel> subCatList;
	
	public CategoryModel()
	{
		
	}
	CategoryModel(String catId,String catName,ArrayList<SubCatModel> subCatList)
	{
		this.catId=catId;
		this.catName=catName;
		this.subCatList=subCatList;
	}
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	public String getCatId() {
		return catId;
	}
	public void setCatId(String catId) {
		this.catId = catId;
	}
	public ArrayList<SubCatModel> getSubCatList() {
		return subCatList;
	}
	public void setSubCatList(ArrayList<SubCatModel> subCatList) {
		this.subCatList = subCatList;
	}
	
}

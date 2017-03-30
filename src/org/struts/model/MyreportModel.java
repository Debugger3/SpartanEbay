package org.struts.model;

import java.util.ArrayList;

public class MyreportModel {
	private String reportcat;
  	private String itemname;
  	private String sellerid;
  	private String itemId;
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





	private String sellerAddress;
	public String getItemname() {
		return itemname;
	}


	public void setItemname(String itemname) {
		this.itemname = itemname;
	}


	public String getSellerid() {
		return sellerid;
	}


	public void setSellerid(String sellerid) {
		this.sellerid = sellerid;
	}


	


	private ArrayList<MyreportModel> reportList;
	public ArrayList<MyreportModel> getReportList() {
		return reportList;
	}


	public void setReportList(ArrayList<MyreportModel> reportList) {
		this.reportList = reportList;
	}


	public String getReportcat() {
	return reportcat;
}


public void setReportcat(String reportcat) {
	this.reportcat = reportcat;
}


}

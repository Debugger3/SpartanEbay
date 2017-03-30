package org.struts.service;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

import javax.mail.Session;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.tomcat.util.codec.binary.Base64;
import org.struts.model.DeleteModel;
import org.struts.model.EditModel;
import org.struts.model.ItemByCatModel;
import org.struts.model.Items;
import org.struts.model.itemModel;
import org.struts.utils.ConnectionPool;

public class EditItemService {
	
	private ArrayList<itemModel> itemList = new ArrayList<itemModel>();
	private int quantity;
	@SuppressWarnings("null")
	public void Update(EditModel dm) throws SQLException
	{
		System.out.println("In update method");
		
		System.out.println(dm.getPic());
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("update", "yes");
		
			
			ArrayList<itemModel> dvds = (ArrayList<itemModel>)session.getAttribute("editItemList");
		System.out.println(dvds.size()+"XXXXXXXXXXXXXXX"+dvds.get(0).getAttrkey1());
		
		System.out.println("Starting updates");
		try{
			if(ConnectionPool.con==null)
				ConnectionPool.con=ConnectionPool.getConnection();
		
		
			String query=null;
			
			String id = dvds.get(0).getItemId();
			
			if( (dvds.get(0).getAttrkey1()==null && dm.getAttrkey1() !=null) || !(dvds.get(0).getAttrkey1().equals(dm.getAttrkey1()) ))
			{
				
				query="update attribute set attrkey1=? where itemId=?";
				PreparedStatement ps= ConnectionPool.con.prepareStatement(query);
				ps.setString(1, dm.getAttrkey1());
				ps.setString(2, id);
				
				
				
				ps.executeUpdate();
			}
			if( (dvds.get(0).getAttrval1()==null && dm.getAttrval1() !=null) || !(dvds.get(0).getAttrval1().equals(dm.getAttrval1()) ))
			{
				
				query="update attribute set attrval1=? where itemId=?";
				PreparedStatement ps= ConnectionPool.con.prepareStatement(query);
				ps.setString(1, dm.getAttrval1());
				ps.setString(2, id);
				
				
				
				ps.executeUpdate();
			}
			if( (dvds.get(0).getAttrkey2()==null && dm.getAttrkey2() !=null) || !(dvds.get(0).getAttrkey2().equals(dm.getAttrkey2()) ))
			{
				
				query="update attribute set attrkey2=? where itemId=?";
				PreparedStatement ps= ConnectionPool.con.prepareStatement(query);
				ps.setString(1, dm.getAttrkey2());
				ps.setString(2, id);
				
				
				
				ps.executeUpdate();
			}
			if( (dvds.get(0).getAttrval2()==null && dm.getAttrval2() !=null) || !(dvds.get(0).getAttrval2().equals(dm.getAttrval2()) ))
			{
				
				query="update attribute set attrval2=? where itemId=?";
				PreparedStatement ps= ConnectionPool.con.prepareStatement(query);
				ps.setString(1, dm.getAttrval2());
				ps.setString(2, id);
				
				
				
				ps.executeUpdate();
			}
			if( (dvds.get(0).getAttrkey3()==null && dm.getAttrkey3() !=null) || !(dvds.get(0).getAttrkey3().equals(dm.getAttrkey3()) ))
			{
				
				query="update attribute set attrkey3=? where itemId=?";
				PreparedStatement ps= ConnectionPool.con.prepareStatement(query);
				ps.setString(1, dm.getAttrkey3());
				ps.setString(2, id);
				
				
				
				ps.executeUpdate();
			}
			if( (dvds.get(0).getAttrval3()==null && dm.getAttrval3() !=null) || !(dvds.get(0).getAttrval3().equals(dm.getAttrval3()) ))
			{
				
				query="update attribute set attrval3=? where itemId=?";
				PreparedStatement ps= ConnectionPool.con.prepareStatement(query);
				ps.setString(1, dm.getAttrval3());
				ps.setString(2, id);
				
				
				
				ps.executeUpdate();
			}
			if( (dvds.get(0).getAttrkey4()==null && dm.getAttrkey4() !=null) || !(dvds.get(0).getAttrkey4().equals(dm.getAttrkey4()) ))
			{
				
				query="update attribute set attrkey4=? where itemId=?";
				PreparedStatement ps= ConnectionPool.con.prepareStatement(query);
				ps.setString(1, dm.getAttrkey4());
				ps.setString(2, id);
				
				
				
				ps.executeUpdate();
			}
			if( (dvds.get(0).getAttrval4()==null && dm.getAttrval4() !=null) || !(dvds.get(0).getAttrval4().equals(dm.getAttrval4()) ))
			{
				
				query="update attribute set attrval4=? where itemId=?";
				PreparedStatement ps= ConnectionPool.con.prepareStatement(query);
				ps.setString(1, dm.getAttrval4());
				ps.setString(2, id);
				
				
				
				ps.executeUpdate();
			}
			if( (dvds.get(0).getAttrkey5()==null && dm.getAttrkey5() !=null) || !(dvds.get(0).getAttrkey5().equals(dm.getAttrkey5()) ))
			{
				
				query="update attribute set attrkey5=? where itemId=?";
				PreparedStatement ps= ConnectionPool.con.prepareStatement(query);
				ps.setString(1, dm.getAttrkey5());
				ps.setString(2, id);
				
				
				
				ps.executeUpdate();
			}
			if( (dvds.get(0).getAttrval5()==null && dm.getAttrval5() !=null) || !(dvds.get(0).getAttrval5().equals(dm.getAttrval5()) ))
			{
				
				query="update attribute set attrval5=? where itemId=?";
				PreparedStatement ps= ConnectionPool.con.prepareStatement(query);
				ps.setString(1, dm.getAttrval5());
				ps.setString(2, id);
				
				
				
				ps.executeUpdate();
			}
			if((dvds.get(0).getItemName()==null && dm.getItemName() !=null) || !(dvds.get(0).getItemName().equals(dm.getItemName())))
			{
				
				query="update item set item_name=? where itemId=?";
				PreparedStatement ps= ConnectionPool.con.prepareStatement(query);
				ps.setString(1, dm.getItemName());
				ps.setString(2, id);
				
				
				
				ps.executeUpdate();
			}
			if((dvds.get(0).getItemDesc() == null && dm.getItemDesc() != null) || !(dvds.get(0).getItemDesc().equals(dm.getItemDesc())))
			{
				
				query="update item set item_desc=? where itemId=?";
				PreparedStatement ps= ConnectionPool.con.prepareStatement(query);
				ps.setString(1, dm.getItemDesc());
				ps.setString(2, id);
				
				
				
				ps.executeUpdate();
			}
			if((dvds.get(0).getSeller_id() ==null && dm.getSellerId() !=null) || !(dvds.get(0).getSeller_id().equals(dm.getSellerId())) )
			{
				System.out.println("xxxxxxxxxxxxxxxxxX");
				query="update item set seller_id=? where itemId=?";
				PreparedStatement ps= ConnectionPool.con.prepareStatement(query);
				ps.setString(1, dm.getSellerId());
				ps.setString(2, id);
				
				
				
				ps.executeUpdate();
			}
			if(dvds.get(0).getCost() != dm.getPrice())
			{
				System.out.println("xxxxxxxxxxxxxxxxxX");
				query="update item set cost=? where itemId=?";
				PreparedStatement ps= ConnectionPool.con.prepareStatement(query);
				ps.setInt(1, dm.getPrice());
				ps.setString(2, id);
				
				
				
				ps.executeUpdate();
			}
			if(dvds.get(0).getQuantity() != dm.getQuantity())
			{
				System.out.println("xxxxxxxxxxxxxxxxxX");
				query="update item set quantity=? where itemId=?";
				PreparedStatement ps= ConnectionPool.con.prepareStatement(query);
				ps.setInt(1, dm.getQuantity());
				ps.setString(2, id);
				
				
				
				ps.executeUpdate();
			}
			
			if(!(dvds.get(0).getDealflag().equals(dm.getDealFlag())) && dm.getDealFlag()!=null)
			{
				System.out.println("xxxxxyyyyyyyyyyxxxxxxxxxxxxX");
				query="update item set dealFlag=?,avail=? where itemId=?";
				PreparedStatement ps= ConnectionPool.con.prepareStatement(query);
				ps.setString(1, dm.getDealFlag());
				ps.setString(2, dm.getDealFlag());
				ps.setString(3, id);
				
				
				
				ps.executeUpdate();
			}
			if(!(dvds.get(0).getItemCatId().equals(dm.getCategoryId())) && !(dm.getCategoryId().equals("0")))
			{
				System.out.println("cat updatexxxxxyyyyyyyyyyxxxxxxxxxxxxX");
				System.out.println(dvds.get(0).getItemCatId());
				System.out.println(dm.getCategoryId());
				query="update item set ItemCatId=? where itemId=?";
				PreparedStatement ps= ConnectionPool.con.prepareStatement(query);
				ps.setString(1, dm.getCategoryId());
				ps.setString(2, id);
				
				
				
				ps.executeUpdate();
			}
			System.out.println("subcatid is:"+dvds.get(0).getSubCatId());
			if(dvds.get(0).getItemSubCatId() != dm.getSubCatId() && dm.getSubCatId() !=0 ){
				System.out.println("subcatexxxxxyyyyyyyyyyxxxxxxxxxxxxX");
				System.out.println(dvds.get(0).getItemCatId());
				System.out.println(dm.getCategoryId());
				query="update item set subCat_Id=? where itemId=?";
				PreparedStatement ps= ConnectionPool.con.prepareStatement(query);
				ps.setInt(1, dm.getSubCatId());
				ps.setString(2, id);
				
				
				
				ps.executeUpdate();
			}
			if(!(dvds.get(0).getAddField1().equals(dm.getAddField1())) && dm.getAddField1()!=null)
			{
				System.out.println("xxxxxyyyyyyyyyyxxxxxxxxxxxxX");
				query="update item set field1=? where itemId=?";
				PreparedStatement ps= ConnectionPool.con.prepareStatement(query);
				ps.setString(1, dm.getAddField1());
				ps.setString(2, id);
				
				
				
				ps.executeUpdate();
			}
			if(!(dvds.get(0).getAddField2().equals(dm.getAddField2())) && dm.getAddField2()!=null)
			{
				
				query="update item set field2=? where itemId=?";
				PreparedStatement ps= ConnectionPool.con.prepareStatement(query);
				ps.setString(1, dm.getAddField2());
				ps.setString(2, id);
				
				
				
				ps.executeUpdate();
			}
			System.out.println(dm.getAdvCheck()+"\n"+dvds.get(0).getAdvCheck());
			if(!(dvds.get(0).getAdvCheck().equals(dm.getAdvCheck())) && dm.getAdvCheck()!=null && !(dm.getAdvCheck().equals("0")))
			{
				
				query="update item set advertisementItem=? where itemId=?";
				PreparedStatement ps= ConnectionPool.con.prepareStatement(query);
				ps.setString(1, dm.getAdvCheck());
				ps.setString(2, id);
				
				
				
				ps.executeUpdate();
			}
			
			
			if(dvds.get(0).getDiscount()!=dm.getDiscount())
			{
				
				query="update item set discount=? where itemId=?";
				PreparedStatement ps= ConnectionPool.con.prepareStatement(query);
				ps.setInt(1, dm.getDiscount());
				ps.setString(2, id);
				
				
				
				ps.executeUpdate();
			}
			if((dvds.get(0).getExpiryOn()==null && dm.getExpiryOn()!=null) || (!(dvds.get(0).getExpiryOn().equals(dm.getExpiryOn()))))
			{
				System.out.println("xxxxxxxxxxxxxxxxxX");
				query="update item set expiryOn=? where itemId=?";
				PreparedStatement ps= ConnectionPool.con.prepareStatement(query);
				//ps.setString(1, dm.getExpireOn());
				DateFormat formatter = new SimpleDateFormat("YYYY-MM-DD");
				//if(dm.getExpiryOn()!=null)
				//ps.setDate(1, new java.sql.Date(formatter.parse(dm.getExpiryOn().substring(0, 10)).getTime()));
				//ps.setString(2, id);
				
				
				
				//ps.executeUpdate();
			}
			if(dvds.get(0).getWarrantyperiod()!=dm.getWarranty() )
			{
				
				query="update item set warrantyperiod=? where itemId=?";
				PreparedStatement ps= ConnectionPool.con.prepareStatement(query);
				ps.setInt(1, dm.getWarranty());
				ps.setString(2, id);
				
				
				
				ps.executeUpdate();
			}
			if((dvds.get(0).getWeight() == null  && dm.getWeight()!=null) || !(dvds.get(0).getWeight().equals(dm.getWeight()))  )
			{
				
				query="update item set weight=? where itemId=?";
				PreparedStatement ps= ConnectionPool.con.prepareStatement(query);
				ps.setString(1, dm.getWeight());
				ps.setString(2, id);
				
				
				
				ps.executeUpdate();
			}
			
			if((dvds.get(0).getColor()==null && dm.getColor()!=null) || !(dvds.get(0).getColor().equals(dm.getColor())))
			{
				System.out.println("updating color");
				query="update item set color=? where itemId=?";
				PreparedStatement ps= ConnectionPool.con.prepareStatement(query);
				ps.setString(1, dm.getColor());
				ps.setString(2, id);
				
				
				
				ps.executeUpdate();
			}
			if(((dvds.get(0).getConditionoftheitem()==null) && dm.getCondition()!=null) || !(dvds.get(0).getConditionoftheitem().equals(dm.getCondition())))
			{
				System.out.println("xxxxxxxxxxxxxxxxxX");
				query="update item set conditionoftheitem=? where itemId=?";
				PreparedStatement ps= ConnectionPool.con.prepareStatement(query);
				ps.setString(1, dm.getCondition	());
				ps.setString(2, id);
				
				
				
				ps.executeUpdate();
			}
			if(((dvds.get(0).getBrand()==null) && dm.getBrand()!=null) || !(dvds.get(0).getBrand().equals(dm.getBrand())))
			{
				System.out.println("xxxxxxxxxxxxxxxxxX");
				query="update item set brand=? where itemId=?";
				PreparedStatement ps= ConnectionPool.con.prepareStatement(query);
				ps.setString(1, dm.getBrand	());
				ps.setString(2, id);
				
				
				
				ps.executeUpdate();
			}
			//item id update in last
			if(!(dvds.get(0).getItemId().equals(dm.getItemId())))
			{
				System.out.println("xxxxxxxxxxxxxxxxxX");
				query="update item set itemId=? where itemId=?";
				PreparedStatement ps= ConnectionPool.con.prepareStatement(query);
				ps.setString(1, dm.getItemId());
				ps.setString(2, id);
				
				
				
				ps.executeUpdate();
			}
			
			
		}
		 catch (SQLException e1) {
				e1.printStackTrace();
			}
		 catch (Exception e1) {
				e1.printStackTrace();
		}
	}
public void listItemKey(EditModel dm)
{
	try
	{
	if(ConnectionPool.con==null)
		ConnectionPool.con=ConnectionPool.getConnection();
	Statement stmt = ConnectionPool.con.createStatement();
	System.out.println("dm.getItemId() "+ dm.getItemId());
	HttpSession session = ServletActionContext.getRequest().getSession();

	String userId = session.getAttribute("user").toString();
	ResultSet rs = stmt.executeQuery("SELECT itemId, item_name,rowItemId from item where seller_id='"+userId+"'");
	while (rs.next()) {
		  String itemId = rs.getString(1);
		  String itemName ="";// rs.getString(2);
		  //System.out.println("Item id is : "+itemId + "\n");
		  dm.addItemIdList(itemId,itemName,rs.getInt(3));
		}
	
		if(dm.getItemId()!=null)
		{
		ResultSet rs1 = stmt.executeQuery("SELECT itemId, item_name,rowItemId from item where itemId='"+dm.getItemId()+"';");
		System.out.println("dm.getItemId() --->"+dm.getItemId());
		while (rs1.next()) {
			  String itemId = rs1.getString(1);
			  String itemName = rs1.getString(2);
			  System.out.println("Item id is here : "+itemId + "\n");
			  if(itemId.equals(dm.getItemId()))
				  {
				  dm.setItemName(itemName);
				  
				  }
			  //System.out.println(dm.getItemIdList1().size());
			}
		}
	}
	 catch (SQLException e1) {
			e1.printStackTrace();
		}
	 catch (Exception e1) {
			e1.printStackTrace();
	}
 
}
public void editItem(EditModel dm)
{
	setItemList(new ArrayList<itemModel>());
	HttpSession session = ServletActionContext.getRequest().getSession();
	
	try
	{
	if(ConnectionPool.con==null)
		ConnectionPool.con=ConnectionPool.getConnection();
	System.out.println("attttttrrrrribute");
	String queryAttr ="select attrkey1,attrval1,attrkey2,attrval2,attrkey3,attrval3,attrkey4,attrval4,attrkey5,attrval5 from attribute  where itemId=?";
	PreparedStatement psAttr= ConnectionPool.con.prepareStatement(queryAttr);
	psAttr.setString(1,dm.getItemId() );
	ArrayList<String> attr=null;
	ResultSet rsAttr=psAttr.executeQuery();
	while (rsAttr.next()) {
		
		attr= new ArrayList<String>();
		attr.add(rsAttr.getString(1));
		attr.add(rsAttr.getString(2));
		attr.add(rsAttr.getString(3));
		attr.add(rsAttr.getString(4));
		attr.add(rsAttr.getString(5));
		attr.add(rsAttr.getString(6));
		attr.add(rsAttr.getString(7));
		attr.add(rsAttr.getString(8));
		attr.add(rsAttr.getString(9));
		attr.add(rsAttr.getString(10));
	
		
	}
	
	
		int i=0;
		System.out.println("coming in model");
		String query="Select itemId,item_name,item_desc,cost,seller_id,image,imagePath,discount,expiryOn,dealflag,"
				+ "subCat_Id,quantity,advertisementItem,field1,field2,brand,color,weight,conditionoftheitem,warrantyperiod,ItemCatId,expirydate"
				+ " FROM item where itemId=?";
		PreparedStatement ps= ConnectionPool.con.prepareStatement(query);
		System.out.println("dm.getItemId() "+dm.getItemId());
		ps.setString(1,dm.getItemId() );
		
		ResultSet rs=ps.executeQuery();
		dm.setItemList(new ArrayList<itemModel>());
		String catId=null,subcatID = null;
		while (rs.next()) {
			itemModel tc = new itemModel();
			tc.setItemId(rs.getString(1));
			tc.setItemName(rs.getString(2));
			tc.setItemDesc(rs.getString(3));
			tc.setCost(rs.getInt(4));
			tc.setSeller_id(rs.getString(5));
			tc.setPhoto(rs.getBlob(6));
			String imagePath = rs.getString(7);
			
			/*int lastIndex = imagePath.indexOf(".tmp");
			int startIndex = imagePath.lastIndexOf("/");
			imagePath= imagePath.substring(startIndex+1, lastIndex+4);*/
			//tc.setImagePath(imagePath);
			tc.setDiscount(rs.getInt(8));
			if(rs.getDate("expiryOn")!=null)
			tc.setExpiryOn(rs.getDate("expiryOn").toString());
			System.out.println(" expiry date"+tc.getExpiryOn());
			tc.setDealflag(rs.getString(10));
			tc.setItemSubCatId(rs.getInt(11));
			subcatID=rs.getString(11);
			tc.setQuantity(rs.getInt(12));
			tc.setAdvCheck(rs.getString(13));
			tc.setAddField1(rs.getString(14));
			tc.setAddField2(rs.getString(15));
			tc.setBrand(rs.getString(16));
			tc.setColor(rs.getString(17));
			tc.setWeight(rs.getString(18));
			tc.setConditionoftheitem(rs.getString(19));
			tc.setWarrantyperiod(rs.getInt(20));
			tc.setItemCatId(rs.getString(21));
			tc.setExpiryOn(rs.getString("expirydate"));
			catId=rs.getString(21);
			Blob pic=rs.getBlob(6);
			if(pic!=null)
				{
				int blobLength = (int) pic.length();	
				tc.setBlobAsBytes(pic.getBytes(1, blobLength));
				tc.setImage64encode(new Base64().encodeToString(tc.getBlobAsBytes()));
				}
			System.out.println("attr"+attr);
			if(attr!=null)
			{
			tc.setAttrkey1(attr.get(i++));
			tc.setAttrval1(attr.get(i++));
			tc.setAttrkey2(attr.get(i++));
			tc.setAttrval2(attr.get(i++));
			tc.setAttrkey3(attr.get(i++));
			tc.setAttrval3(attr.get(i++));
			tc.setAttrkey4(attr.get(i++));
			tc.setAttrval4(attr.get(i++));
			tc.setAttrkey5(attr.get(i++));
			tc.setAttrval5(attr.get(i++));
			}
			getItemList().add(tc);
			dm.getItemList().add(tc);
			i=0;
		}
		
		
		
		System.out.println("catId is "+catId);
		System.out.println("edit size"+getItemList().size());
		//catId="12";
		int foo = Integer.parseInt(catId);
		String catQuery="select categoryName from category where categoryId=?";
		
		
		
		
		PreparedStatement ps1= ConnectionPool.con.prepareStatement(catQuery);
		ps1.setInt(1, foo);
		ResultSet rs1=ps1.executeQuery();
		String catName=null;
		
		while(rs1.next())
		{
			catName=rs1.getString(1);
		}
		session.setAttribute("categoryName", foo);
		int foo1 = Integer.parseInt(subcatID);
		String subcatQuery="select subcatName from subcategory where subcatId=?";
		PreparedStatement ps3= ConnectionPool.con.prepareStatement(subcatQuery);
		ps3.setInt(1, foo1);
		ResultSet rs3=ps3.executeQuery();
		String subcatName=null;
		while(rs3.next())
		{
			subcatName=rs3.getString(1);
		}
		session.setAttribute("subcategoryName", subcatName);
		session.setAttribute("editItemList", getItemList());
		dm.setItemList(getItemList());
		
		
	}
	
	 
	 catch (Exception e1) {
			e1.printStackTrace();
	}
 	
}
public ArrayList<itemModel> getItemList() {
	return itemList;
}
public void setItemList(ArrayList<itemModel> itemList) {
	this.itemList = itemList;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
}

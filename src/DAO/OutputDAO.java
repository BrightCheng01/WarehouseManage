package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.Util;
import Bean.IRecord;
import Bean.ORecord;
import Bean.Orderform;

public class OutputDAO{
	
	
	public   List<ORecord> list(int start, int count) {

        List<ORecord> orecords = new ArrayList<ORecord>();

        String sql = "select * from orecord ORDER BY id desc limit ?,?";

        try{
        	Connection c = Util.getConnection();
        	PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, start);
            ps.setInt(2, count);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            	ORecord orecord = new ORecord();
            	
                String id = rs.getString("Id");
                String ono = rs.getString("Ono");
                String name = rs.getString("Name");
                String gno = rs.getString("Gno");
                String num = rs.getString("Num");
                String price = rs.getString("Price");
                String totalprice = rs.getString("Totalprice");
                String cname =rs.getString("Cname");            
                String cno = rs.getString("Cno");
                String contact =rs.getString("Contact");            
                String tel = rs.getString("Tel");
                String address =rs.getString("Address");            
                String date = rs.getString("Date");
                String operator = rs.getString("Operator");
                
                orecord.setId(id);           
                orecord.setOno(ono);
                orecord.setOname(name);
                orecord.setOgno(gno);
                orecord.setOnum(num);
                orecord.setOprice(price);
                orecord.setTotaloprice(totalprice);
                orecord.setCname(cname);
                orecord.setCno(cno);
                orecord.setContact(contact);
                orecord.setTel(tel);          
                orecord.setAddress(address);              
                orecord.setDate(date);
                orecord.setOperator(operator);
                
                orecords.add(orecord);
            }

            if(ps!=null)
            {ps.close();System.out.println("st已关闭");}
            if(c!=null)
            {c.close(); System.out.println("c已关闭");}
   

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orecords;
    }
	
	
	 public int getTotal() {

	        int total = 0;

	        String sql = "SELECT COUNT(*) FROM orecord";
	        try
	        {
	        	Connection c = Util.getConnection();
	        	Statement st = c.createStatement();
	        	

	            ResultSet rs = st.executeQuery(sql);
	            while (rs.next()) {
	                total = rs.getInt(1);
	               }
	            if(st!=null)
	            {st.close();System.out.println("st已关闭");}
	            if(c!=null)
	            {c.close(); System.out.println("c已关闭");}
	        }
	        catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return total;
		
	}
	
	
	
	public void add(Orderform orderform,String operator) {
		
		
		
        String sql = "INSERT INTO orecord VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try  {
        	Connection c = Util.getConnection(); 
        	PreparedStatement ps = c.prepareStatement(sql);
        	 ps.setInt(1, orderform.getId());
             ps.setString(3, orderform.getName()); 
             ps.setString(2, orderform.getOrdercode());
             ps.setString(4, orderform.getGno());
            
             
             ps.setString(5, orderform.getNum());
             ps.setString(6, orderform.getPrice());
             ps.setString(7, orderform.getTotalprice());
             
             ps.setString(8, orderform.getCname());
             System.out.println("date"+orderform.getDate());
             ps.setString(9, orderform.getCno());
             ps.setString(10, orderform.getContact());             
            
             ps.setString(11, orderform.getTel());
            
             
             ps.setString(12, orderform.getAddress());
             ps.setString(13, orderform.getDate());
             ps.setString(14,operator);
            
        
            ps.execute();
            
            if(ps!=null)
            {ps.close();System.out.println("st已关闭");}
            if(c!=null)
            {c.close(); System.out.println("c已关闭");}
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
 
        
        
    }

}

package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.Util;
import Bean.Goods;
import Bean.IRecord;
import Bean.Orderform;

public class InputDAO {
	
	
	public   List<IRecord> list(int start, int count) {

        List<IRecord> irecords = new ArrayList<IRecord>();

        String sql = "select * from irecord ORDER BY id desc limit ?,?";

        try{
        	Connection c = Util.getConnection();
        	PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, start);
            ps.setInt(2, count);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            	IRecord irecord = new IRecord();
            	
                String id = rs.getString("id");
                String ino = rs.getString("Ino");
                String name = rs.getString("Name");
                String num = rs.getString("Num");
                String iprice = rs.getString("Iprice");
                String totalprice = rs.getString("Totalprice");
                String address =rs.getString("Address");            
                String remark = rs.getString("Remark");
                String date = rs.getString("Date");
                String operator=rs.getString("Operator");

                
                irecord.setId(id);           
                irecord.setIno(ino);
                irecord.setIname(name);
                irecord.setInum(num);
                irecord.setIprice(iprice);
                irecord.setTotaliprice(totalprice);
                irecord.setIaddress(address);
                irecord.setIremark(remark);
                irecord.setIdate(date);
                irecord.setOperator(operator);
                
                irecords.add(irecord);
            }

            if(ps!=null)
            {ps.close();System.out.println("st已关闭");}
            if(c!=null)
            {c.close(); System.out.println("c已关闭");}
   

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return irecords;
    }
	
	
	
	 public int getTotal() {

	        int total = 0;

	        String sql = "SELECT COUNT(*) FROM irecord";
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
	
	
	
	 public IRecord get(String id) {
			System.out.println("id"+id);

			IRecord irecord = new IRecord();

	        String sql = "SELECT * FROM irecord WHERE id = " + id;
	        try  {
	        	
	        
	        	Connection c = Util.getConnection();
	        	Statement st = c.createStatement();
	        	
	            ResultSet rs = st.executeQuery(sql);

	            while(rs.next()){

	                String ino = rs.getString("Ino");
	                String name = rs.getString("Name");
	                String num = rs.getString("Num");
	                String iprice = rs.getString("Iprice");
	                String totalprice = rs.getString("TotalPrice");
	                String date =rs.getString("Date");
	                String remark = rs.getString("Remark");
	                String address =rs.getString("Address");
	                String operator=rs.getString("Operator");
	                
	                irecord.setIno(ino);
	                irecord.setIname(name);
	                irecord.setInum(num);
	                irecord.setIprice(iprice);
	                irecord.setTotaliprice(totalprice);
	                irecord.setIdate(date);
	                irecord.setIremark(remark);
	                irecord.setIaddress(address);
	                irecord.setOperator(operator);
	            }
	            
	            if(st!=null)
	            {st.close();System.out.println("st已关闭");}
	            if(c!=null)
	            {c.close(); System.out.println("c已关闭");}
	   

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return irecord;
	    }
	
	
	 public void add(IRecord irecord) {
			String date=irecord.getIdate();
			String cno=irecord.getIno();
			
	        String sql = "INSERT INTO irecord VALUES(NULL,NULL,?,?,?,?,?,?,?,?)";
	        try  {
	        	Connection c = Util.getConnection(); 
	        	PreparedStatement ps = c.prepareStatement(sql);
	        	// ps.setInt(1, orderform.getOrdercode());
	             ps.setString(1, irecord.getIname()); 
	             
	             ps.setString(2, irecord.getInum());
	            
	             
	             ps.setString(3, irecord.getIprice());
	             ps.setString(4, irecord.getTotaliprice());
	             ps.setString(5, irecord.getIaddress());
	             
	             ps.setString(6, irecord.getIdate());
	             System.out.println("date"+irecord.getIdate());
	             ps.setString(7, irecord.getIremark());
	             ps.setString(8, irecord.getOperator());
	            
	        
	            ps.execute();
	            
	            if(ps!=null)
	            {ps.close();System.out.println("st已关闭");}
	            if(c!=null)
	            {c.close(); System.out.println("c已关闭");}
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
	        
	        try  {
	        	Connection c = Util.getConnection();
	        	Statement st = c.createStatement();
	        	
	            ResultSet rs = st.executeQuery("select id from irecord order  by id DESC limit 1;");

	            while(rs.next()){
	            	String id=rs.getString("id");
	            	irecord.setId(id);
	            }
	            
	            if(st!=null)
	            {st.close();System.out.println("st已关闭");}
	            if(c!=null)
	            {c.close(); System.out.println("c已关闭");}   
	        }
	        
	        catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
	        
	        try {
	        	Connection c = Util.getConnection();
	        	PreparedStatement ps = c.prepareStatement("update irecord set Ino ="+date+irecord.getId()+"  where Ino is null;");
	        
	        	ps.execute();
	        	if(ps!=null)
	            {ps.close();System.out.println("st已关闭");}
	            if(c!=null)
	            {c.close(); System.out.println("c已关闭");}
	        }
	        
	        catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
	        
	    }
	 

}

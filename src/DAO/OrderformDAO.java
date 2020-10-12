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
import Bean.Orderform;

public class OrderformDAO {
	
	
	 public Orderform get(String id) {
			System.out.println("id"+id);

		 Orderform orderform = new Orderform();

	        String sql = "SELECT * FROM orderform WHERE id = " + id;
	        try  {
	        	
	        
	        	Connection c = Util.getConnection();
	        	Statement st = c.createStatement();
	        	
	            ResultSet rs = st.executeQuery(sql);

	            while(rs.next()){

	                String ordercode = rs.getString("Ordercode");
	                String name = rs.getString("Name");
	                String gno = rs.getString("Gno");
	                String num = rs.getString("Num");
	                String price = rs.getString("Price");
	                String totalprice =rs.getString("Totalprice");
	                String cname = rs.getString("Cname");
	                String cno = rs.getString("Cno");
	                String contact = rs.getString("Contact");
	                String tel = rs.getString("Tel");
	                String address = rs.getString("Address");
	                String date = rs.getString("Date");
	                String isdone = rs.getString("Isdone");
	              
	                
	                orderform.setOrdercode(ordercode);
	                orderform.setName(name);
	                orderform.setGno(gno);
	                orderform.setNum(num);
	                orderform.setPrice(price);
	                orderform.setTotalprice(totalprice);
	                orderform.setCname(cname);
	                orderform.setCno(cno);
	                orderform.setContact(contact);
	                orderform.setTel(tel);
	                orderform.setAddress(address);
	                orderform.setDate(date);
	                orderform.setIsdone(isdone);
	                
	
	            }
	            
	            if(st!=null)
	            {st.close();System.out.println("st已关闭");}
	            if(c!=null)
	            {c.close(); System.out.println("c已关闭");}
	   

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return orderform;
	    }
	
	
	 
	 public   List<Orderform> listall() {

	        List<Orderform> orderforms = new ArrayList<Orderform>();

	        String sql = "select * from orderform where id is not null  ORDER BY id desc ";

	        try{
	        	Connection c = Util.getConnection();
	        	PreparedStatement ps = c.prepareStatement(sql);
	        

	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {
	            	Orderform orderform = new Orderform();
	            	
	                int id = Integer.parseInt(rs.getString("id"));
	                String ordercode = rs.getString("Ordercode");
	                String name = rs.getString("name");
	                String gno = rs.getString("Gno");
	                String num = rs.getString("Num");
	                String price = rs.getString("Price");
	                String totalprice = rs.getString("Totalprice");
	                String cname =rs.getString("Cname");
	                String cno = rs.getString("Cno");
	                String contact = rs.getString("Contact");
	                String tel = rs.getString("Tel");
	                String address = rs.getString("Address");
	                String date = rs.getString("Date");
	                String isdone = rs.getString("Isdone");
	    
	                
	                orderform.setId(id);
	                orderform.setOrdercode(ordercode);
	                orderform.setName(name);
	                orderform.setGno(gno);                
	                orderform.setNum(num);
	                orderform.setPrice(price);
	                orderform.setTotalprice(totalprice);
	                
	                orderform.setCname(cname);
	                orderform.setCno(cno);
	                orderform.setContact(contact);
	                orderform.setTel(tel);
	                orderform.setAddress(address);               
	                orderform.setDate(date);
	                orderform.setIsdone(isdone);
	                
	                orderforms.add(orderform);
	            }

	            if(ps!=null)
	            {ps.close();System.out.println("st已关闭");}
	            if(c!=null)
	            {c.close(); System.out.println("c已关闭");}
	   

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return orderforms;
	    }
	 
	
	 public   List<Orderform> listisdone(int start, int count) {

	        List<Orderform> orderforms = new ArrayList<Orderform>();

	        String sql = "select * from orderform where Isdone ='"+"未处理"+"' ORDER BY id desc limit ?,?";

	        try{
	        	Connection c = Util.getConnection();
	        	PreparedStatement ps = c.prepareStatement(sql);
	            ps.setInt(1, start);
	            ps.setInt(2, count);

	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {
	            	Orderform orderform = new Orderform();
	            	
	                int id = Integer.parseInt(rs.getString("id"));
	                String ordercode = rs.getString("Ordercode");
	                String name = rs.getString("name");
	                String gno = rs.getString("Gno");
	                String num = rs.getString("Num");
	                String price = rs.getString("Price");
	                String totalprice = rs.getString("Totalprice");
	                String cname =rs.getString("Cname");
	                String cno = rs.getString("Cno");
	                String contact = rs.getString("Contact");
	                String tel = rs.getString("Tel");
	                String address = rs.getString("Address");
	                String date = rs.getString("Date");
	                String isdone = rs.getString("Isdone");
	    
	                
	                orderform.setId(id);
	                orderform.setOrdercode(ordercode);
	                orderform.setName(name);
	                orderform.setGno(gno);                
	                orderform.setNum(num);
	                orderform.setPrice(price);
	                orderform.setTotalprice(totalprice);
	                
	                orderform.setCname(cname);
	                orderform.setCno(cno);
	                orderform.setContact(contact);
	                orderform.setTel(tel);
	                orderform.setAddress(address);               
	                orderform.setDate(date);
	                orderform.setIsdone(isdone);
	                
	                orderforms.add(orderform);
	            }

	            if(ps!=null)
	            {ps.close();System.out.println("st已关闭");}
	            if(c!=null)
	            {c.close(); System.out.println("c已关闭");}
	   

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return orderforms;
	    }
	 
	
	public   List<Orderform> list(int start, int count) {

        List<Orderform> orderforms = new ArrayList<Orderform>();

        String sql = "select * from orderform ORDER BY id desc limit ?,?";

        try{
        	Connection c = Util.getConnection();
        	PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, start);
            ps.setInt(2, count);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            	Orderform orderform = new Orderform();
            	
                int id = Integer.parseInt(rs.getString("id"));
                String ordercode = rs.getString("Ordercode");
                String name = rs.getString("name");
                String gno = rs.getString("Gno");
                String num = rs.getString("Num");
                String price = rs.getString("Price");
                String totalprice = rs.getString("Totalprice");
                String cname =rs.getString("Cname");
                String cno = rs.getString("Cno");
                String contact = rs.getString("Contact");
                String tel = rs.getString("Tel");
                String address = rs.getString("Address");
                String date = rs.getString("Date");
                String isdone = rs.getString("Isdone");
    
                
                orderform.setId(id);
                orderform.setOrdercode(ordercode);
                orderform.setName(name);
                orderform.setGno(gno);                
                orderform.setNum(num);
                orderform.setPrice(price);
                orderform.setTotalprice(totalprice);
                
                orderform.setCname(cname);
                orderform.setCno(cno);
                orderform.setContact(contact);
                orderform.setTel(tel);
                orderform.setAddress(address);               
                orderform.setDate(date);
                orderform.setIsdone(isdone);
                
                orderforms.add(orderform);
            }

            if(ps!=null)
            {ps.close();System.out.println("st已关闭");}
            if(c!=null)
            {c.close(); System.out.println("c已关闭");}
   

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderforms;
    }
	
	
	public int getisdoneTotal() {

        int total = 0;

        String sql = "SELECT COUNT(*) FROM orderform where Isdone='"+"未处理"+"'";
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
	
	
	 public int getTotal() {

	        int total = 0;

	        String sql = "SELECT COUNT(*) FROM orderform";
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
	
	
	
	
	public   List<Orderform> CnoList(int start, int count,String Cno) {

        List<Orderform> orderforms = new ArrayList<Orderform>();

        String sql = "select * from orderform where Cno like '%"+Cno+"%' ORDER BY id desc limit ?,?";

        try{
        	Connection c = Util.getConnection();
        	PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, start);
            ps.setInt(2, count);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            	Orderform orderform = new Orderform();
            	
                int id = Integer.parseInt(rs.getString("id"));
                String ordercode = rs.getString("Ordercode");
                String name = rs.getString("name");
                String gno = rs.getString("Gno");
                String num = rs.getString("Num");
                String price = rs.getString("Price");
                String totalprice = rs.getString("Totalprice");
                String cname =rs.getString("Cname");
                String cno = rs.getString("Cno");
                String contact = rs.getString("Contact");
                String tel = rs.getString("Tel");
                String address = rs.getString("Address");
                String date = rs.getString("Date");
                String isdone = rs.getString("Isdone");
    
                
                orderform.setId(id);
                orderform.setOrdercode(ordercode);
                orderform.setName(name);
                orderform.setGno(gno);                
                orderform.setNum(num);
                orderform.setPrice(price);
                orderform.setTotalprice(totalprice);
                
                orderform.setCname(cname);
                orderform.setCno(cno);
                orderform.setContact(contact);
                orderform.setTel(tel);
                orderform.setAddress(address);               
                orderform.setDate(date);
                orderform.setIsdone(isdone);
                
                orderforms.add(orderform);
            }

            if(ps!=null)
            {ps.close();System.out.println("st已关闭");}
            if(c!=null)
            {c.close(); System.out.println("c已关闭");}
   

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderforms;
    }
	
public int getCnoTotal(int Cno ){
		
		//mark
        int total = 0;

        String sql = "SELECT COUNT(*) FROM orderform where Cno like'%"+Cno+"%' ";
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
	
	
	
	public void add(Orderform orderform) {
		String date=orderform.getDate();
		String cno=orderform.getCno();
		
        String sql = "INSERT INTO orderform VALUES(NULL,NULL,?,?,?,?,?,?,?,?,?,?,?,?)";
        try  {
        	Connection c = Util.getConnection(); 
        	PreparedStatement ps = c.prepareStatement(sql);
        	// ps.setInt(1, orderform.getOrdercode());
             ps.setString(1, orderform.getName()); 
             ps.setString(2, orderform.getGno());
             ps.setString(3, orderform.getNum());
            // ps.setDate(5, new java.sql.Date(teacher.getBirthday().getTime()));
             
             ps.setString(4, orderform.getPrice());
             ps.setString(5, orderform.getTotalprice());
             ps.setString(6, orderform.getCname());
             ps.setString(7, orderform.getCno());
             ps.setString(8, orderform.getContact());
             ps.setString(9, orderform.getTel());
             ps.setString(10, orderform.getAddress());
             ps.setString(11, orderform.getDate());
             ps.setString(12, orderform.getIsdone()); 
            
        
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
        	
            ResultSet rs = st.executeQuery("select id from orderform order  by id DESC limit 1;");

            while(rs.next()){
            	int id=rs.getInt("id");
            	orderform.setId(id);
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
        	PreparedStatement ps = c.prepareStatement("update orderform set Ordercode ="+date+cno+orderform.getId()+"  where Ordercode is null;");
        
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
	
	
	
	
	
	
	public void isdone(String ordercode) {

        String sql = "update  orderform set Isdone= '已处理' WHERE Ordercode = "+ordercode+"";
        try  {
        	Connection c = Util.getConnection(); 
        	PreparedStatement ps = c.prepareStatement(sql);
        

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

package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import util.Util;
import Bean.Goods;
import Bean.Warehouse;

public class WarehouseDAO {
	
	
	
	
	/*public List<Warehouse> list() {
        return list(0, Short.MAX_VALUE);
    }*/

    public   List<Warehouse> list(int start, int count) {

        List<Warehouse> warehouses = new ArrayList<Warehouse>();

        String sql = "select * from warehouse ORDER BY id desc limit ?,?";

        try{
        	Connection c = Util.getConnection();
        	PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, start);
            ps.setInt(2, count);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            	Warehouse warehouse = new Warehouse();
            	
                String id = rs.getString("id");
                String wno = rs.getString("Wno");
                String name = rs.getString("Name");
                String address = rs.getString("Address");              
                String remark = rs.getString("Remark");
              
                
                warehouse.setId(id);           
                warehouse.setWno(wno);
                warehouse.setName(name);           
                warehouse.setRemark(remark);               
                warehouse.setAddress(address);
                
                warehouses.add(warehouse);
            }

            if(ps!=null)
            {ps.close();System.out.println("st已关闭");}
            if(c!=null)
            {c.close(); System.out.println("c已关闭");}
   

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return warehouses;
    }
	
    
    public Warehouse get(String id) {

    	Warehouse warehouse = new Warehouse();

        String sql = "SELECT * FROM warehouse WHERE id = " + id;
        try  {
        	Connection c = Util.getConnection();
        	Statement st = c.createStatement();
        	
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){

            	//String ID = rs.getString("id");
            	
                String wno = rs.getString("Wno");
                String name = rs.getString("Name");
                String address = rs.getString("Address");              
                String remark = rs.getString("Remark");
              
                
                warehouse.setId(id);           
                warehouse.setWno(wno);
                warehouse.setName(name);           
                warehouse.setRemark(remark);               
                warehouse.setAddress(address);
            }
            
            if(st!=null)
            {st.close();System.out.println("st已关闭");}
            if(c!=null)
            {c.close(); System.out.println("c已关闭");}
   

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return warehouse;
    }
    
    public  void update(Warehouse warehouse) {

        String sql = "update warehouse set Wno = ?, Name = ?,Address=?, Remark=? where Id = ? ";
        try {
        	Connection c = Util.getConnection();
        	PreparedStatement ps = c.prepareStatement(sql);
        	
            ps.setString(1, warehouse.getWno());
            ps.setString(2, warehouse.getName()); 
          
            
            
            ps.setString(3, warehouse.getRemark());
            ps.setString(4, warehouse.getAddress()); 
            ps.setString(5, warehouse.getId());
            
            
            
            
            System.out.println("ps1更新成功");
            
            ps.execute();
            if(ps!=null)
            {ps.close();System.out.println("st已关闭");}
            if(c!=null)
            {c.close(); System.out.println("c已关闭");}
            System.out.println("ps2更新成功");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("更新成功"+warehouse.getName());
        
    }
    
    
    
	
    
   
    
    
    public void add(Warehouse warehouse) {
        String sql = "INSERT INTO warehouse VALUES(NULL,?,?,?,?)";
        try  {
        	Connection c = Util.getConnection(); 
        	PreparedStatement ps = c.prepareStatement(sql);
        	 ps.setString(1, warehouse.getWno());
             ps.setString(2, warehouse.getName()); 
            
             ps.setString(3, warehouse.getAddress()); 
             ps.setString(4, warehouse.getRemark());
             
        
            ps.execute();
            
            System.out.println("添加仓库");
            if(ps!=null)
            {ps.close();System.out.println("st已关闭");}
            if(c!=null)
            {c.close(); System.out.println("c已关闭");}
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public int getTotal() {

        int total = 0;

        String sql = "SELECT COUNT(*) FROM warehouse";
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
    
    
    public void delete(String id) {

        String sql = "DELETE FROM warehouse WHERE Id = ?";
        try  {
        	Connection c = Util.getConnection(); 
        	PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, id);

            ps.execute();
            if(ps!=null)
            {ps.close();System.out.println("st已关闭");}
            if(c!=null)
            {c.close(); System.out.println("c已关闭");}

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public List<Warehouse> Wnolist(int start, int count,String Wno) {

        List<Warehouse> warehouses = new ArrayList<Warehouse>();

        String sql = "SELECT * FROM warehouse where Wno like'%"+Wno+"%' ORDER BY id desc limit ?,?";

        try{
        	Connection c = Util.getConnection();
        	PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, start);
            ps.setInt(2, count);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            	Warehouse warehouse = new Warehouse();
                String id = rs.getString("Id");
                String wno = rs.getString("Wno");
                String name = rs.getString("Name");
                String address = rs.getString("Address");            
                
                String remark = rs.getString("Remark");
                    
               
                warehouse.setId(id);
                warehouse.setWno(wno);
                warehouse.setName(name);
            
                warehouse.setAddress(address);
               
                warehouse.setRemark(remark);
               
                warehouses.add(warehouse);
            }

            if(ps!=null)
            {ps.close();System.out.println("st已关闭");}
            if(c!=null)
            {c.close(); System.out.println("c已关闭");}
   

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return warehouses;
    }
    
    public int getSIDTotal( int Wno ){
		
		//mark
        int total = 0;

        String sql = "SELECT COUNT(*) FROM warehouse where Wno like'%"+Wno+"%' ";
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
 
    
    public   List<Warehouse> Namelist(int start, int count,String Name) {

        List<Warehouse> warehouses = new ArrayList<Warehouse>();

        String sql = "select * from warehouse where Name like'%"+Name+"%' ";

        try{
        	Connection c = Util.getConnection();
        	PreparedStatement ps = c.prepareStatement(sql);
        

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            	Warehouse warehouse = new Warehouse();
            	
                String id = rs.getString("id");
                String wno = rs.getString("Wno");
                String name = rs.getString("Name");
                String address = rs.getString("Address");              
                String remark = rs.getString("Remark");
              
                
                warehouse.setId(id);           
                warehouse.setWno(wno);
                warehouse.setName(name);           
                warehouse.setRemark(remark);               
                warehouse.setAddress(address);
                
                warehouses.add(warehouse);
            }

            if(ps!=null)
            {ps.close();System.out.println("st已关闭");}
            if(c!=null)
            {c.close(); System.out.println("c已关闭");}
   

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return warehouses;
    }
    
public int getNameTotal( String Name ){
		
		//mark
        int total = 0;

        String sql = "SELECT COUNT(*) FROM warehouse where name like'%"+Name+"%' ";
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



public   List<Warehouse> wnolist(int start, int count,String Wno) {

    List<Warehouse> warehouses = new ArrayList<Warehouse>();

    String sql = "select * from warehouse where Wno like'%"+Wno+"%' ";

    try{
    	Connection c = Util.getConnection();
    	PreparedStatement ps = c.prepareStatement(sql);
      

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
        	Warehouse warehouse = new Warehouse();
        	
            String id = rs.getString("id");
            String wno = rs.getString("Wno");
            String name = rs.getString("Name");
            String address = rs.getString("Address");              
            String remark = rs.getString("Remark");
          
            
            warehouse.setId(id);           
            warehouse.setWno(wno);
            warehouse.setName(name);           
            warehouse.setRemark(remark);               
            warehouse.setAddress(address);
            
            warehouses.add(warehouse);
        }

        if(ps!=null)
        {ps.close();System.out.println("st已关闭");}
        if(c!=null)
        {c.close(); System.out.println("c已关闭");}


    } catch (SQLException e) {
        e.printStackTrace();
    }

    return warehouses;
}

public int getwnoTotal( String Wno ){
	
	//mark
    int total = 0;

    String sql = "SELECT COUNT(*) FROM warehouse where Wno like'%"+Wno+"%' ";
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
    
    
    
	
	
	

}

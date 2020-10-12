package DAO;
import java.sql.Connection;




import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import bean.Manager;



import Bean.Admin;


//import util.DButil;

import util.Util;
import util.Util;


public class AdminDAO 
{

	 public Admin get(int ANo) {
		 System.out.println("ANo"+ANo);

		 Admin admin = new Admin();

	        String sql = "SELECT * FROM administrator WHERE Id = " + ANo;//类型
	        try  {
	        	Connection c = Util.getConnection();
	        	Statement st = c.createStatement();
	        	
	            ResultSet rs = st.executeQuery(sql);

	            while(rs.next()) { 
 
	            	int id=rs.getInt("Id");
	                int ano = rs.getInt("ANo");
	                String name = rs.getString("AName");
	             
	                String sex = rs.getString("Asex");
	              //  Date birthday = rs.getDate("birthday");
	                String img=rs.getString("img");
	                String remark =rs.getString("ARemark");
	                 String pwd =rs.getString("Apwd");
	                
	                
	                 admin.setAno(ano);
	                 admin.setName(name);
	                 admin.setSex(sex);
	                 //admin.setBirthday(birthday);
	                 admin.setId(id);
	                admin.setImg(img);
	                 admin.setRemark(remark);
	                 admin.setPwd(pwd);
	                 
	                 System.out.println(ano);
	                 System.out.println(img);
	            }

	            if(st!=null)
	            {st.close();System.out.println("st已关闭");}
	            if(c!=null)
	            {c.close(); System.out.println("c已关闭");}
	        
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        System.out.println(admin.getId()+"更新后头像"+admin.getImg());

	        return admin;
	    }
	 
	 
	 
	 
	 public boolean isExist(int Ano)
	 {
		 String sql = "SELECT ANo FROM administrator " ;

	        try  {
	        	Connection c = Util.getConnection();
	        	Statement st = c.createStatement();
	        	
	            ResultSet rs = st.executeQuery(sql);

	            while(rs.next()){
	            	 int ano = rs.getInt("ANo");
	            	 if(ano==Ano)
	            	 {  
	            		 if(st!=null)
	 	            {st.close();System.out.println("st已关闭");}
	 	            if(c!=null)
	 	            {c.close(); System.out.println("c已关闭");}
	            		 return true;	}
	            }
	            }
	        catch (SQLException e) {
	            e.printStackTrace();
	        }

		 return false;
	 }
	 
	 
	 
	 public Admin login(int Ano)
	 {
		 String sql = "select * from administrator ";
		 Admin admin=new Admin();
		 
		 try  {
			 Connection c = Util.getConnection();
	        	Statement st = c.createStatement();
	            ResultSet rs = st.executeQuery(sql);
	            
	            while(rs.next()){
	            int ano = rs.getInt("ANo");
	            String pwd =rs.getString("Apwd");
	            String name = rs.getString("AName");
		             
	                String sex = rs.getString("ASex");
	              //  Date birthday = rs.getDate("birthday");
	                String img=rs.getString("img");
	                String ARemark =rs.getString("ARemark");
	                int id=rs.getInt("Id");
	              //  System.out.println(img);
	                if(Ano==ano)
	                {
	                	 System.out.println("提取成功");
	            	admin.setAno(ano);
	            	admin.setPwd(pwd);
	            	admin.setName(name);
	            	admin.setSex(sex);
	            	//admin.setBirthday(birthday);
		            admin.setImg(img);
	            	admin.setRemark(ARemark);
	            	admin.setId(id);
	            	
	            	
	            	 if(st!=null)
		 	            {st.close();}
		 	            if(c!=null)
		 	            {c.close(); }		            			      
	            	return admin;
	            	
	            	}
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } 
		
		 return admin;
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 public  void updateImg(int id,String IMG) {

	        String sql = "update administrator set  img= ? where id = ? ";
	        try {
	        	Connection c = Util.getConnection();
	        	PreparedStatement ps = c.prepareStatement(sql);
	            
	            ps.setString(1, IMG);
	           
	            ps.setInt(2, id);
	            
	            System.out.println("ps1更新成功");
	            
	            ps.execute();
	            if(ps!=null)
	            {ps.close();System.out.println("st已关闭");}
	            if(c!=null)
	            {c.close(); System.out.println("c已关闭");}
	            


	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	      
	        
	    }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 public void add(Admin admin) {

	        String sql = "INSERT INTO administrator VALUES(NULL,?,?,?,?,?,NULL)";
	        try  {
	        	Connection c = Util.getConnection(); 
	        	PreparedStatement ps = c.prepareStatement(sql);
	            ps.setInt(2, admin.getAno());
	            ps.setString(1, admin.getName());
	            ps.setString(3, admin.getSex());
	            //ps.setDate(4, new java.sql.Date(admin.getBirthday().getTime());           	            
	            ps.setString(4, admin.getPwd());
	            ps.setString(5, admin.getRemark());
	            
	            ps.execute();
	            
	            if(ps!=null)
	            {ps.close();System.out.println("ps已关闭");}
	            if(c!=null)
	            {c.close(); System.out.println("c已关闭");}

	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }	
	 
	 
	 public  void update(Admin admin) {

	        String sql = "update administrator set ANo = ?, AName= ?, ASex = ?, APwd = ?, ARemark=? ,img=? where Id = ? ";
	        try {
	        	Connection c = Util.getConnection();
	        	PreparedStatement ps = c.prepareStatement(sql);
	            ps.setInt(1, admin.getAno());
	            ps.setString(2, admin.getName()); 
	            ps.setString(3, admin.getSex());
	         //   ps.setDate(4, new java.sql.Date(admin.getBirthday().getTime()));
	             ps.setString(4, admin.getPwd());
	            ps.setString(5, admin.getRemark());
	            ps.setString(6, admin.getImg());
	           
	            ps.setInt(7, admin.getId());
	            
	            System.out.println("ps1更新成功");
	           
	            ps.execute();
	            System.out.println("ps2更新成功");
	            System.out.println("DAO名字"+admin.getName());
	            
	            if(ps!=null)
	            {ps.close();}
	            if(c!=null)
	            {c.close(); }
         		
	        
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        System.out.println("更新成功");
	        
	    }
	
	
}

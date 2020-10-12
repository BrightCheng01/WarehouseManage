package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.Util;
import Bean.Admin;
import Bean.Client;
import Bean.Goods;

public class ClientDAO {
	
	public Client get(int CNo) {
		 System.out.println("ANo"+CNo);

		 Client client = new Client();

	        String sql = "SELECT * FROM client WHERE Id = " + CNo;//类型
	        try  {
	        	Connection c = Util.getConnection();
	        	Statement st = c.createStatement();
	        	
	            ResultSet rs = st.executeQuery(sql);

	            while(rs.next()) { 

	            	int id=rs.getInt("Id");
	                int cno = rs.getInt("Cno");
	                String name = rs.getString("Name");
	                String con = rs.getString("Con");
	                String address = rs.getString("Address");
	                String tel = rs.getString("Tel");
	                String remark =rs.getString("Remark");  
	                String sex = rs.getString("Sex");
	              //  Date birthday = rs.getDate("birthday");
	                String pwd =rs.getString("Pwd");
	                String img=rs.getString("Img");
          
	                
	                 client.setId(id);	                
	                 client.setCno(cno);
	                 client.setName(name);
	                 
	                 client.setCon(con);
	                 client.setAddress("address");
	                 client.setTel(tel);
	                 //admin.setBirthday(birthday);
	                 client.setRemark(remark);
	                 client.setSex(sex);
	                 client.setImg(img);
	                 
	                 client.setPwd(pwd);
	                 
	                 
	               
	            }

	            if(st!=null)
	            {st.close();System.out.println("st已关闭");}
	            if(c!=null)
	            {c.close(); System.out.println("c已关闭");}
	        
	        } catch (SQLException e) {
	        	e.printStackTrace();
	        }
	        System.out.println(client.getId()+"更新后头像"+client.getImg());

	        return client;
	    }

	
	public boolean CisExist(int Cno)
	 {
		 String sql = "SELECT Cno FROM client where power ='客户'" ;

	        try  {
	        	Connection c = Util.getConnection();
	        	Statement st = c.createStatement();
	        	
	            ResultSet rs = st.executeQuery(sql);

	            while(rs.next()){
	            	 int cno = rs.getInt("Cno");
	            	 if(cno==Cno)
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
	
	public boolean AisExist(int Cno)
	 {
		 String sql = "SELECT Cno FROM client where power ='管理员'" ;

	        try  {
	        	Connection c = Util.getConnection();
	        	Statement st = c.createStatement();
	        	
	            ResultSet rs = st.executeQuery(sql);

	            while(rs.next()){
	            	 int cno = rs.getInt("Cno");
	            	 if(cno==Cno)
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
	
	
	
	public Client login(int Cno)
	 {
		 String sql = "select * from client ";
		 Client client=new Client();
		 
		 try  {
			 Connection c = Util.getConnection();
	        	Statement st = c.createStatement();
	            ResultSet rs = st.executeQuery(sql);
	            
	            while(rs.next()){
	            	int id=rs.getInt("Id");
	            	int cno = rs.getInt("Cno");
	                String name = rs.getString("Name");
	                String con = rs.getString("Con");
	                String address = rs.getString("Address");
	                String tel = rs.getString("Tel");
	                String remark =rs.getString("Remark");  
	                String sex = rs.getString("Sex");
	              //  Date birthday = rs.getDate("birthday");
	                String pwd =rs.getString("Pwd");
	                String img=rs.getString("Img");
	                String power =rs.getString("power");
	                
	                if(Cno==cno)
	                {
	                	 System.out.println("提取成功");
	                	 client.setId(id);	                
		                 client.setCno(cno);
		                 client.setName(name);
		                 
		                 client.setCon(con);
		                 client.setAddress(address);
		                 client.setTel(tel);
		                 //admin.setBirthday(birthday);
		                 client.setRemark(remark);
		                 client.setSex(sex);
		                 client.setImg(img);
		                 client.setPower(power);
		                 client.setPwd(pwd);
	            	
	            	 if(st!=null)
		 	            {st.close();}
		 	            if(c!=null)
		 	            {c.close(); }		            			      
	            	return client;
	            	
	            	}
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } 		
		 return client;
	 }
	
	public  void updateImg(int id,String IMG) {

        String sql = "update client set  Img= ? where Id = ? ";
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
	
	 public void Cadd(Client client) { //要改动

	        String sql = "INSERT INTO client VALUES(NULL,?,?,?,?,?,?,?,?,NULL,?)";
	        try  {
	        	Connection c = Util.getConnection(); 
	        	PreparedStatement ps = c.prepareStatement(sql);
	        	
	            ps.setInt(1, client.getCno());
	            ps.setString(2, client.getName());
	            ps.setString(3, client.getCon());
	            ps.setString(4, client.getAddress());
	            //ps.setDate(4, new java.sql.Date(admin.getBirthday().getTime()));
	            ps.setString(5, client.getTel());
	            ps.setString(6, client.getRemark());
	            
	            ps.setString(7, client.getSex());
	            ps.setString(8, client.getPwd());
	            ps.setString(9, "客户");
	           
	            ps.execute();
	            
	            if(ps!=null)
	            {ps.close();System.out.println("ps已关闭");}
	            if(c!=null)
	            {c.close(); System.out.println("c已关闭");}
           
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 
	 public void Aadd(Client client) { //要改动

	        String sql = "INSERT INTO client VALUES(NULL,?,?,NULL,NULL,NULL,?,?,?,NULL,?)";
	        try  {
	        	Connection c = Util.getConnection(); 
	        	PreparedStatement ps = c.prepareStatement(sql);
	        	
	            ps.setInt(1, client.getCno());
	            ps.setString(2, client.getName());
	            ps.setString(4, client.getSex());
	            ps.setString(3, client.getRemark());
	            ps.setString(5, client.getPwd());
	            //ps.setDate(4, new java.sql.Date(admin.getBirthday().getTime()));
	            ps.setString(6, "管理员");
	           
	           
	            ps.execute();
	            
	            if(ps!=null)
	            {ps.close();System.out.println("ps已关闭");}
	            if(c!=null)
	            {c.close(); System.out.println("c已关闭");}
        
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	
	
	 public  void update(Client client) {

	        String sql = "update client set Cno = ?, Name= ?, Con = ?,Address = ?,Tel= ?, Remark=?,Sex = ?, Pwd = ?,  img=? where Id = ? ";
	        try {
	        	Connection c = Util.getConnection();
	        	PreparedStatement ps = c.prepareStatement(sql);
	        	
	        	ps.setInt(1, client.getCno());
	            ps.setString(2, client.getName());
	            ps.setString(3, client.getCon());
	            ps.setString(4, client.getAddress());
	            //ps.setDate(4, new java.sql.Date(admin.getBirthday().getTime()));
	            ps.setString(5, client.getTel());
	            ps.setString(6, client.getRemark());
	            
	            ps.setString(7, client.getSex());
	            ps.setString(8, client.getPwd());
	            ps.setString(9, client.getImg());
	            ps.setInt(10, client.getId());
	            
	            
	            
	            System.out.println("ps1更新成功");
	           
	            ps.execute();
	            System.out.println("ps2更新成功");
	            System.out.println("DAO名字"+client.getName());
	            
	            if(ps!=null)
	            {ps.close();}
	            if(c!=null)
	            {c.close(); }
      		
	        
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        System.out.println("更新成功");
	        
	    }
	 
	 
	 public  void powerupdate(String power,int id) {

	        String sql = "update client set power = '"+power+"' where Id = ' "+id+"'";
	        try {
	        	Connection c = Util.getConnection();
	        	PreparedStatement ps = c.prepareStatement(sql);
	        	
	        	
	            
	            
	            
	            System.out.println("ps1更新成功");
	           
	            ps.execute();
	            System.out.println("ps2更新成功");
	          //  System.out.println("DAO名字"+client.getName());
	            
	            if(ps!=null)
	            {ps.close();}
	            if(c!=null)
	            {c.close(); }
   		
	        
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        System.out.println("更新成功");
	        
	    }
	 
	 
	 public  void Aupdate(Client admin) {

	        String sql = "update client set CNo = ?, Name= ?, Sex = ?, Pwd = ?, ARemark=? ,img=? where Id = ? ";
	        try {
	        	Connection c = Util.getConnection();
	        	PreparedStatement ps = c.prepareStatement(sql);
	            ps.setInt(1, admin.getCno());
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
	 
	 public   List<Client> userNamelist(int start, int count,String Name) {

	        List<Client> clients = new ArrayList<Client>();

	        String sql = "select * from client Where Name like'%"+Name+"%'";

	        try{
	        	Connection c = Util.getConnection();
	        	PreparedStatement ps = c.prepareStatement(sql);
	       

	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {
	            	Client client = new Client();
	            	
	            	int id = rs.getInt("Id");
	            	int cno = rs.getInt("Cno");
	                String name = rs.getString("Name");
	                String con = rs.getString("Con");
	            
	                String address = rs.getString("Address");                
	                String tel = rs.getString("Tel");             
	                String remark = rs.getString("Remark");
	                String sex = rs.getString("Sex");
	                String pwd = rs.getString("Pwd");
	                String img = rs.getString("Img");
	                String power = rs.getString("power");
	                
	                client.setId(id);           
	                client.setCno(cno);
	                client.setName(name);
	                client.setCon(con);
	                client.setAddress(address);
	                client.setTel(tel);
	                client.setRemark(remark);
	                client.setSex(sex);
	                client.setPwd(pwd);
	                client.setImg(img);
	                client.setPower(power);
	                
	                clients.add(client);
	            }

	            if(ps!=null)
	            {ps.close();System.out.println("st已关闭");}
	            if(c!=null)
	            {c.close(); System.out.println("c已关闭");}
	   

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return clients;
	    }
		
	 public int getuserNameTotal(String Name) {

	        int total = 0;

	        String sql = "SELECT COUNT(*) FROM client where Name like'%"+Name+"%' ";
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
	
	 public   List<Client> Namelist(int start, int count,String Name) {

	        List<Client> clients = new ArrayList<Client>();

	        String sql = "select * from client Where Name like'%"+Name+"%' and power = '客户'";

	        try{
	        	Connection c = Util.getConnection();
	        	PreparedStatement ps = c.prepareStatement(sql);
	       

	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {
	            	Client client = new Client();
	            	
	            	int id = rs.getInt("Id");
	            	int cno = rs.getInt("Cno");
	                String name = rs.getString("Name");
	                String con = rs.getString("Con");
	            
	                String address = rs.getString("Address");                
	                String tel = rs.getString("Tel");             
	                String remark = rs.getString("Remark");
	                String sex = rs.getString("Sex");
	                String pwd = rs.getString("Pwd");
	                String img = rs.getString("Img");
	                
	                
	                client.setId(id);           
	                client.setCno(cno);
	                client.setName(name);
	                client.setCon(con);
	                client.setAddress(address);
	                client.setTel(tel);
	                client.setRemark(remark);
	                client.setSex(sex);
	                client.setPwd(pwd);
	                client.setImg(img);
	                
	                
	                clients.add(client);
	            }

	            if(ps!=null)
	            {ps.close();System.out.println("st已关闭");}
	            if(c!=null)
	            {c.close(); System.out.println("c已关闭");}
	   

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return clients;
	    }
		
	 public int getNameTotal(String Name) {

	        int total = 0;

	        String sql = "SELECT COUNT(*) FROM client where Name like'%"+Name+"%' and power = '客户'";
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
	
	 public   List<Client> Cnolist(int start, int count,String Cno) {

	        List<Client> clients = new ArrayList<Client>();

	        String sql = "select * from client Where Con like'%"+Cno+"%' and power = '客户'";

	        try{
	        	Connection c = Util.getConnection();
	        	PreparedStatement ps = c.prepareStatement(sql);
	       

	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {
	            	Client client = new Client();
	            	
	            	int id = rs.getInt("Id");
	            	int cno = rs.getInt("Cno");
	                String name = rs.getString("Name");
	                String con = rs.getString("Con");
	            
	                String address = rs.getString("Address");                
	                String tel = rs.getString("Tel");             
	                String remark = rs.getString("Remark");
	                String sex = rs.getString("Sex");
	                String pwd = rs.getString("Pwd");
	                String img = rs.getString("Img");
	                
	                
	                client.setId(id);           
	                client.setCno(cno);
	                client.setName(name);
	                client.setCon(con);
	                client.setAddress(address);
	                client.setTel(tel);
	                client.setRemark(remark);
	                client.setSex(sex);
	                client.setPwd(pwd);
	                client.setImg(img);
	                
	                
	                clients.add(client);
	            }

	            if(ps!=null)
	            {ps.close();System.out.println("st已关闭");}
	            if(c!=null)
	            {c.close(); System.out.println("c已关闭");}
	   

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return clients;
	    }
		
	 public int getCnoTotal(String Cno) {

	        int total = 0;

	        String sql = "SELECT COUNT(*) FROM client where Cno like'%"+Cno+"%'and power = '客户' ";
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
	 
	 
	 public   List<Client> userCnolist(int start, int count,String Cno) {

	        List<Client> clients = new ArrayList<Client>();

	        String sql = "select * from client Where Cno like'%"+Cno+"%' ";

	        try{
	        	Connection c = Util.getConnection();
	        	PreparedStatement ps = c.prepareStatement(sql);
	       

	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {
	            	Client client = new Client();
	            	
	            	int id = rs.getInt("Id");
	            	int cno = rs.getInt("Cno");
	                String name = rs.getString("Name");
	                String con = rs.getString("Con");
	            
	                String address = rs.getString("Address");                
	                String tel = rs.getString("Tel");             
	                String remark = rs.getString("Remark");
	                String sex = rs.getString("Sex");
	                String pwd = rs.getString("Pwd");
	                String img = rs.getString("Img");
	                String power =rs.getString("power");
	                
	                client.setId(id);           
	                client.setCno(cno);
	                client.setName(name);
	                client.setCon(con);
	                client.setAddress(address);
	                client.setTel(tel);
	                client.setRemark(remark);
	                client.setSex(sex);
	                client.setPwd(pwd);
	                client.setImg(img);
	                client.setPower(power);
	                
	                clients.add(client);
	            }

	            if(ps!=null)
	            {ps.close();System.out.println("st已关闭");}
	            if(c!=null)
	            {c.close(); System.out.println("c已关闭");}
	   

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return clients;
	    }
		
	 public int getuserCnoTotal(String Cno) {

	        int total = 0;

	        String sql = "SELECT COUNT(*) FROM client where Cno like'%"+Cno+"%' ";
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
	 
	 
	 public   List<Client> list(int start, int count) {

	        List<Client> clients = new ArrayList<Client>();

	        String sql = "select * from client  ORDER BY id desc limit ?,?";

	        try{
	        	Connection c = Util.getConnection();
	        	PreparedStatement ps = c.prepareStatement(sql);
	            ps.setInt(1, start);
	            ps.setInt(2, count);

	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {
	            	Client client = new Client();
	            	
	            	int id = rs.getInt("Id");
	            	int cno = rs.getInt("Cno");
	                String name = rs.getString("Name");
	                String con = rs.getString("Con");
	            
	                String address = rs.getString("Address");                
	                String tel = rs.getString("Tel");             
	                String remark = rs.getString("Remark");
	                String sex = rs.getString("Sex");
	                String pwd = rs.getString("Pwd");
	                String img = rs.getString("Img");
	                String power = rs.getString("power");
	                
	                client.setId(id);           
	                client.setCno(cno);
	                client.setName(name);
	                client.setCon(con);
	                client.setAddress(address);
	                client.setTel(tel);
	                client.setRemark(remark);
	                client.setSex(sex);
	                client.setPwd(pwd);
	                client.setImg(img);
	                client.setPower(power);
	                
	                clients.add(client);
	            }

	            if(ps!=null)
	            {ps.close();System.out.println("st已关闭");}
	            if(c!=null)
	            {c.close(); System.out.println("c已关闭");}
	   

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return clients;
	    }
		
	 public int getTotal() {

	        int total = 0;

	        String sql = "SELECT COUNT(*) FROM client ";
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
	 
	 
	 public   List<Client> Clist(int start, int count) {

	        List<Client> clients = new ArrayList<Client>();

	        String sql = "select * from client where power = '客户' ORDER BY id desc limit ?,?";

	        try{
	        	Connection c = Util.getConnection();
	        	PreparedStatement ps = c.prepareStatement(sql);
	            ps.setInt(1, start);
	            ps.setInt(2, count);

	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {
	            	Client client = new Client();
	            	
	            	int id = rs.getInt("Id");
	            	int cno = rs.getInt("Cno");
	                String name = rs.getString("Name");
	                String con = rs.getString("Con");
	            
	                String address = rs.getString("Address");                
	                String tel = rs.getString("Tel");             
	                String remark = rs.getString("Remark");
	                String sex = rs.getString("Sex");
	                String pwd = rs.getString("Pwd");
	                String img = rs.getString("Img");
	              
	                
	                
	                client.setId(id);           
	                client.setCno(cno);
	                client.setName(name);
	                client.setCon(con);
	                client.setAddress(address);
	                client.setTel(tel);
	                client.setRemark(remark);
	                client.setSex(sex);
	                client.setPwd(pwd);
	                client.setImg(img);
	                
	                
	                clients.add(client);
	            }

	            if(ps!=null)
	            {ps.close();System.out.println("st已关闭");}
	            if(c!=null)
	            {c.close(); System.out.println("c已关闭");}
	   

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return clients;
	    }
		
	 public int getCTotal() {

	        int total = 0;

	        String sql = "SELECT COUNT(*) FROM client where power = '客户'";
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
	 
	 public void delete(int id)
	 {
		 String sql="delete from client where id ="+id;
		 
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

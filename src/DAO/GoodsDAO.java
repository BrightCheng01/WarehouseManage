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

public class GoodsDAO {
	
	public List<Goods> list() {
        return list(0, Short.MAX_VALUE);
    }

    public   List<Goods> list(int start, int count) {

        List<Goods> goods = new ArrayList<Goods>();

        String sql = "select * from goods ORDER BY id desc limit ?,?";

        try{
        	Connection c = Util.getConnection();
        	PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, start);
            ps.setInt(2, count);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            	Goods good = new Goods();
            	
                String id = rs.getString("id");
                String gno = rs.getString("Gno");
                String name = rs.getString("name");
                String num = rs.getString("Num");
                String iprice = rs.getString("Iprice");
                String oprice = rs.getString("Oprice");
                String warehouse =rs.getString("Warehouse");
                String max = rs.getString("Max");
                String min = rs.getString("Min");
                String img = rs.getString("Img");
                String remark = rs.getString("Remark");
                String specs = rs.getString("Specs");
                String sort = rs.getString("Sort");
                
                good.setId(id);           
                good.setGno(gno);
                good.setName(name);
                good.setNum(num);
                good.setIprice(iprice);
                good.setOprice(oprice);
                good.setWarehouse(warehouse);
                good.setMax(max);
                good.setMin(min);
                good.setImg(img);
                good.setRemark(remark);               
                good.setSpecs(specs);
                good.setSort(sort);
                
                goods.add(good);
            }

            if(ps!=null)
            {ps.close();System.out.println("st已关闭");}
            if(c!=null)
            {c.close(); System.out.println("c已关闭");}
   

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return goods;
    }
	
    
    public   List<Goods> listall() {

        List<Goods> goods = new ArrayList<Goods>();

        String sql = "select * from goods where id is not null ORDER BY id desc ";

        try{
        	Connection c = Util.getConnection();
        	PreparedStatement ps = c.prepareStatement(sql);
          

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            	Goods good = new Goods();
            	
                String id = rs.getString("id");
                String gno = rs.getString("Gno");
                String name = rs.getString("name");
                String num = rs.getString("Num");
                String iprice = rs.getString("Iprice");
                String oprice = rs.getString("Oprice");
                String warehouse =rs.getString("Warehouse");
                String max = rs.getString("Max");
                String min = rs.getString("Min");
                String img = rs.getString("Img");
                String remark = rs.getString("Remark");
                String specs = rs.getString("Specs");
                String sort = rs.getString("Sort");
                
                good.setId(id);           
                good.setGno(gno);
                good.setName(name);
                good.setNum(num);
                good.setIprice(iprice);
                good.setOprice(oprice);
                good.setWarehouse(warehouse);
                good.setMax(max);
                good.setMin(min);
                good.setImg(img);
                good.setRemark(remark);               
                good.setSpecs(specs);
                good.setSort(sort);
                
                goods.add(good);
            }

            if(ps!=null)
            {ps.close();System.out.println("st已关闭");}
            if(c!=null)
            {c.close(); System.out.println("c已关闭");}
   

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return goods;
    }
    
    
    public Goods get(String id) {

        Goods good = new Goods();

        String sql = "SELECT * FROM goods WHERE id = " + id;
        try  {
        	Connection c = Util.getConnection();
        	Statement st = c.createStatement();
        	
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){

            	//String ID = rs.getString("id");
                String gno = rs.getString("Gno");
                String name = rs.getString("name");
                String num = rs.getString("Num");
                String iprice = rs.getString("Iprice");
                String oprice = rs.getString("Oprice");
                String warehouse =rs.getString("Warehouse");
                String max = rs.getString("Max");
                String min = rs.getString("Min");
                String img = rs.getString("Img");
                String remark = rs.getString("Remark");
                String specs = rs.getString("Specs");
                String sort = rs.getString("Sort");
                
                good.setId(id);           
                good.setGno(gno);
                good.setName(name);
                good.setNum(num);
                good.setIprice(iprice);
                good.setOprice(oprice);
                good.setWarehouse(warehouse);
                good.setMax(max);
                good.setMin(min);
                good.setImg(img);
                good.setRemark(remark);               
                good.setSpecs(specs);
                good.setSort(sort);
            }
            
            if(st!=null)
            {st.close();System.out.println("st已关闭");}
            if(c!=null)
            {c.close(); System.out.println("c已关闭");}
   

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return good;
    }
    
    
    
    public String namegetgno(String Name) {

        //Goods good = new Goods();
        String GNO="";

        String sql = "SELECT Gno FROM goods WHERE Name = '"+Name+"'";
        try  {
        	Connection c = Util.getConnection();
        	Statement st = c.createStatement();
        	
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){

            	
                String gno = rs.getString("Gno");
               GNO=gno;
            }
            
            if(st!=null)
            {st.close();System.out.println("st已关闭");}
            if(c!=null)
            {c.close(); System.out.println("c已关闭");}
   

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return GNO;
    }
    
    
    public  void update(Goods good) {

        String sql = "update goods set Gno = ?, Name = ?, Num = ?, Iprice = ?, Oprice = ?, Warehouse= ?,  Max=?,Min=?,Img=?,Remark=?,Specs=?,Sort=? where Id = ? ";
        try {
        	Connection c = Util.getConnection();
        	PreparedStatement ps = c.prepareStatement(sql);
        	
            ps.setString(1, good.getGno());
            ps.setString(2, good.getName()); 
            ps.setString(3, good.getNum());
            ps.setString(4, good.getIprice());
           // ps.setDate(5, new java.sql.Date(teacher.getBirthday().getTime()));
            
            ps.setString(5, good.getOprice());
          
            ps.setString(6, good.getWarehouse());
            ps.setString(7, good.getMax());
            ps.setString(8, good.getMin());
            ps.setString(9, good.getImg());
            ps.setString(10, good.getRemark());
            ps.setString(11, good.getSpecs()); 
            ps.setString(12, good.getSort());
            ps.setString(13, good.getId());
                  
            
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
        System.out.println("更新成功"+good.getName());
        
    }
    
    
    
    
    
    
    public  void GoodsOutput(String Gno,String Num) {
    	
    	int originNum=0;
    	int outputNum=Integer.parseInt(Num);
    	
        String sql = "SELECT Num FROM goods where Gno="+Gno+"";
        try
        {
        	Connection c = Util.getConnection();
        	Statement st = c.createStatement();
        	

            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
            	
            	System.out.println("num"+rs.getString("Num"));
            	
            	if(rs.getString("Num")!=null&&!rs.getString("Num").equals(""))
            	originNum = Integer.parseInt(rs.getString("Num"));
            	System.out.println("orifinnum"+originNum);
            	originNum=originNum-outputNum;
            	
            	
            	
               }
           /* PreparedStatement ps = c.prepareStatement("update goods set  Num= ? where Gno =  "+originNum+"");
       	   ps.execute();*/
            
            
            if(st!=null)
            {st.close();System.out.println("st已关闭");}
            if(c!=null)
            {c.close(); System.out.println("c已关闭");}
            
            System.out.println("ps1数量计算成功"+originNum);
        }
        catch (SQLException e) {
            e.printStackTrace();
        
        }

   
        try {
        	Connection c = Util.getConnection();
        	PreparedStatement ps = c.prepareStatement("update goods set  Num= "+originNum+" where Gno = "+Gno);
        	//ps.setString(1, x)
        	   ps.execute();
           
            
            System.out.println("ps1数量更新成功"+originNum);
            
         
            if(ps!=null)
            {ps.close();System.out.println("st已关闭");}
            if(c!=null)
            {c.close(); System.out.println("c已关闭");}
            


        } catch (SQLException x) {
            x.printStackTrace();
        }
        }
        
    
public  void GoodsInput(String Gno,String Num,String price) {
    	
    	int originNum=0;
     	//if(Num!=null&&!Num.equals(""))
    	int outputNum=Integer.parseInt(Num);
    	float originprice=0;
    	float iprice=Long.parseLong(price);
    	
        String sql = "SELECT Num ,IPrice FROM goods where Gno="+Gno+"";
        try
        {
        	Connection c = Util.getConnection();
        	Statement st = c.createStatement();
        	

            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
            	originNum = Integer.parseInt(rs.getString("Num"));
            	originNum=originNum+outputNum;
            	originprice=Float.parseFloat(rs.getString("IPrice"));
            	originprice=(originprice+iprice)/2;
            	
            	
               }
           /* PreparedStatement ps = c.prepareStatement("update goods set  Num= ? where Gno =  "+originNum+"");
       	   ps.execute();*/
            
            
            if(st!=null)
            {st.close();System.out.println("st已关闭");}
            if(c!=null)
            {c.close(); System.out.println("c已关闭");}
            
            System.out.println("ps1数量计算成功"+originNum);
        }
        catch (SQLException e) {
            e.printStackTrace();
        
        }

   
        try {
        	Connection c = Util.getConnection();
        	PreparedStatement ps = c.prepareStatement("update goods set  Num= "+originNum+",IPrice="+originprice+" where Gno = "+Gno);
        	
        	//ps.setString(1, x)
        	   ps.execute();
           
            
            System.out.println("ps1数量更新成功"+originNum);
            
         
            if(ps!=null)
            {ps.close();System.out.println("st已关闭");}
            if(c!=null)
            {c.close(); System.out.println("c已关闭");}
            


        } catch (SQLException x) {
            x.printStackTrace();
        }
        }
    
    
    
	
    
    public  void updateImg(int id,String IMG) {

        String sql = "update goods set  img= ? where id = ? ";
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
    
    
    public void add(Goods good) {
        String sql = "INSERT INTO goods VALUES(NULL,?,?,?,?,?,?,?,?,?,?,?,?)";
        try  {
        	Connection c = Util.getConnection(); 
        	PreparedStatement ps = c.prepareStatement(sql);
        	 ps.setString(1, good.getGno());
             ps.setString(2, good.getName()); 
             ps.setString(3, good.getNum());
             ps.setString(4, good.getIprice());
            // ps.setDate(5, new java.sql.Date(teacher.getBirthday().getTime()));
             
             ps.setString(5, good.getOprice());
           
             ps.setString(6, good.getWarehouse());
             ps.setString(7, good.getMax());
             ps.setString(8, good.getMin());
             ps.setString(9, good.getImg());
             ps.setString(10, good.getRemark());
             ps.setString(11, good.getSpecs()); 
             ps.setString(12, good.getSort());
        
            ps.execute();
            
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

        String sql = "SELECT COUNT(*) FROM goods";
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

        String sql = "DELETE FROM goods WHERE Id = ?";
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
    
    
    public List<Goods> Namelist(int start, int count,String Name) {

        List<Goods> goods = new ArrayList<Goods>();

        String sql = "SELECT * FROM goods where Name like'%"+Name+"%' ORDER BY id desc limit ?,?";

        try{
        	Connection c = Util.getConnection();
        	PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, start);
            ps.setInt(2, count);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            	Goods good = new Goods();
            	
                String id = rs.getString("id");
                String gno = rs.getString("Gno");
                String name = rs.getString("name");
                String num = rs.getString("Num");
                String iprice = rs.getString("Iprice");
                String oprice = rs.getString("Oprice");
                String Warehouse =rs.getString("Warehouse");
                String max = rs.getString("Max");
                String min = rs.getString("Min");
                String img = rs.getString("Img");
                String remark = rs.getString("Remark");
                String specs = rs.getString("Specs");
                String sort = rs.getString("Sort");
                
                good.setId(id);           
                good.setGno(gno);
                good.setName(name);
                good.setNum(num);
                good.setIprice(iprice);
                good.setOprice(oprice);
                good.setWarehouse(Warehouse);
                good.setMax(max);
                good.setMin(min);
                good.setImg(img);
                good.setRemark(remark);               
                good.setSpecs(specs);
                good.setSort(sort);
                
                goods.add(good);
            }

            if(ps!=null)
            {ps.close();System.out.println("st已关闭");}
            if(c!=null)
            {c.close(); System.out.println("c已关闭");}
   

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return goods;
    }
    
    
    
public int getNameTotal( String Name ){
		
		//mark
        int total = 0;

        String sql = "SELECT COUNT(*) FROM goods where Name like'%"+Name+"%' ";
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
    
    
    
    public List<Goods> Gnolist(int start, int count,String Gno) {

        List<Goods> goods = new ArrayList<Goods>();

        String sql = "SELECT * FROM goods where gno like'%"+Gno+"%' ORDER BY id desc limit ?,?";

        try{
        	Connection c = Util.getConnection();
        	PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, start);
            ps.setInt(2, count);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            	Goods good = new Goods();
            	
                String id = rs.getString("id");
                String gno = rs.getString("Gno");
                String name = rs.getString("name");
                String num = rs.getString("Num");
                String iprice = rs.getString("Iprice");
                String oprice = rs.getString("Oprice");
                String Warehouse =rs.getString("Warehouse");
                String max = rs.getString("Max");
                String min = rs.getString("Min");
                String img = rs.getString("Img");
                String remark = rs.getString("Remark");
                String specs = rs.getString("Specs");
                String sort = rs.getString("Sort");
                
                good.setId(id);           
                good.setGno(gno);
                good.setName(name);
                good.setNum(num);
                good.setIprice(iprice);
                good.setOprice(oprice);
                good.setWarehouse(Warehouse);
                good.setMax(max);
                good.setMin(min);
                good.setImg(img);
                good.setRemark(remark);               
                good.setSpecs(specs);
                good.setSort(sort);
                
                goods.add(good);
            }

            if(ps!=null)
            {ps.close();System.out.println("st已关闭");}
            if(c!=null)
            {c.close(); System.out.println("c已关闭");}
   

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return goods;
    }
    
    
    
public int getGnoTotal( String Gno ){
		
		//mark
        int total = 0;

        String sql = "SELECT COUNT(*) FROM goods where Gno like'%"+Gno+"%' ";
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
    
    
    
   
    public List<Goods> Wlist(int start, int count,String warehouse) {

        List<Goods> goods = new ArrayList<Goods>();

        String sql = "SELECT * FROM goods where warehouse like'%"+warehouse+"%' ORDER BY id desc limit ?,?";

        try{
        	Connection c = Util.getConnection();
        	PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, start);
            ps.setInt(2, count);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            	Goods good = new Goods();
            	
                String id = rs.getString("id");
                String gno = rs.getString("Gno");
                String name = rs.getString("name");
                String num = rs.getString("Num");
                String iprice = rs.getString("Iprice");
                String oprice = rs.getString("Oprice");
               // String Warehouse =rs.getString("Warehouse");
                String max = rs.getString("Max");
                String min = rs.getString("Min");
                String img = rs.getString("Img");
                String remark = rs.getString("Remark");
                String specs = rs.getString("Specs");
                String sort = rs.getString("Sort");
                
                good.setId(id);           
                good.setGno(gno);
                good.setName(name);
                good.setNum(num);
                good.setIprice(iprice);
                good.setOprice(oprice);
                good.setWarehouse(warehouse);
                good.setMax(max);
                good.setMin(min);
                good.setImg(img);
                good.setRemark(remark);               
                good.setSpecs(specs);
                good.setSort(sort);
                
                goods.add(good);
            }

            if(ps!=null)
            {ps.close();System.out.println("st已关闭");}
            if(c!=null)
            {c.close(); System.out.println("c已关闭");}
   

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return goods;
    }
    
    public int getWTotal( String warehouse ){
		
		//mark
        int total = 0;

        String sql = "SELECT COUNT(*) FROM warehouse where Wno like'%"+warehouse+"%' ";
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

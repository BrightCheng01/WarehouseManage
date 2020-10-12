package servlet;

import java.io.IOException;



import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import filter.MD5;

import Bean.Admin;
import Bean.Client;
import Bean.Goods;
import Bean.Warehouse;
import DAO.AdminDAO;
import DAO.ClientDAO;
import DAO.GoodsDAO;
import DAO.WarehouseDAO;

@WebServlet("/AEdit.do")

public class AEditServlet extends HttpServlet {

	
	/*public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();

		
		
		String select=request.getParameter("select");
		request.getParameter("img");
		
		
		
		
		if("goods".equals(select))
		{
			
			
			//Goods goodx =new Goods();
			Goods good =new Goods();
			GoodsDAO goodsdao=new GoodsDAO();
			
			//goodx= (Goods)request.getSession().getAttribute("good");//不通
			String id=request.getParameter("gid");
			//goodx=null;
	
			good=goodsdao.get(id);
		
			 System.out.println(id+"更新后头像"+good.getImg());
			session.setAttribute("good", good);
			 System.out.println(id+"跳转"+good.getImg());
			RequestDispatcher dis=request.getRequestDispatcher("GoodsEdit.jsp");
			dis.forward(request, response);
			
			

			
			
			
		}
		

		
		
		
	}*/

	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MD5 md=new MD5();
		HttpSession session = request.getSession();

		
		
		String select=request.getParameter("select");
		request.getParameter("img");
		
		 System.out.println(select);
		
		if("admin".equals(select))
		{
			String NPWD=md.start(request.getParameter("pwd"));
			String OPWD=md.start(request.getParameter("oldpwd"));
			
			Client admins =new Client();
			Client admin =new Client();
			ClientDAO admindao=new ClientDAO();
			
			admins= (Client)request.getSession().getAttribute("admin");
			int id=admins.getId();
			admins=null;
			
			admin.setId(id);
			
			admin.setCno(Integer.parseInt(request.getParameter("cno")));		
			admin.setName(request.getParameter("name"));
			admin.setSex(request.getParameter("sex"));
			admin.setRemark(request.getParameter("remark"));
			admin.setImg(request.getParameter("img"));
			
			
			/*if(request.getParameter("pwd")!=null&&request.getParameter("pwd").equals("")==false)
	        {
	        	System.out.println("这是"+request.getParameter("pwd"));
	        	//String pwd=md.start(request.getParameter("pwd"));
	        	String pwd=request.getParameter("pwd");
	        	admin.setPwd(pwd);
	        	System.out.println("改密成功");
	        }
	        else
	        {String pwd=request.getParameter("oldpwd");
	        admin.setPwd(pwd);     
	        System.out.println(pwd);}*/
			if(request.getParameter("pwd")!=null&&request.getParameter("pwd").equals("")==false)
	        {
	        	System.out.println("这是"+request.getParameter("pwd"));
	        	//String pwd=md.start(request.getParameter("pwd"));
	        	String pwd=request.getParameter("pwd");
	        	admin.setPwd(NPWD);
	        	System.out.println("改密成功");
	        }
	        else
	        {String pwd=request.getParameter("oldpwd");
	        admin.setPwd(OPWD);     
	        System.out.println(OPWD);}
			
			admindao.update(admin);
			admin=null;
			admin=admindao.get(id);
			
			 System.out.println(id+"更新后头像"+admin.getImg());
			session.setAttribute("admin", admin);
			
			RequestDispatcher dis=request.getRequestDispatcher("AdminEdit.jsp");
			dis.forward(request, response);
		}
		
		
		if("goods".equals(select))
		{
			
			
			//Goods goodx =new Goods();
			Goods good =new Goods();
			GoodsDAO goodsdao=new GoodsDAO();
			
			//goodx= (Goods)request.getSession().getAttribute("good");//不通
			String id=request.getParameter("id");
			//goodx=null;
	
			good=goodsdao.get(id);
		
			 System.out.println(id+"更新后头像"+good.getImg());
			 System.out.println(id+"跳转"+good.getImg());
			session.setAttribute("good", good);
			
			RequestDispatcher dis=request.getRequestDispatcher("GoodsEdit.jsp");
			dis.forward(request, response);
			
			

			
			
			
		}
		
		if("warehouses".equals(select))
		{
									
			Warehouse warehouse =new Warehouse();
			WarehouseDAO warehousedao=new WarehouseDAO();
			
			String id=request.getParameter("id");		
	
			warehouse=warehousedao.get(id);		
			
			session.setAttribute("warehouse", warehouse);
			
			RequestDispatcher dis=request.getRequestDispatcher("WarehouseEdit.jsp");
			dis.forward(request, response);
	
		}
		
		
		
		if("client".equals(select))
		{
									
			Client client =new Client();
			ClientDAO clientdao=new ClientDAO();
			
				

			client=clientdao.get(Integer.parseInt(request.getParameter("id")));		
			
			session.setAttribute("client", client);
			
			RequestDispatcher dis=request.getRequestDispatcher("ClientEdit.jsp");
			dis.forward(request, response);
	
		}
		
		
		if("Cclient".equals(select))
		{
									
			Client client =new Client();
			ClientDAO clientdao=new ClientDAO();
			
				

			client=clientdao.get(Integer.parseInt(request.getParameter("id")));		
			
			session.setAttribute("client", client);
			
			RequestDispatcher dis=request.getRequestDispatcher("CEdit.jsp");
			dis.forward(request, response);
	
		}
		
		
		
		
		
		
	}

}

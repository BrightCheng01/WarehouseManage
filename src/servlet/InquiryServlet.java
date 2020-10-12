package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Client;
import Bean.Goods;
import Bean.Warehouse;
import DAO.ClientDAO;
import DAO.GoodsDAO;
import DAO.WarehouseDAO;

import util.Page;
@WebServlet("/inquiry.do")
public class InquiryServlet extends HttpServlet {
	
	private GoodsDAO goodsdao = new GoodsDAO();
	private WarehouseDAO warehousedao = new WarehouseDAO();
	private ClientDAO clientdao = new ClientDAO();

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		 int start = 0; // 获取分页参数
	        int count = 7;

	        try {
	            start = Integer.parseInt(request.getParameter("page.start"));
	          //  count = Integer.parseInt(req.getParameter("page.count"));
	        } catch (Exception e) {
	        }

	        Page page = new Page(start, count);
		

		HttpSession session = request.getSession();
		
	String select=request.getParameter("select");
	String keyword =request.getParameter("keyword");
	
	if("good".equals(select))
	{
		if("Gno".equals(keyword))
		{ 
			String Gno=request.getParameter("Gno");
			List<Goods> goods = goodsdao.Gnolist(page.getStart(), page.getCount(),Gno );
        int total = goodsdao.getGnoTotal(Gno);
        page.setTotal(total);
        
        session.setAttribute("goods", goods);
        session.setAttribute("page", page);	        
   
        request.getRequestDispatcher("/AdminGoods.jsp").forward(request, response);
			
			
			
		}
		
		if("Gname".equals(keyword))
		{
			String Gname=request.getParameter("Gname");
			List<Goods> goods = goodsdao.Namelist(page.getStart(), page.getCount(),Gname );
	        int total = goodsdao.getNameTotal(Gname);
	        page.setTotal(total);
	        
	        session.setAttribute("goods", goods);
	        session.setAttribute("page", page);	        
	   
	        request.getRequestDispatcher("/AdminGoods.jsp").forward(request, response);
				
			
			
		}
		
	}
	
	if("warehouse".equals(select))
	{
		if("Wno".equals(keyword))
		{ 
			String Wno=request.getParameter("Wno");
			List<Warehouse> warehouses = warehousedao.wnolist(page.getStart(), page.getCount(),Wno );
        int total = warehousedao.getwnoTotal(Wno);
        page.setTotal(total);
        
        session.setAttribute("warehouses", warehouses);
        session.setAttribute("page", page);	        
   
        request.getRequestDispatcher("/AdminWarehouse.jsp").forward(request, response);
			
			
			
		}
		
		if("Wname".equals(keyword))
		{
			String Wname=request.getParameter("Wname");
			List<Warehouse> warehouses = warehousedao.Namelist(page.getStart(), page.getCount(),Wname );
        int total = warehousedao.getNameTotal(Wname);
        page.setTotal(total);
        
        session.setAttribute("warehouses", warehouses);
        session.setAttribute("page", page);	        
   
        request.getRequestDispatcher("/AdminWarehouse.jsp").forward(request, response);
				
			
			
		}
		
	}
	
	
	if("user".equals(select))
	{
		if("Cno".equals(keyword))
		{ 
			String Cno=request.getParameter("Cno");
			List<Client> clients = clientdao.userCnolist(page.getStart(), page.getCount(),Cno );
        int total = clientdao.getuserCnoTotal(Cno);
        page.setTotal(total);
        
        session.setAttribute("users", clients);
        session.setAttribute("page", page);	        
   
        request.getRequestDispatcher("/listUser.jsp").forward(request, response);
			
			
			
		}
		
		if("Cname".equals(keyword))
		{
			String Cname=request.getParameter("Cname");
			List<Client> clients = clientdao.userNamelist(page.getStart(), page.getCount(),Cname );
        int total = clientdao.getuserNameTotal(Cname);
        page.setTotal(total);
        
        session.setAttribute("users", clients);
        session.setAttribute("page", page);	        
   
        request.getRequestDispatcher("/listUser.jsp").forward(request, response);
				
			
			
		}
		
	}
	
	
	
	if("client".equals(select))
	{
		if("Cno".equals(keyword))
		{ 
			String Cno=request.getParameter("Cno");
			List<Client> clients = clientdao.Cnolist(page.getStart(), page.getCount(),Cno );
        int total = clientdao.getCnoTotal(Cno);
        page.setTotal(total);
        
        session.setAttribute("clients", clients);
        session.setAttribute("page", page);	        
   
        request.getRequestDispatcher("/AdminClient.jsp").forward(request, response);
			
			
			
		}
		
		if("Cname".equals(keyword))
		{
			String Cname=request.getParameter("Cname");
			List<Client> clients = clientdao.Namelist(page.getStart(), page.getCount(),Cname );
        int total = clientdao.getNameTotal(Cname);
        page.setTotal(total);
        
        session.setAttribute("clients", clients);
        session.setAttribute("page", page);	        
   
        request.getRequestDispatcher("/AdminClient.jsp").forward(request, response);
				
			
			
		}
		
	}
	
	
	
	
	
	
	
	}

}

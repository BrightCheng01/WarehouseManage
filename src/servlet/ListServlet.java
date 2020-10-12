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



import util.Page;
import Bean.Client;
import Bean.Goods;
import Bean.Warehouse;
import DAO.ClientDAO;
import DAO.GoodsDAO;
import DAO.WarehouseDAO;

@WebServlet("/list.do")
public class ListServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	private GoodsDAO goodsdao = new GoodsDAO();
	private WarehouseDAO warehousedao = new WarehouseDAO();
	private ClientDAO clientdao = new ClientDAO();
	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//here
		
		String select =request.getParameter("select");
		System.out.println(select);
		
		
        int start = 0; // 获取分页参数
        int count = 6;

        try {
            start = Integer.parseInt(request.getParameter("page.start"));
          //  count = Integer.parseInt(req.getParameter("page.count"));
        } catch (Exception e) {
        }

        Page page = new Page(start, count);
        
        
        if("client".equals(select))
        {
        	HttpSession session = request.getSession();

	        List<Client> clients = clientdao.Clist(page.getStart(), page.getCount());
	        int total = clientdao.getCTotal();
	        page.setTotal(total);
	        session.setAttribute("clients", clients);
	        session.setAttribute("page", page);
	        request.getRequestDispatcher("/AdminClient.jsp").forward(request, response);
        }
        
        
        
        
        if("user".equals(select))
        {
        	HttpSession session = request.getSession();

	        List<Client> clients = clientdao.list(page.getStart(), page.getCount());
	        int total = clientdao.getTotal();
	        page.setTotal(total);
	        session.setAttribute("users", clients);
	        session.setAttribute("page", page);
	        request.getRequestDispatcher("/listUser.jsp").forward(request, response);
        }
        
        
        
        if("goods".equals(select))
        {
        	HttpSession session = request.getSession();
        	
		        List<Goods> goods = goodsdao.list(page.getStart(), page.getCount());
		        int total = goodsdao.getTotal();
		        page.setTotal(total);
		        
		        session.setAttribute("goods", goods);
		        session.setAttribute("page", page);	        
		   
		        request.getRequestDispatcher("/AdminGoods.jsp").forward(request, response);
				
        }
        
        if("Sellgoods".equals(select))
        {
        	HttpSession session = request.getSession();
        	
		        List<Goods> goods = goodsdao.list(page.getStart(), page.getCount());
		        int total = goodsdao.getTotal();
		        page.setTotal(total);
		    
		        
		        session.setAttribute("goods", goods);
		        session.setAttribute("page", page);
		    
		        request.getRequestDispatcher("/ClientGoods.jsp").forward(request, response);
				
        }
        
        if("warehouses".equals(select))
        {
        	HttpSession session = request.getSession();
        	
		        List<Warehouse> warehouses = warehousedao.list(page.getStart(), page.getCount());
		        int total = warehousedao.getTotal();
		        page.setTotal(total);
		        
		    
		        
		        session.setAttribute("warehouses", warehouses);
		        session.setAttribute("page", page);
		        
		      /*  req.setAttribute("id", id);//mid
		        req.setAttribute("back", back);
		        req.setAttribute("students", students);
		        req.setAttribute("page", page);
		        req.setAttribute("manager", manager);*/
		        request.getRequestDispatcher("/AdminWarehouse.jsp").forward(request, response);
				
        }
        
        if("showwarehouses".equals(select))
        {
        	HttpSession session = request.getSession();
        	String wno=request.getParameter("wno");
        	
        	List<Goods> goods = goodsdao.Wlist(page.getStart(), page.getCount(), wno);
        	 int total = goodsdao.getWTotal(wno);
        	page.setTotal(total);
        	session.setAttribute("goods", goods);
	        session.setAttribute("page", page);
	        request.getRequestDispatcher("/AdminGoods.jsp").forward(request, response);
        	
        }
        
        if("Cgoods".equals(select))
        {
        	HttpSession session = request.getSession();
        	
		        List<Goods> goods = goodsdao.list(page.getStart(), page.getCount());
		        int total = goodsdao.getTotal();
		        page.setTotal(total);
		    
		        
		        session.setAttribute("goods", goods);
		        session.setAttribute("page", page);
		    
		        request.getRequestDispatcher("/ClientGoods.jsp").forward(request, response);
				
        }
        
        
		
	}

}

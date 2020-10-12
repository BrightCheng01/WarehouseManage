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

import Bean.Client;
import Bean.Goods;
import Bean.Warehouse;
import DAO.ClientDAO;
import DAO.GoodsDAO;
import DAO.WarehouseDAO;


@WebServlet("/Delete.do")
public class DeleteServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	
	}

	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();

		String select=request.getParameter("select");
		
    	if("goods".equals(select))
    	{
    		Goods goods=new Goods();
    		GoodsDAO goodsdao=new GoodsDAO();
    		
        String id = request.getParameter("id");
        new GoodsDAO().delete(id);
         
      
        request.setAttribute("select", select);
       /* goods=goodsdao.get(id);
		
		 System.out.println(id+"更新后头像"+goods.getImg());
		session.setAttribute("goods", goods);*/
		
        System.out.println("id"+id);
        
		RequestDispatcher dis=request.getRequestDispatcher("list.do");
		dis.forward(request, response);
        
      //  resp.sendRedirect("/DBTest/listStudent?back=manager&id="+mid);
        }
    	
    	if("warehouses".equals(select))
    	{
    		Warehouse warehouse=new Warehouse();
    		//WarehouseDAO warehousedao=new WarehouseDAO();
    		
        String id = request.getParameter("id");
        new WarehouseDAO().delete(id);
         
      
        request.setAttribute("select", select);
      
		
        System.out.println("id"+id);
        
		RequestDispatcher dis=request.getRequestDispatcher("list.do");
		dis.forward(request, response);
        
    
        }
    	
    	
    	if("client".equals(select))
    	{
    		Client client=new Client();
    	
        int id = Integer.parseInt(request.getParameter("id"));
        new ClientDAO().delete(id);
         
      
        request.setAttribute("select", select);
      
		
        System.out.println("id"+id);
        
		RequestDispatcher dis=request.getRequestDispatcher("list.do");
		dis.forward(request, response);
        
    
        }
    	
    	
    	if("user".equals(select))
    	{
    		Client client=new Client();
    	
        int id = Integer.parseInt(request.getParameter("id"));
        new ClientDAO().delete(id);
         
      
        request.setAttribute("select", select);
      
		
        System.out.println("id"+id);
        
		RequestDispatcher dis=request.getRequestDispatcher("list.do");
		dis.forward(request, response);
        
    
        }
		
		
	}

}

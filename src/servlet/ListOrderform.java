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
import Bean.Orderform;
import DAO.OrderformDAO;
@WebServlet("/listOrder.do")
public class ListOrderform extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String select=request.getParameter("select");
		
		int start = 0; // 获取分页参数
        int count = 66;

        try {
            start = Integer.parseInt(request.getParameter("page.start"));
          //  count = Integer.parseInt(req.getParameter("page.count"));
        } catch (Exception e) {
        }

        Page page = new Page(start, count);
		
		
		
		if("client".equals(select))
		{
			int cno=Integer.parseInt(request.getParameter("cno"));
			
			OrderformDAO orderformdao=new OrderformDAO();
			//Orderform orderform=new Orderform();
			
			
			 List<Orderform> orderforms = orderformdao.CnoList(page.getStart(), page.getCount(),request.getParameter("cno"));
			
		        int total = orderformdao.getCnoTotal(cno);
		        page.setTotal(total);
		        session.setAttribute("orderforms", orderforms);
		        session.setAttribute("page", page);
		        request.getRequestDispatcher("/ClientOrderform.jsp").forward(request, response);
			
			
			
		}
		
		if("admin".equals(select))
		{
			
			
			OrderformDAO orderformdao=new OrderformDAO();
						
			
			 List<Orderform> orderforms = orderformdao.listisdone(page.getStart(), page.getCount());
		        int total = orderformdao.getisdoneTotal();
		        System.out.println("未处理数量"+total);
		        page.setTotal(total);
		        session.setAttribute("orderforms", orderforms);
		        session.setAttribute("page", page);
		        
		      
		        
		        request.getRequestDispatcher("/AdminOutput.jsp").forward(request, response);
			
			
			
		}
		

		
		
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}

package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Goods;
import Bean.IRecord;
import DAO.GoodsDAO;
import DAO.InputDAO;
@WebServlet("/GoodsIO.do")
public class GoodsIOServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String select =request.getParameter("select");
		
		if("input".equals(select));
		{
			
			GoodsDAO goodsdao=new GoodsDAO();
			
			List<Goods> goods = goodsdao.listall();
		      
			   
	        session.setAttribute("goods", goods);
	        request.getRequestDispatcher("/AdminInput.jsp").forward(request, response);
			
			
		}
		

	
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}

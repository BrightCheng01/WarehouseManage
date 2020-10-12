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

import Bean.IRecord;
import Bean.ORecord;
import Bean.Orderform;
import DAO.InputDAO;
import DAO.OrderformDAO;
import DAO.OutputDAO;

import util.Page;
@WebServlet("/ListRecord.do")
public class ListRecordServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String select=request.getParameter("select");
		
		int start = 0; // 获取分页参数
        int count = 7;

        try {
            start = Integer.parseInt(request.getParameter("page.start"));
          //  count = Integer.parseInt(req.getParameter("page.count"));
        } catch (Exception e) {
        }

        Page page = new Page(start, count);
		
		
		if("irecord".equals(select))
		{

			InputDAO inputdao=new InputDAO();
						
			
			 List<IRecord> irecords = inputdao.list(page.getStart(), page.getCount());
		        int total = inputdao.getTotal();
		  
		        page.setTotal(total);
		        session.setAttribute("irecords", irecords);
		        session.setAttribute("page", page);
		        
		        request.getRequestDispatcher("/Irecord.jsp").forward(request, response);
		}
		

		if("orecord".equals(select))
		{
			
			OutputDAO outputdao=new OutputDAO();
			
			
			 List<ORecord> orecords = outputdao.list(page.getStart(), page.getCount());
		        int total = outputdao.getTotal();
		  
		        page.setTotal(total);
		        session.setAttribute("orecords", orecords);
		        session.setAttribute("page", page);
		        
		        request.getRequestDispatcher("/Orecord.jsp").forward(request, response);
			
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}

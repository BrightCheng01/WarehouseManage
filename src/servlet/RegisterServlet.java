package servlet;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import filter.MD5;

import Bean.Admin;
import Bean.Client;
import DAO.AdminDAO;
import DAO.ClientDAO;

@WebServlet("/register.do")
public class RegisterServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MD5 md=new MD5();
		String PWD=md.start(request.getParameter("pwd"));
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		ClientDAO admindao=new ClientDAO();

		String roption=request.getParameter("roption");
		int CNO=Integer.parseInt(request.getParameter("Cno"));
		
		if("admin".equals(roption))
		{
			if(admindao.AisExist(Integer.parseInt(request.getParameter("ano")))==true)
			{
				//RequestDispatcher dis=request.getRequestDispatcher("login.jsp");
				out.print("<script>alert('账户存在！');window.location.href='Register.jsp?roption=admin'</script>");
				
			}
			
			
			else{	
			Client admin=new Client();
			admin.setCno(Integer.parseInt(request.getParameter("ano")));
			admin.setName(request.getParameter("name"));
			admin.setSex(request.getParameter("Sex"));
			admin.setPwd(PWD);
			admin.setRemark(request.getParameter("remark"));
			
			new ClientDAO().Aadd(admin);
			
			RequestDispatcher dis=request.getRequestDispatcher("login.jsp");
			dis.forward(request, response);
			}
		}
		
		if("client".equals(roption))
		{
			
			
			Client client=new Client();
			ClientDAO clientdao=new ClientDAO();
			
			
			if(clientdao.CisExist(CNO)==true)
			{
				//RequestDispatcher dis=request.getRequestDispatcher("login.jsp");
				out.print("<script>alert('账户存在！');window.location.href='Register.jsp?roption=client'</script>");
				
			}

			else{		System.out.println("Cno"+request.getParameter("Cno"));
			
			client.setCno(Integer.parseInt(request.getParameter("Cno")));		
			client.setName(request.getParameter("Name"));
			client.setCon(request.getParameter("Con"));
			client.setAddress(request.getParameter("Address"));					
			client.setTel(request.getParameter("Tel"));
			client.setRemark(request.getParameter("Remark"));
			client.setSex(request.getParameter("Sex"));
			client.setPwd(PWD);
			
			
			clientdao.Cadd(client);
			RequestDispatcher dis=request.getRequestDispatcher("login.jsp");
			dis.forward(request, response);
			}
		}
		
	}

}

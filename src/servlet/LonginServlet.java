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

import DAO.AdminDAO;
import DAO.ClientDAO;

@WebServlet("/login.do")
public class LonginServlet extends HttpServlet {





	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		MD5 md=new MD5();
		
		HttpSession session = request.getSession();
		String option=request.getParameter("option");
		
		
		int ANo=Integer.parseInt(request.getParameter("username"));

		String pwd=md.start(request.getParameter("password"));

		
		
		if("admin".equals(option))
		{
			System.out.println("管理员登陆");
		ClientDAO admindao=new ClientDAO();//	AdminDAO admindao=new AdminDAO();	
			
			Client admin=new Client();//Admin admin=new Admin();	
			admin=admindao.login(ANo);
			
		if(admindao.AisExist(ANo)==false)
		{
			//RequestDispatcher dis=request.getRequestDispatcher("login.jsp");
			out.print("<script>alert('账户不存在！');window.location.href='login.jsp'</script>");
			
		}
			
			
			
			else if(ANo==(admin.getCno())&&pwd.equals(admin.getPwd())==true)
		{
				
				
				
			System.out.println("密码正确");
			
			session.setAttribute("admin", admin);	
			System.out.println("id"+admin.getId());
			System.out.println("名字"+session.getId());
			
			RequestDispatcher dis=request.getRequestDispatcher("Admin.jsp");
			dis.forward(request, response);
	    //  request.getRequestDispatcher("Admin.jsp").forward(request, response);

	     
		}
			
			else {
				out.print("<script>alert('密码错误！');window.location.href='login.jsp'</script>");
			}
			
		
	}
		
		if("client".equals(option))
		{
			
			System.out.println("客户登陆");
			ClientDAO clientdao=new ClientDAO();	
			Client client=new Client();	
			
			client=clientdao.login(ANo);
			
			if(clientdao.CisExist(ANo)==false)
			{
				System.out.println("账户不存在D");
				out.print("<script>alert('账户不存在！');window.location.href='login.jsp'</script>");
				
				 
			}
			
			
			else if(ANo==(client.getCno())&&pwd.equals(client.getPwd())==true)
			 {
				
				
				
			System.out.println("密码正确");
			
			session.setAttribute("client", client);	
			System.out.println("id"+client.getId());
			System.out.println("客户名字"+session.getId());
			
			RequestDispatcher dis=request.getRequestDispatcher("Client.jsp");
			dis.forward(request, response);
	    //  request.getRequestDispatcher("Admin.jsp").forward(request, response);

	     
		} 
			
			else {
				out.print("<script>alert('密码错误！');window.location.href='login.jsp'</script>");
			}
		
	}
		
		
		//String name=admin.getAName();
	
		
		/*if(ANo==(admin.getANo())&&pwd.equals(admin.getAPwd())==true)
		{
			System.out.println("密码正确");
			//request.setAttribute("manager", manager);
			
			session.setAttribute("admin", admin);
			
			System.out.println("名字"+admin.getAName());
			
	      request.getRequestDispatcher("/Admin.jsp").forward(request, response);

	        
	     
		}*/
		
		
		
	
		
		
		
		
		
		/*else if(ID==(manager.getManagerID())&&pwd.equals(manager.getPwd())==false)
		{

			req.getRequestDispatcher("/loginInfo.jsp?mark=pwd").forward(req, resp);
			
		}
		else if(name==null)
		{
			
			req.getRequestDispatcher("/loginInfo.jsp?mark=account").forward(req, resp);
		}*/
		


	
	}

}

package servlet;

import java.io.IOException;


import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;


import Bean.Admin;
import Bean.Client;
import Bean.Goods;
import DAO.AdminDAO;
import DAO.ClientDAO;
import DAO.GoodsDAO;
@MultipartConfig(location="D:/Tomcat/webapps/WarehouseManage/img")
@WebServlet("/uploadphoto")
public class uploadphoto extends HttpServlet {
private static final long serialVersionUID = 1L;

protected void doPost(HttpServletRequest request,
	HttpServletResponse response) throws ServletException, IOException {
	
	HttpSession session = request.getSession();
	
	request.setCharacterEncoding("utf-8");
	Part part = request.getPart("photo");
	String fileName = getFileName(part);
	part.write(fileName);
	
	String IMG="img/"+fileName;
	String select=request.getParameter("select");
	int id=Integer.parseInt(request.getParameter("id"));
	
	if(select.equals("admin"))
	{
		Admin admin=new Admin();
		AdminDAO admindao=new AdminDAO();
		System.out.println("管理员图片更新成功"+IMG);
		admindao.updateImg(id, IMG);
		admin=admindao.get(id);
		session.setAttribute("admin", admin);
		
		request.getRequestDispatcher("AdminEdit.jsp").forward(request, response);
	}
	
	
	
	if(select.equals("good"))
	{
		Goods good=new Goods();
		GoodsDAO gooddao=new GoodsDAO();
		System.out.println("货物图片更新成功"+IMG);
		gooddao.updateImg(id, IMG);
		good=gooddao.get(String.valueOf(id));
		session.setAttribute("good", good);
		
		request.getRequestDispatcher("GoodsEdit.jsp").forward(request, response);
	}
	
	
	if(select.equals("client"))
	{
		Client client=new Client();
		ClientDAO clientdao=new ClientDAO();
		System.out.println("客户图片更新成功"+IMG);
		clientdao.updateImg(id, IMG);
		client=clientdao.get(id);
		session.setAttribute("client", client);
		
		request.getRequestDispatcher("ClientEdit.jsp").forward(request, response);
	}
	
	if(select.equals("Cclient"))
	{
		Client client=new Client();
		ClientDAO clientdao=new ClientDAO();
		System.out.println("客户图片更新成功"+IMG);
		clientdao.updateImg(id, IMG);
		client=clientdao.get(id);
		session.setAttribute("client", client);
		
		request.getRequestDispatcher("CEdit.jsp").forward(request, response);
	}
	
	
	/*if(select.equals("student"))
	{
		 student=new Student();
		StudentDAO studentdao=new StudentDAO();
		 System.out.println("ps1更新成功"+id);
		studentdao.updateImg(id, IMG);
		 System.out.println("ps1更新成功"+IMG);
		student=studentdao.get(id);
		req.setAttribute("student", student);
		System.out.println("学生图片更新成功");
		
		 req.getRequestDispatcher("/Student.jsp").forward(req, resp);
		
	}*/
	
	}
	
	
	
	private String getFileName(Part part) {
	String head = part.getHeader("Content-Disposition");
	String fileName = head.substring(head.indexOf("filename=\"")+10, head.lastIndexOf("\""));
	System.out.println(fileName);
	return fileName;
    }
 
}
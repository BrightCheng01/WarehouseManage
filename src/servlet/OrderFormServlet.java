package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Client;
import Bean.Orderform;
import DAO.ClientDAO;
import DAO.OrderformDAO;
@WebServlet("/Order.do")
public class OrderFormServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

	
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		String select=request.getParameter("select");
		int min=Integer.parseInt(request.getParameter("min"));
		int max=Integer.parseInt(request.getParameter("max"));
		int Buynum=Integer.parseInt(request.getParameter("Num"));
		int truenum=max-min;
		
				if("client".equals(select))
				{
					
					if(min<Buynum)
					{
						out.print("<script>alert('库存不足！购买数量不得超过"+truenum+"件');window.location.href='ClientGoods.jsp'</script>");
					}
					
					else{	Date d = new Date();
					SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
					String now = df.format(d);
				
					
					
					int id=Integer.parseInt(request.getParameter("id")); 
					ClientDAO clientdao=new ClientDAO();
					Client client =new Client();					
					client=clientdao.get(id);
					
					OrderformDAO orderformdao=new OrderformDAO();
					Orderform orderform=new Orderform();
													
					
		                String ordercode=now+id;
		                String name = request.getParameter("Name");		             
		                String gno = request.getParameter("Gno");
		                String num = request.getParameter("Num");
		                String price = request.getParameter("price");
		                
		                System.out.println("Num"+num);
		                System.out.println("Price"+price);
		                float total=Float.parseFloat(num)*Float.parseFloat(price);
		                		                
		                String totalprice =String.valueOf(total);
		                String cname =client.getName();
		                String cno = String.valueOf(client.getCno());
		                String con = String.valueOf(client.getCno());
		                String tel =client.getTel();
		                String address = client.getAddress();
		                String date = now;
		                String isdone = "未处理";
		                
		                orderform.setOrdercode(ordercode);
		                orderform.setName(name);
		                orderform.setGno(gno);
		                orderform.setNum(num);
		                orderform.setPrice(price);
		                orderform.setTotalprice(totalprice);	                
		                orderform.setCname(cname);
		                orderform.setCno(cno);
		                orderform.setTel(tel);
		                orderform.setAddress(address);
		                orderform.setDate(date);
		                orderform.setIsdone(isdone);
		                orderform.setContact(con);
		                
		                orderformdao.add(orderform);
		                
		                RequestDispatcher dix=request.getRequestDispatcher("/ClientGoods.jsp");
						dix.forward(request, response);
					}
				}

	}

}

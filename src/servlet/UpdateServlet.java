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

import Bean.Client;
import Bean.Goods;
import Bean.Warehouse;
import DAO.ClientDAO;
import DAO.GoodsDAO;
import DAO.WarehouseDAO;

@WebServlet("/Update.do")
public class UpdateServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String select=request.getParameter("select");
		String option=request.getParameter("option");
		int id=Integer.parseInt(request.getParameter("id"));
		if("power".equals(select))
		{
			ClientDAO clientdao=new ClientDAO();
			Client client =new Client();
			
			if("客户".equals(option))
			{
				clientdao.powerupdate("管理员", id);
			}
			
			
			else{
				clientdao.powerupdate("客户", id);
			}
			
			
			
		}
		
		RequestDispatcher dis=request.getRequestDispatcher("/list.do?select=user");
		dis.forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		MD5 md=new MD5();
		String NPWD=md.start(request.getParameter("pwd"));
		String OPWD=md.start(request.getParameter("oldpwd"));
		
		HttpSession session = request.getSession();
		
		String select=request.getParameter("select");
		System.out.println("标记为"+select);
		
					if("goods".equals(select))
					{//Goods goodx =new Goods();
					Goods good =new Goods();
					GoodsDAO goodsdao=new GoodsDAO();
					
					//goodx= (Goods)request.getSession().getAttribute("good");//不通
					String id=request.getParameter("gid");
					//goodx=null;
					
					
					
					good.setId(id);
					good.setGno(request.getParameter("Gno"));		
					good.setName(request.getParameter("Name"));
					good.setNum(request.getParameter("Num"));
					good.setIprice(request.getParameter("Iprice"));			
					
					good.setOprice(request.getParameter("Oprice"));
					
					good.setWarehouse(request.getParameter("Warehouse"));
					good.setMax(request.getParameter("Max"));
					good.setMin(request.getParameter("Min"));
					good.setImg(request.getParameter("Img"));
					good.setRemark(request.getParameter("Remark"));
					good.setSpecs(request.getParameter("Specs"));
					good.setSort(request.getParameter("Sort"));
					
					
					goodsdao.update(good);
					good=null;																//需要取得所有商品信息
					good=goodsdao.get(id);
					
				
					session.setAttribute("good", good);
					
					RequestDispatcher dis=request.getRequestDispatcher("GoodsEdit.jsp");
					dis.forward(request, response);
					
					}
					
					if("client".equals(select)||"Cclient".equals(select))
					{
						
						System.out.println("标记为"+select);
						
						Client client=new Client();
						ClientDAO clientdao=new ClientDAO();
						int id=Integer.parseInt(request.getParameter("cid"));
								
						client.setId(id);
						client.setCno(Integer.parseInt(request.getParameter("Cno")));		
						client.setName(request.getParameter("Name"));
						client.setCon(request.getParameter("Con"));
						client.setAddress(request.getParameter("Address"));					
						client.setTel(request.getParameter("Tel"));
						client.setRemark(request.getParameter("Remark"));
						client.setSex(request.getParameter("Sex"));
						client.setPwd(request.getParameter("pwd"));
						client.setImg(request.getParameter("Img"));
						
						if(request.getParameter("pwd")!=null&&request.getParameter("pwd").equals("")==false)
				        {
				        	System.out.println("这是"+request.getParameter("pwd"));
				        	//String pwd=md.start(request.getParameter("pwd"));
				        	String pwd=request.getParameter("pwd");
				        	client.setPwd(NPWD);
				        	System.out.println("改密成功");
				        }
				        else
				        {String pwd=request.getParameter("oldpwd");
				        client.setPwd(pwd);     
				        System.out.println(OPWD);}
						
						
						clientdao.update(client);
						
						session.setAttribute("client", client);
						
						if("client".equals(select))
						{RequestDispatcher dix=request.getRequestDispatcher("/ClientEdit.jsp");
						dix.forward(request, response);
						}
						else{
							RequestDispatcher dix=request.getRequestDispatcher("/CEdit.jsp");
							dix.forward(request, response);
						}
				
						
					}
					
					
				if("warehouses".equals(select));
				{
					
					Warehouse warehouse=new Warehouse();
					WarehouseDAO warehousedao=new WarehouseDAO();
					String id=request.getParameter("wid");
					
					
					
				
					warehouse.setId(id);
					warehouse.setWno(request.getParameter("Wno"));		
					warehouse.setName(request.getParameter("Name"));
					warehouse.setAddress(request.getParameter("Address"));
					warehouse.setRemark(request.getParameter("Remark"));
					
					warehousedao.update(warehouse);
					
					session.setAttribute("warehouse", warehouse);
					
					RequestDispatcher dis=request.getRequestDispatcher("WarehouseEdit.jsp");
					dis.forward(request, response);
				
				}
				
				
				
			
				
		
	}

}

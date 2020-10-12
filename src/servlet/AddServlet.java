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

import Bean.Goods;
import Bean.Warehouse;
import DAO.GoodsDAO;
import DAO.WarehouseDAO;
@WebServlet("/Add.do")
public class AddServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String select=request.getParameter("select");
		System.out.println("添加select"+select);
		if("warehouse".equals(select))
		{
			Warehouse warehouse=new Warehouse();
			WarehouseDAO warehousedao=new WarehouseDAO();
			warehouse.setWno(request.getParameter("Wno"));
			warehouse.setName(request.getParameter("Name"));
			warehouse.setAddress(request.getParameter("Address"));
			warehouse.setRemark(request.getParameter("Remark"));
			
			warehousedao.add(warehouse);
			request.getRequestDispatcher("/AddWarehouse.jsp").forward(request, response);
			
		}
		
		if("good".equals(select))
		{
			WarehouseDAO warehousedao=new WarehouseDAO();
			
			List<Warehouse> warehouses = warehousedao.list(0, 7);
		      
			   
	        session.setAttribute("Awarehouses", warehouses);
	        request.getRequestDispatcher("/AddGoods.jsp").forward(request, response);
			
			
		}
		
		

	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String select=request.getParameter("select");
		
		if("good".equals(select))
		{System.out.println("添加sevlet");
		Goods good = new Goods();
		GoodsDAO gooddao = new GoodsDAO();
		
		good.setGno(request.getParameter("Gno"));
		good.setName(request.getParameter("Name"));
		good.setNum(request.getParameter("Num"));
		good.setIprice(request.getParameter("Iprice"));
		good.setOprice(request.getParameter("Oprice"));
		good.setWarehouse(request.getParameter("Warehouse"));
		good.setMax(request.getParameter("Max"));
		good.setMin(request.getParameter("Min"));
		good.setSort(request.getParameter("Sort"));
		good.setSpecs(request.getParameter("Specs"));
		good.setRemark(request.getParameter("remark"));
		//good.setImg(request.getParameter("Img"));
		
		gooddao.add(good);
		
		  request.getRequestDispatcher("/AddGoods.jsp").forward(request, response);
		}
		
		
		if("warehouse".equals(select))
		{
			Warehouse warehouse=new Warehouse();
			WarehouseDAO warehousedao=new WarehouseDAO();
			warehouse.setWno(request.getParameter("Wno"));
			warehouse.setName(request.getParameter("Name"));
			warehouse.setAddress(request.getParameter("Address"));
			warehouse.setRemark(request.getParameter("Remark"));
			
			warehousedao.add(warehouse);
			request.getRequestDispatcher("/AddWarehouse.jsp").forward(request, response);
			
		}
	
	}

}

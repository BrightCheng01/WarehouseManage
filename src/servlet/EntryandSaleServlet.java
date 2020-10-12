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

import util.Page;

import Bean.Goods;
import Bean.IRecord;
import Bean.Orderform;
import DAO.GoodsDAO;
import DAO.InputDAO;
import DAO.OrderformDAO;
import DAO.OutputDAO;
@WebServlet("/EntrySale.do")
public class EntryandSaleServlet extends HttpServlet {

	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int start = 0; // 获取分页参数
        int count = 7;

        try {
            start = Integer.parseInt(request.getParameter("page.start"));
          //  count = Integer.parseInt(req.getParameter("page.count"));
        } catch (Exception e) {
        }

        Page page = new Page(start, count);
		
		
		
		
		String select=request.getParameter("select");
		if("sale".equals(select))
		{
			
			   String operator=request.getParameter("operator");
			OutputDAO outputdao=new OutputDAO();
					
			
			String id=request.getParameter("id");
		
			OrderformDAO orderformdao=new OrderformDAO();
			Orderform orderform=new Orderform();		
			orderform=orderformdao.get(id);
			//orderformdao.isdone(orderform.getOrdercode());
			System.out.println("id"+id);
			outputdao.add(orderform,operator);
			
			new GoodsDAO().GoodsOutput(orderform.getGno(), orderform.getNum());
			
			orderformdao.isdone(orderform.getOrdercode());
			
			
			
			List<Orderform> orderforms = orderformdao.listisdone(page.getStart(), page.getCount());
	        int total = orderformdao.getisdoneTotal();
	        page.setTotal(total);
	        session.setAttribute("orderforms", orderforms);
	        session.setAttribute("page", page);
			
			
			
			 request.getRequestDispatcher("/AdminOutput.jsp").forward(request, response);
			
		}
		
		
		if("input".equals(select))
		{
		
			System.out.println("跳转了");
			
			 
		        String NUM=request.getParameter("Num");
		        String operator=request.getParameter("operator");
			
			//修改库存
			String gno="";
			GoodsDAO goodsdao=new GoodsDAO();
			
			
			
			gno=goodsdao.namegetgno(request.getParameter("selectgoods"));
			
			goodsdao.GoodsInput(gno, NUM, request.getParameter("Price"));
			
		
			//生成进货记录
			IRecord irecord =new IRecord();
			InputDAO inputdao=new InputDAO();
			
			//ircord.setIno(request.getParameter(""));
			irecord.setIname(request.getParameter("selectgoods"));
			irecord.setInum(request.getParameter("Num"));
			irecord.setIprice(request.getParameter("Price"));
			irecord.setOperator(operator);
			float iprice=Long.parseLong(request.getParameter("Price"));
			float totalprice=iprice*Integer.parseInt(request.getParameter("Num"));
			String totaliprice=Float.toString(totalprice);			
			irecord.setTotaliprice(totaliprice);
			irecord.setIaddress(request.getParameter("Address"));
			irecord.setIremark(request.getParameter("remark"));
			
			Date d = new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
			String now = df.format(d);		
			irecord.setIdate(now);
			System.out.println("date"+now);
			inputdao.add(irecord);
			System.out.println("跳转了2");
			  request.getRequestDispatcher("/AdminInput.jsp").forward(request, response);
			
			
			
		}
	
	}


	/*public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}*/

}

package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import service.OrderService;
import service.impl.OrderServiceImpl;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String type = request.getParameter("type");
		if("1".equals(type)) {//²éÑ¯¶©µ¥
			selectOrder(request, response);
		}else if("2".equals(type)) {//É¾³ý¶©µ¥
			deleteOrder(request, response);
		}else if("3".equals(type)) {//²éÑ¯¶©µ¥ÏêÇé
			selectOrderMore(request, response);
		}else if("4".equals(type)) {//²éÑ¯¶©µ¥ÏêÇé
			countOrderMore(request, response);
		}
	}

	private void countOrderMore(HttpServletRequest request, HttpServletResponse response) throws IOException {
		OrderService os = new OrderServiceImpl();
		PrintWriter out=response.getWriter();
		Long countUser = os.countOrder(null);
		out.print(countUser);
		out.flush();
		out.close();		
	}
	protected void selectOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderService os = new OrderServiceImpl();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		List<Map<String, Object>> list =os.getInformation(null, 0,1000);
		System.out.println(list);
		
		String json = JSON.toJSONStringWithDateFormat(list,"yyyy-MM-dd" );
		out.print(json);
		out.flush();
		out.close();
	}
	protected void deleteOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderService os = new OrderServiceImpl();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		int a = os.deleteOrder(Integer.parseInt(id));
		String json=null;
		if(a>0) {
			json=JSON.toJSONStringWithDateFormat("ok","yyyy-MM-dd" );
		}else {
			json = JSON.toJSONStringWithDateFormat(null,"yyyy-MM-dd" );
			
		}
		out.print(json);
		out.flush();
		out.close();
	}
	protected void selectOrderMore(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderService os = new OrderServiceImpl();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		List<Map<String, Object>> list =os.getordermore(Integer.parseInt(id));
		String json = JSON.toJSONStringWithDateFormat(list,"yyyy-MM-dd" );
		System.out.println(json);
		out.print(json);
		out.flush();
		out.close();
	}
	
}

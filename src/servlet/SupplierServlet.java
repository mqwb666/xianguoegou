package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import service.SupplierService;
import service.impl.SupplierServiceImpl;


@WebServlet("/supplierServlet")
public class SupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
			}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		String type = req.getParameter("type");
		switch(type) {
			case "selectLimitSupplier":try {
				selectLimitSupplier(req,resp);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}break;
			case "countSupplier":try {
				countSupplier(req,resp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}break;
			case "ischeck":ischeck(req,resp);break;
			case "deleteData":deleteData(req,resp);break;
			case "selectByID":selectByID(req,resp);break;
			case "countByLevel":countByLevel(req,resp);break;
			case "selectSupplierByLevel":selectSupplierByLevel(req,resp);break;
			
		}
		
		
	}
	
	public void selectSupplierByLevel(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		PrintWriter out=resp.getWriter();
		String level = req.getParameter("level");
		String ischeck = req.getParameter("ischeck");
		String page = req.getParameter("page");
		if(page==null) {
			page="1";
		}
		SupplierService Supplier = new SupplierServiceImpl();
		List<Map<String, Object>> Suppliers = Supplier.selectSupplierByLevel(Integer.parseInt(level),Integer.parseInt(ischeck), (Integer.parseInt(page)-1)*5, 5);
					
		String json = JSON.toJSONStringWithDateFormat(Suppliers, "yyyy-MM-dd");
		out.print(json);
		out.flush();
		out.close();
	}
	
	

	private void countByLevel(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out=resp.getWriter();
		SupplierService Supplier = new SupplierServiceImpl();
		String ischeck = req.getParameter("ischeck");
		List<Map<String, Object>> c = Supplier.countByLevel(Integer.parseInt(ischeck));
		Map<String, Object> map = new HashMap<String, Object>();
		
		for (int i = 0; i < c.size(); i++) {
			map.put("Level"+c.get(i).get("LEVEL"), c.get(i).get("COUNT(LEVEL)"));
			}
		String json = JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd");
		out.print(json);
		out.flush();
		out.close();					
	
	}

	private void selectByID(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out=resp.getWriter();
		String id = req.getParameter("id");
		SupplierService Supplier = new SupplierServiceImpl();
		Map<String, Object> Suppliers = Supplier.selectSupplierByID(Integer.parseInt(id));
		String json = JSON.toJSONStringWithDateFormat(Suppliers, "yyyy-MM-dd");
		out.print(json);
		out.flush();
		out.close();			
	}

	private void deleteData(HttpServletRequest req, HttpServletResponse resp) {
		SupplierService Supplier = new SupplierServiceImpl();
		String id = req.getParameter("id");
		Supplier.deleteData(Integer.parseInt(id));		
	}

	private void ischeck(HttpServletRequest req, HttpServletResponse resp) {
		SupplierService Supplier = new SupplierServiceImpl();
		String id = req.getParameter("id");
		Supplier.ischeck(Integer.parseInt(id));
			
	}

	private void countSupplier(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		PrintWriter out=resp.getWriter();
		SupplierService Supplier = new SupplierServiceImpl();
		String ischeck = req.getParameter("ischeck");
		Long countSupplier = Supplier.countSupplier(Integer.parseInt(ischeck));
		out.print(countSupplier);
		out.flush();
		out.close();
	}

	private void selectLimitSupplier(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		PrintWriter out=resp.getWriter();
		String page = req.getParameter("page");
		String num = req.getParameter("num");
		String ischeck = req.getParameter("ischeck");
		if(page==null) {
			page="1";
		}
		SupplierService Supplier = new SupplierServiceImpl();
		List<Map<String, Object>> list = Supplier.selectLimitSupplier(null,Integer.parseInt(ischeck), (Integer.parseInt(page)-1)*Integer.parseInt(num), Integer.parseInt(num));
				
		String json = JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd");
		out.print(json);
		out.flush();
		out.close();
	}

	
	


}

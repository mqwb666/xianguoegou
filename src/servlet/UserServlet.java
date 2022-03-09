package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import entity.User;
import service.UserService;
import service.impl.UserServiceImpl;


@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {
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
			case "selectLimitUser":try {
				selectLimitUser(req,resp);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}break;
			case "countUser":try {
				countUser(req,resp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}break;
			case "deleteUser":deleteUser(req,resp);break;
			case "deleteData":deleteData(req,resp);break;
			case "selectByID":selectByID(req,resp);break;
			case "countByLevel":countByLevel(req,resp);break;
			case "selectUserByLevel":selectUserByLevel(req,resp);break;
			
		}
		
		
	}
	
	public void selectUserByLevel(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		PrintWriter out=resp.getWriter();
		String level = req.getParameter("level");
		String page = req.getParameter("page");
		if(page==null) {
			page="1";
		}
		UserService user = new UserServiceImpl();
		List<Map<String, Object>> users = user.selectUserByLevel(Integer.parseInt(level), (Integer.parseInt(page)-1)*5, 5);
					
		String json = JSON.toJSONStringWithDateFormat(users, "yyyy-MM-dd");
		out.print(json);
		out.flush();
		out.close();
	}
	
	

	private void countByLevel(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out=resp.getWriter();
		UserService user = new UserServiceImpl();
		List<Map<String, Object>> c = user.countByLevel(null);
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
		UserService user = new UserServiceImpl();
		Map<String, Object> users = user.selectUserByID(Integer.parseInt(id));
		String json = JSON.toJSONStringWithDateFormat(users, "yyyy-MM-dd");
		out.print(json);
		out.flush();
		out.close();			
	}

	private void deleteData(HttpServletRequest req, HttpServletResponse resp) {
		UserService user = new UserServiceImpl();
		String id = req.getParameter("id");
		user.deleteData(Integer.parseInt(id));		
	}

	private void deleteUser(HttpServletRequest req, HttpServletResponse resp) {
		UserService user = new UserServiceImpl();
		String id = req.getParameter("id");
		String isdelete = req.getParameter("isdelete");
		user.deleteUser(Integer.parseInt(isdelete),Integer.parseInt(id));
			
	}

	private void countUser(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		PrintWriter out=resp.getWriter();
		UserService user = new UserServiceImpl();
		Long countUser = user.countUser(null);
		out.print(countUser);
		out.flush();
		out.close();
	}

	private void selectLimitUser(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		PrintWriter out=resp.getWriter();
		String page = req.getParameter("page");
		String num = req.getParameter("num");
		if(page==null) {
			page="1";
		}
		UserService user = new UserServiceImpl();
		List<Map<String, Object>> list = user.selectLimitUser(null, (Integer.parseInt(page)-1)*Integer.parseInt(num), Integer.parseInt(num));
				
		String json = JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd");
		out.print(json);
		out.flush();
		out.close();
	}

	
	


}

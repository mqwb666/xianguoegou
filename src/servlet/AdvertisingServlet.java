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
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import com.alibaba.fastjson.JSON;
import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;

import entity.Advertising;
import entity.DataGrideBean;
import service.AdvertisingService;
import service.UserService;
import service.impl.AdvertisingServiceImpl;
import service.impl.UserServiceImpl;

/**
 * Servlet implementation class AdvertisingServlet
 */
@WebServlet("/AdvertisingServlet")
public class AdvertisingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 更改编码格式
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 调用post
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 更改编码格式
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String type = request.getParameter("type");
		System.out.println("type====" + type);
		if ("1".equals(type)) {
			showAdvertising(request, response);
		}
		if ("2".equals(type)) {
			addAdvertising(request, response);
		}
		if ("3".equals(type)) {
			deleteAdvertising(request, response);
		}
		if ("4".equals(type)) {
			selectOneAdvertising(request, response);
		}
		if ("5".equals(type)) {
			updateAdvertising(request, response);
		}
		if ("6".equals(type)) {
			countAdvertising(request, response);
		}
	}

	private void countAdvertising(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out=response.getWriter();
		AdvertisingService adv = new AdvertisingServiceImpl();
		Long countUser = adv.countAdvertising(null);
		out.print(countUser);
		out.flush();
		out.close();		
	}


	// 更新
	private void updateAdvertising(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 取文本框的值；
		AdvertisingService ads = new AdvertisingServiceImpl();
		SmartUpload su = new SmartUpload();
		// SmartUpload里面包含了那些功能：
		// 把jsp的内置对象转化 可以在servlet中使用
		PageContext pc = JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true, 8192, true);
		// 初始化
		su.initialize(pc);
		File file = null;
		// 允许你上传图片的格式
		String allowed = "gif,jpg,png";
		// 不允许
		String denied = "exe,bat,html,jsp";
		// 上传图片的大小
		int file_size = 5 * 1024 * 1024;
		String filepath = null;
		try {
			// 定义允许上传文件类型
			su.setAllowedFilesList(allowed);
			// 不允许上传文件类型
			su.setDeniedFilesList(denied);
			// 单个文件最大限制
			su.setMaxFileSize(file_size);
			su.setCharset("utf-8");
			// 执行上传
			su.upload();
			// 得到单个上传文件的信息
			file = su.getFiles().getFile(0);
			if (!file.isMissing()) {
				// 设置文件在服务器的保存位置
				filepath = "img\\";
				filepath += file.getFileName();
				// 文件另存为
				file.setCharset("utf-8");
				// System.out.println(filepath);
				file.saveAs(filepath, SmartUpload.SAVE_VIRTUAL);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("update===" + filepath);
		Advertising adv = new Advertising();
		adv.setId(Integer.parseInt(su.getRequest().getParameter("id")));
		adv.setAdname(su.getRequest().getParameter("adname"));
		adv.setContent(su.getRequest().getParameter("content"));
		adv.setCreattime(null);
		adv.setIsmarket(Integer.parseInt(su.getRequest().getParameter("ismarket")));
		adv.setGid(Integer.parseInt(su.getRequest().getParameter("gid")));
		adv.setPic(filepath);
		System.out.println("update对象" + adv.getId() + "===" + adv.getAdname());
		int a = ads.updateAdvertising(adv);
		if (a > 0) {
			response.sendRedirect("advertising.html");
		}
	}

	// 查找单个
	private void selectOneAdvertising(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdvertisingService ads = new AdvertisingServiceImpl();
		Map<String, Object> map = ads.selectAdvertisingByID(Integer.parseInt(request.getParameter("id")));
		if (0 != map.size()) {
			request.setAttribute("map", map);
			request.getRequestDispatcher("advertisingUpdate.jsp").forward(request, response);
		}
	}

	// 删除
	private void deleteAdvertising(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdvertisingService ads = new AdvertisingServiceImpl();
		int a = ads.deleteAdvertising(Integer.parseInt(request.getParameter("id")));
		if (a > 0) {
			// System.out.println("删除成功");
			response.sendRedirect("advertising.html");
		}
	}

	// 添加
	private void addAdvertising(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 取文本框的值；
		AdvertisingService ads = new AdvertisingServiceImpl();
		SmartUpload su = new SmartUpload();
		// SmartUpload里面包含了那些功能：
		// 把jsp的内置对象转化 可以在servlet中使用
		PageContext pc = JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true, 8192, true);
		// 初始化
		su.initialize(pc);
		File file = null;
		// 允许你上传图片的格式
		String allowed = "gif,jpg,png";
		// 不允许
		String denied = "exe,bat,html,jsp";
		// 上传图片的大小
		int file_size = 5 * 1024 * 1024;
		String filepath = null;
		try {
			// 定义允许上传文件类型
			su.setAllowedFilesList(allowed);
			// 不允许上传文件类型
			su.setDeniedFilesList(denied);
			// 单个文件最大限制
			su.setMaxFileSize(file_size);
			su.setCharset("utf-8");
			// 执行上传
			su.upload();
			// 得到单个上传文件的信息
			file = su.getFiles().getFile(0);
			if (!file.isMissing()) {
				// 设置文件在服务器的保存位置
				filepath = "\\";
				filepath += file.getFileName();
				// 文件另存为
				file.setCharset("utf-8");
				// System.out.println(filepath);
				file.saveAs(filepath, SmartUpload.SAVE_VIRTUAL);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(filepath);
		Advertising adv = new Advertising();
		adv.setAdname(su.getRequest().getParameter("adname"));
		adv.setContent(su.getRequest().getParameter("content"));
		adv.setGid(Integer.parseInt(su.getRequest().getParameter("gid")));
		adv.setPic(filepath);
		adv.setCreattime(null);
		adv.setIsmarket(Integer.parseInt(su.getRequest().getParameter("ismarket")));
		int a = ads.addAdvertising(adv);
		if (a > 0) {
			// System.out.println("成功");
			response.sendRedirect("advertising.html");
		}

	}

	// 查询全部
	private void showAdvertising(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 从页面接收页数
		AdvertisingService ads = new AdvertisingServiceImpl();
		String start = request.getParameter("start");
		String page = request.getParameter("page");
		// 总条数
		Long count = ads.countAdvertising(null);
		// System.out.println(page + "====" + count);
		// 总条数转换为每页总页数
		int c = count.intValue();
		int sumpage = c % 5 > 0 ? c / 5 + 1 : c / 5;
		// System.out.println("c===" + c + "=====sumpage==" + sumpage);
		// 从servcie层接收数据
		List<Map<String, Object>> list = ads.selectLimitAdvertising(null, Integer.parseInt(start),
				Integer.parseInt(page));
		// System.out.println(list.size());
		DataGrideBean dgb = new DataGrideBean(Integer.parseInt(page), sumpage, count, list);
		PrintWriter out = response.getWriter();
		String json = JSON.toJSONStringWithDateFormat(dgb, "yyyy-MM-dd HH:mm:ss");
		System.out.println(json);
		out.print(json);
		out.flush();
		out.close();
	}

}

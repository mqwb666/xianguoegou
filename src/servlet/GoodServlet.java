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

import entity.DataGrideBean;
import entity.Good;
import service.GoodService;
import service.impl.GoodServiceImpl;

/**
 * Servlet implementation class ProductsServlet
 */
@WebServlet("/GoodServlet")
public class GoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		this.doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String type = request.getParameter("type");
		System.out.println("type====" + type);
		if ("1".equals(type)) {
			showGood(request, response);
		}
		if ("2".equals(type)) {
			addGood(request, response);
		}
		if ("3".equals(type)) {
			deleteGood(request, response);
		}
		if ("4".equals(type)) {
			selectOneGood(request, response);
		}
		if ("5".equals(type)) {
			updateOneGood(request, response);
		}
		if ("6".equals(type)) {
			showGoodNotFy(request, response);
		}
	}

	private void showGoodNotFy(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		GoodService gs = new GoodServiceImpl();
		List<Map<String, Object>> list = gs.selectAllGood(null);
		// System.out.println(list.size());
		PrintWriter out = response.getWriter();
		String json = JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd HH:mm:ss");
		System.out.println(json);
		out.print(json);
		out.flush();
		out.close();

	}

	private void updateOneGood(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 鍙栨枃鏈鐨勫�硷紱
		GoodService gs = new GoodServiceImpl();
		SmartUpload su = new SmartUpload();
		// SmartUpload閲岄潰鍖呭惈浜嗛偅浜涘姛鑳斤細
		// 鎶妀sp鐨勫唴缃璞¤浆鍖� 鍙互鍦╯ervlet涓娇鐢�
		PageContext pc = JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true, 8192, true);
		// 鍒濆鍖�
		su.initialize(pc);
		File file = null;
		// 鍏佽浣犱笂浼犲浘鐗囩殑鏍煎紡
		String allowed = "gif,jpg,png";
		// 涓嶅厑璁�
		String denied = "exe,bat,html,jsp";
		// 涓婁紶鍥剧墖鐨勫ぇ灏�
		int file_size = 5 * 1024 * 1024;
		String filepath = null;
		try {
			// 瀹氫箟鍏佽涓婁紶鏂囦欢绫诲瀷
			su.setAllowedFilesList(allowed);
			// 涓嶅厑璁镐笂浼犳枃浠剁被鍨�
			su.setDeniedFilesList(denied);
			// 鍗曚釜鏂囦欢鏈�澶ч檺鍒�
			su.setMaxFileSize(file_size);
			su.setCharset("utf-8");
			// 鎵ц涓婁紶
			su.upload();
			// 寰楀埌鍗曚釜涓婁紶鏂囦欢鐨勪俊鎭�
			file = su.getFiles().getFile(0);
			if (!file.isMissing()) {
				// 璁剧疆鏂囦欢鍦ㄦ湇鍔″櫒鐨勪繚瀛樹綅缃�
				filepath = "img\\";
				filepath += file.getFileName();
				// 鏂囦欢鍙﹀瓨涓�
				file.setCharset("utf-8");
				// System.out.println(filepath);
				file.saveAs(filepath, SmartUpload.SAVE_VIRTUAL);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(filepath);
		Good g = new Good();
		g.setId(Integer.parseInt(su.getRequest().getParameter("id")));
		g.setGid(Integer.parseInt(su.getRequest().getParameter("gtid")));
		g.setGname(su.getRequest().getParameter("gname"));
		g.setContent(su.getRequest().getParameter("content"));
		g.setNownumber(Integer.parseInt(su.getRequest().getParameter("nownumber")));
		g.setNumber(Integer.parseInt(su.getRequest().getParameter("number")));
		g.setLasttime(null);
		g.setSid(Integer.parseInt(su.getRequest().getParameter("sid")));
		g.setPrice(Double.parseDouble(su.getRequest().getParameter("price")));
		g.setPic(filepath);
		g.setIsmarket(Integer.parseInt(su.getRequest().getParameter("ismarket")));
		int a = gs.updateGood(g);
		// System.out.println(a);
		// System.out.println(g.getId() + "---" + g.getGname() + "---" + g.getGid() +
		// "---" + g.getSid());
		if (a > 0) {
			response.sendRedirect("Products_List.html");
		}
	}

	// 鏌ユ壘鍗曚釜
	private void selectOneGood(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		GoodService gs = new GoodServiceImpl();
		Map<String, Object> map = gs.selectGoodById(Integer.parseInt(request.getParameter("id")));
		if (0 != map.size()) {
			request.setAttribute("map", map);
			request.getRequestDispatcher("Products_List_update.jsp").forward(request, response);
		}
	}

	// 鍒犻櫎
	private void deleteGood(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		GoodService gs = new GoodServiceImpl();
		int a = gs.deleteGood(Integer.parseInt(request.getParameter("id")));
		if (a > 0) {
			System.out.println("good鍒犻櫎鎴愬姛");
			response.sendRedirect("Products_List.html");
		}
	}

	// 娣诲姞
	private void addGood(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 鍙栨枃鏈鐨勫�硷紱
		GoodService gs = new GoodServiceImpl();
		SmartUpload su = new SmartUpload();
		// SmartUpload閲岄潰鍖呭惈浜嗛偅浜涘姛鑳斤細
		// 鎶妀sp鐨勫唴缃璞¤浆鍖� 鍙互鍦╯ervlet涓娇鐢�
		PageContext pc = JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true, 8192, true);
		// 鍒濆鍖�
		su.initialize(pc);
		File file = null;
		// 鍏佽浣犱笂浼犲浘鐗囩殑鏍煎紡
		String allowed = "gif,jpg,png";
		// 涓嶅厑璁�
		String denied = "exe,bat,html,jsp";
		// 涓婁紶鍥剧墖鐨勫ぇ灏�
		int file_size = 5 * 1024 * 1024;
		String filepath = null;
		try {
			// 瀹氫箟鍏佽涓婁紶鏂囦欢绫诲瀷
			su.setAllowedFilesList(allowed);
			// 涓嶅厑璁镐笂浼犳枃浠剁被鍨�
			su.setDeniedFilesList(denied);
			// 鍗曚釜鏂囦欢鏈�澶ч檺鍒�
			su.setMaxFileSize(file_size);
			su.setCharset("utf-8");
			// 鎵ц涓婁紶
			su.upload();
			// 寰楀埌鍗曚釜涓婁紶鏂囦欢鐨勪俊鎭�
			file = su.getFiles().getFile(0);
			if (!file.isMissing()) {
				// 璁剧疆鏂囦欢鍦ㄦ湇鍔″櫒鐨勪繚瀛樹綅缃�
				filepath = "";
				filepath += file.getFileName();
				// 鏂囦欢鍙﹀瓨涓�
				file.setCharset("utf-8");
				// System.out.println(filepath);
				file.saveAs(filepath, SmartUpload.SAVE_VIRTUAL);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(filepath);
		Good g = new Good();
		g.setGid(Integer.parseInt(su.getRequest().getParameter("gtid")));
		g.setGname(su.getRequest().getParameter("gname"));
		g.setContent(su.getRequest().getParameter("content"));
		g.setNownumber(Integer.parseInt(su.getRequest().getParameter("nownumber")));
		g.setNumber(Integer.parseInt(su.getRequest().getParameter("number")));
		g.setLasttime(null);
		g.setSid(Integer.parseInt(su.getRequest().getParameter("sid")));
		g.setPrice(Double.parseDouble(su.getRequest().getParameter("price")));
		g.setPic(filepath);
		g.setIsmarket(Integer.parseInt(su.getRequest().getParameter("ismarket")));
		// System.out.println(g.getGname() + "---" + g.getGid() + "---" + g.getSid());
		int a = gs.addGood(g);
		if (a > 0) {
			System.out.println("good娣诲姞鎴愬姛");
			response.sendRedirect("Products_List.html");
		}
	}

	private void showGood(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		GoodService gs = new GoodServiceImpl();
		String start = request.getParameter("start");
		String page = request.getParameter("page");
		System.out.println("page===" + page);
		System.out.println("start===" + start);
		Long count = gs.countGood(null);
		int c = count.intValue();
		int sumpage = c % 5 > 0 ? c / 5 + 1 : c / 5;
		List<Map<String, Object>> list = gs.selectLimitGood(null, Integer.parseInt(start), Integer.parseInt(page));
		DataGrideBean dgb = new DataGrideBean(Integer.parseInt(page), sumpage, count, list);
		PrintWriter out = response.getWriter();
		String json = JSON.toJSONStringWithDateFormat(dgb, "yyyy-MM-dd HH:mm:ss");
		System.out.println(json);
		out.print(json);
		out.flush();
		out.close();
	}

}

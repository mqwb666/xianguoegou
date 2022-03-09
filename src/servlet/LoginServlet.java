package servlet;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;


import service.UserService;
import service.impl.UserServiceImpl;
import utils.RandomNumUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		if("1".equals(type)) {//������֤��
			InitRandom(request, response);
		}else if("2".equals(type)) {
			Login(request, response);
		}else if("3".equals(type)) {
			UnLogin(request, response);
		}
	}
	private void UnLogin(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().removeAttribute("user");
		
	}

	//������֤��
	protected void InitRandom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		//	PrintWriter out = response.getWriter();
			
			RandomNumUtil rdnu=RandomNumUtil.Instance(); 
			//this.setInputStream(rdnu.getImage());
			//������֤�� ��  ���ұ���
			request.getSession().setAttribute("random", rdnu.getStr());
			//return "success";
			BufferedInputStream bis = null;
			OutputStream os = null;
		        bis = new BufferedInputStream(rdnu.getImage());  
		                byte[] buffer = new byte[512];  
		                response.setCharacterEncoding("UTF-8");  
		                        //��ͬ���͵��ļ���Ӧ��ͬ��MIME����  
		                response.setContentType("image/*");  
		                        //�ļ������ķ�ʽ���͵��ͻ��������
		                response.setContentLength(bis.available());  
		                  
		                os = response.getOutputStream();  
		                int n;  
		                while ((n = bis.read(buffer)) != -1) {  
		                  os.write(buffer, 0, n);  
		                }  
		                bis.close();  
		                os.flush();  
		                os.close();
			
			//out.flush();
			//out.close();
	}
	protected void Login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserService us = new UserServiceImpl();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		String rand = request.getParameter("rand");
		String arandom=(String)(request.getSession().getAttribute("random"));
		String json ;
		if(arandom.equalsIgnoreCase(rand)){//���Դ�Сд
			Map<String,Object> m = us.login(uname, pwd);
			if(m!=null) {
				System.out.println("��¼�ɹ�");
		        HttpSession session = request.getSession();
	            session.setAttribute("user",m);
				json = JSON.toJSONStringWithDateFormat(1,"yyyy-MM-dd");
				System.out.println(json);
			}else {
				System.out.println("���룬�û�������");
				json=JSON.toJSONStringWithDateFormat("������û�������","yyyy-MM-dd");
			}
		}else{//��֤�벻��ȷ
			System.out.println("��֤�����");
			json=JSON.toJSONStringWithDateFormat("��֤�����","yyyy-MM-dd");
		}
		   
		out.print(json);
		
		out.flush();
		out.close();
		
	}
}

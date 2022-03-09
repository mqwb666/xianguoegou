package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String uri = request.getRequestURI();

        if(uri.contains("/login.html") || uri.contains("/assets/") || uri.contains("/css/") || uri.contains("/font/") || uri.contains("/images/") || uri.contains("/js/") || uri.contains("/products/") || uri.contains("/LoginServlet")){
            filterChain.doFilter(servletRequest,servletResponse);
        }
        else{
            Object user = request.getSession().getAttribute("user");
            if(user!=null){
                filterChain.doFilter(servletRequest,servletResponse);
            }
            else {
                request.setAttribute("login_msg","ÄúÉÐÎ´µÇÂ¼£¬ÇëÏÈµÇÂ¼");
                servletRequest.getRequestDispatcher("/login.html").forward(request, response);
            }
        }
    }

    @Override
    public void destroy() {

    }
}

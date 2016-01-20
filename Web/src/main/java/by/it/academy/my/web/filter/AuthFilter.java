package by.it.academy.my.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.it.academy.my.model.entity.application.User;

/**
 * Servlet Filter implementation class AuthFilter
 */
public final class AuthFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		User user = (User) req.getSession().getAttribute("user");
		
		if (user != null && !"loginForm".equals(req.getParameter("command"))) {
			
			chain.doFilter(req, response);
			
		} else if (user != null && "loginForm".equals(req.getParameter("command"))) {
			
			request.getRequestDispatcher("?command=default").forward(req, response);
			
			//chain.doFilter(req, response);
			
		} else {
			
			HttpServletResponse res = (HttpServletResponse) response;
			
			res.sendRedirect("?command=loginForm");
		}
		
		/*
		if (user != null && !"loginForm".equals(req.getParameter("command"))) {
			
			chain.doFilter(req, response);
			
		} else if (null == req.getParameter("command")) {
			
			HttpServletResponse res = (HttpServletResponse) response;
			
			res.sendRedirect("?command=loginForm");
			
			// This code will execute after redirecting!...
			
			//request.getRequestDispatcher("/pages/?command=loginForm").forward(request, response);
			
		} else {
			
			chain.doFilter(req, response);
		}
		*/
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

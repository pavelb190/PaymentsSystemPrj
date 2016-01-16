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

		System.out.println("In AuthFilter!..");
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		User user = (User) req.getSession().getAttribute("user");
		
		System.out.println("User is : " + user);
		
		System.out.println("Controller is : " + req.getParameter("controller"));
		System.out.println("Action is : " + req.getParameter("action"));
		
		if (user != null) {
			
			chain.doFilter(request, response);
			
		} else {
			
			//if (!"login".equals(req.getParameter("controller")) || ("login".equals(req.getParameter("controller")) && req.getParameter("action") == null))
			
			HttpServletResponse res = (HttpServletResponse) response;
			
			res.sendRedirect("?controller=login&action=form");
			
			// ...
			
			//request.getRequestDispatcher("/pages/?controller=login&action=form").forward(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

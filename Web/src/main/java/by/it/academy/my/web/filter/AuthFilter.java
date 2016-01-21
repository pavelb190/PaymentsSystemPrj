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
		
		// Make a HttpServletRequest from incoming request ...
		HttpServletRequest req = (HttpServletRequest) request;
		
		/**
		 * User is considered as logged in
		 * 	if his bean with label "user" is presented and stored in HttpSession.
		 */
		
		// Get a User-bean from session by its id-label ...
		User user = (User) req.getSession().getAttribute("user");
		
		// If User is already logged in ...
		// ... & incoming request doesn't represent the command "loginForm" (which means 'show LoginForm')...
		if (user != null && !"loginForm".equals(req.getParameter("command"))) {
			
			// ... continue the workflow. 
			chain.doFilter(req, response);
			
		} else
			
			// If User is already logged in ...
			// ... & incoming request represents the command "loginForm" (*)...
			if (user != null && "loginForm".equals(req.getParameter("command"))) {
				
				/* Make redirect to the default action ... ;) */
				
				HttpServletResponse res = (HttpServletResponse) response;
				
				res.sendRedirect("?command=default");
				
				//request.getRequestDispatcher("?command=default").forward(req, response);
			
		} else
			
			// If User is not logged in yet ...
			// ... & incoming request doesn't represent any command of "login" (it's a Login-process action) || "loginForm" (*) ...
			if (user == null && !"login".equals(req.getParameter("command")) && !"loginForm".equals(req.getParameter("command"))) {
				
				/* Make redirect to the LoginForm (via a LoginFormAction). */
				
				HttpServletResponse res = (HttpServletResponse) response;
				
				res.sendRedirect("?command=loginForm");
			
		} else {
			
			// Else, do everything else.
			chain.doFilter(req, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

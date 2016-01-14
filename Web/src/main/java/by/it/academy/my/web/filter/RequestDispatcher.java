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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Servlet Filter implementation class Dispatcher
 */
public final class RequestDispatcher implements Filter {
	
	private static final Logger log = LogManager.getLogger(RequestDispatcher.class);
	
    /**
     * Default constructor. 
     */
    public RequestDispatcher() {
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
		
		System.out.println("In RequestDispatcher-filter!...");
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		log.debug("URL : " + req.getRequestURL());
		
		String path = req.getRequestURI().substring(req.getContextPath().length());
		
		log.debug("Path : " + path);
		
		if (path.startsWith("/assets") || path.startsWith("/pages")) {
			
			chain.doFilter(request, response);
			
		} else {
			
			HttpServletResponse res = (HttpServletResponse) response;
			
			res.sendRedirect("pages" + path);
			
			//request.getRequestDispatcher("/pages" + path).forward(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

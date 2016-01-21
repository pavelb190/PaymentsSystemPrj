package by.it.academy.my.web.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class DefaultCommand
 */
public final class DefaultCommand implements Filter {

    /**
     * Default constructor. 
     */
    public DefaultCommand() {
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
		
		// Take the initial path ...
		String path = req.getRequestURI().substring(req.getContextPath().length());
		
		// then take the command-param from query-string ...
		final String commandIs = req.getParameter("command");
		
		// Check if we're in the directory driven by FrontController & command-param was 'null' ...
		if (path.startsWith("/pages") && commandIs == null) {
			
			// Some initials ...
			StringBuffer reqUri = new StringBuffer();
			
			// add the default command as url-param ...
			reqUri.append("?command=default");
			
			// then add the rest of query-string ... 
			final String queryStr = req.getQueryString();
			
			// Check if it wasn't empty ...
			if (queryStr != null) {
				
				reqUri.append("&" + queryStr);
			}
			
			// ... and then Make redirect to the resulting path way ;)
			
			HttpServletResponse res = (HttpServletResponse) response;
			
			res.sendRedirect(reqUri.toString());
			
		} else {
			
			// If command-param is presented in incoming request,
				// ... do anything else.
			
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

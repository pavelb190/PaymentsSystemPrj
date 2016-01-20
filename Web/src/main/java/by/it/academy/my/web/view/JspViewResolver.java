package by.it.academy.my.web.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JspViewResolver implements ViewResolver {

	private HttpServletRequest request;
	
	private String forView;
	
	private HttpServletResponse response;
	
	public JspViewResolver(HttpServletRequest req, final String forView, HttpServletResponse res) {
		
		this.request = req;
		
		this.forView = forView;
		
		this.response = res;
	}
	
	@Override
	public void render() {
		
		try {
			
			this.request
				.getRequestDispatcher("/WEB-INF/views/" + this.forView + ".jsp")
					.include(this.request, this.response);
			
		} catch (ServletException | IOException e) {

			e.printStackTrace();
			
			// ...
		}
	}

}
package by.it.academy.my.web.servlet.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.it.academy.my.domain.mysql.service.application.UserService;
import by.it.academy.my.domain.service.exception.ServiceException;
import by.it.academy.my.model.entity.application.User;

/**
 * Servlet implementation class MyTestServlet
 */
public class MyTestServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	UserService userService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyTestServlet() {
    	
        super();
        
        try {
        	
			this.userService = new UserService();
			
		} catch (ServiceException e) {
			
			e.printStackTrace();
			
			// ...
			
			return ;
		}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user = null;
		
		try {
			
			user = this.userService.getUserById(2);
			
		} catch (ServiceException e) {
			
			e.printStackTrace();
			
			// ...
			
			return ;
		}
		
		response.getWriter().println("User: " + user);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

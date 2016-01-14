package by.it.academy.my.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.it.academy.my.web.action.request.handler.application.ApplicationRequestHandler;

/**
 * Servlet implementation class FrontController
 */
public class FrontController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static final Logger log = LogManager.getLogger(FrontController.class);
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
    	
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		log.debug("[On Controller's Service-method!..");
		
		new ApplicationRequestHandler(request, response).perform();
	}
	
}

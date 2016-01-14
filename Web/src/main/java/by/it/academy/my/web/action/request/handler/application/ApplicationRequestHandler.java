package by.it.academy.my.web.action.request.handler.application;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.it.academy.my.web.action.WebAction;
import by.it.academy.my.web.action.application.ApplicationActions;
import by.it.academy.my.web.action.exception.ActionIsNotExistsException;
import by.it.academy.my.web.action.request.handler.RequestHandler;

public class ApplicationRequestHandler implements RequestHandler {
	
	private static final String QUERY_CONTROLLER_ID = "controller";
	private static final String QUERY_ACTION_ID = "action";
	
	private static final Logger log = LogManager.getLogger(ApplicationRequestHandler.class);
	
	private HttpServletRequest request;
	
	private String forController;
	private String doAction;
	
	private WebAction action = null;
	
	protected String requestUri;
	
	private HttpServletResponse response;
	
	public ApplicationRequestHandler(HttpServletRequest req, HttpServletResponse res) {
		
		this.request = req;
		
		this.forController = req.getParameter(QUERY_CONTROLLER_ID);
		this.doAction = req.getParameter(QUERY_ACTION_ID);
		
		this.requestUri = buildRequestUri(this.forController, this.doAction);
		
		log.debug("Request URI : " + this.requestUri);
		
		System.out.println("Request URI : " + this.requestUri);
		
		for(ApplicationActions currAction : ApplicationActions.values()) {
			
			if (currAction.getUri().equals(requestUri) && currAction.getRequestType().name().equals(req.getMethod())) {
				
				action = currAction.getCurrentAction();
			}
		}
		
		if (action != null) {
			
			// set input params ...
		}
		
		this.response = res;
	}
	
	private static String buildRequestUri(String forController, String doAction) {
		
		return forController != null ? (forController + (doAction != null ? "/" + doAction : "")) : "";
	}
	
	public void perform() { 
		
		try {
			
			if (action != null) {
				
				action.execute();
				
				final String viewIs = action.getActionView();
				
				log.debug("View is : " + viewIs);
				
				setSessionParams(this.request, action.getSessionParams());
				
				// ... Render the appropriate View ...
				
				this.request.setAttribute("viewModel", action.getViewParams());
				
				this.request
					.getRequestDispatcher("/WEB-INF/views/" + viewIs + ".jsp")
						.forward(this.request, this.response);
				
			} else {
				
				throw new ActionIsNotExistsException();
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			{
				this.request.setAttribute("messageInfo", e.getMessage());
				//this.request.setAttribute("fromUrl", "/");
			}
			
			log.debug("URL : " + this.request.getRequestURL());
			
			try {
				
				this.request
					.getRequestDispatcher("/WEB-INF/views/" + "error.jsp")
						.forward(this.request, this.response);
				
			} catch (ServletException e1) {
				
				e1.printStackTrace();
				
				// ...
				
			} catch (IOException e1) {
				
				e1.printStackTrace();
				
				// ...
			}
		}
	}
	
	private void setSessionParams(HttpServletRequest req, Map<String, Object> sessionParams) {
		
		for(Map.Entry<String, Object> sessionParam : sessionParams.entrySet()) {
			
			req.getSession().setAttribute(sessionParam.getKey(), sessionParam.getValue());
		}
	}
}

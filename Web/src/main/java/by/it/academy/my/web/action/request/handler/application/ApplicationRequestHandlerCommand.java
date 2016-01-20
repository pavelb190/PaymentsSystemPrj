package by.it.academy.my.web.action.request.handler.application;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.it.academy.my.web.action.WebAction;
import by.it.academy.my.web.action.WebActionResolver;
import by.it.academy.my.web.action.application.ApplicationActionsFactory;
import by.it.academy.my.web.action.application.HttpRequestActionResolver;
import by.it.academy.my.web.action.exception.ActionIsNotExistsException;
import by.it.academy.my.web.action.request.RequestTypes;
import by.it.academy.my.web.action.request.handler.RequestHandler;
import by.it.academy.my.web.action.request.params.RequestParamsWrapper;
import by.it.academy.my.web.action.request.params.http.HttpRequestParamsResolver;
import by.it.academy.my.web.view.JspViewResolver;
import by.it.academy.my.web.view.ViewResolver;

public class ApplicationRequestHandlerCommand implements RequestHandler {

	private HttpServletRequest request;
	
	private WebAction action = null;
	
	private RequestParamsWrapper<String> requestParams;
	
	private WebActionResolver actionResolver;
	
	private ViewResolver viewResolver;
	
	private HttpServletResponse response;
	
	public ApplicationRequestHandlerCommand(HttpServletRequest req, HttpServletResponse res) {
		
		this.request = req;
		
		this.actionResolver = HttpRequestActionResolver.getInstance();
		
		this.action = this.actionResolver.resolve(req);
		
		this.requestParams = new HttpRequestParamsResolver(req).resolve();
		
		this.action.getActionParams().putAll(this.requestParams.getInputParams());
		
		this.response = res;
	}
	
	@Override
	public void perform() {
		
		try {
			
			if (this.action != null) {
				
				this.action.execute();
				
				final String viewIs = this.action.getActionView();
				
				setSessionParams(this.request, this.action.getSessionParams());
				
				// ... Render the appropriate View ...
				
				this.request.setAttribute("viewModel", this.action.getViewParams());
				
				this.viewResolver = new JspViewResolver(this.request, viewIs, this.response);
				
				this.viewResolver.render();
				
			} else {
				
				throw new ActionIsNotExistsException();
			}
			
		} catch (Throwable e) {
			
			e.printStackTrace();
			
			// ...
			
			{
				this.request.setAttribute("messageInfo", e.getMessage());
				//this.request.setAttribute("fromUrl", "/");
			}
			
			this.viewResolver = new JspViewResolver(this.request, "error", this.response);
			
			this.viewResolver.render();
		}
	}
	
	private void setSessionParams(HttpServletRequest req, Map<String, Object> sessionParams) {
		
		for(Map.Entry<String, Object> sessionParam : sessionParams.entrySet()) {
			
			req.getSession().setAttribute(sessionParam.getKey(), sessionParam.getValue());
		}
	}
	
}

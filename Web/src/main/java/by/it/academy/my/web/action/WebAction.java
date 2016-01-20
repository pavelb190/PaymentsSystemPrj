package by.it.academy.my.web.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.it.academy.my.web.action.command.Command;
import by.it.academy.my.web.action.exception.ActionException;


public abstract class WebAction implements Command {
	
	protected static final Logger log = LogManager.getLogger(WebAction.class);
	
	private String actionView;
	
	private HashMap<String, Object> actionParams = new HashMap<String, Object>();
	
	private HashMap<String, Object> sessionParams = new HashMap<String, Object>();
	
	private HashMap<String, Object> viewParams = new HashMap<String, Object>();
	
	public WebAction() {
		
		// ...
	}
	
	public WebAction(Map<String, Object> withParams) {
		
		setActionParams(withParams);
	}
	
	public void execute() throws Exception {
		
		this.actionView = doAction();
	}
	
	protected abstract String doAction() throws ActionException;
	
	public void setActionParams(Map<String, Object> actionParams) {
		
		this.actionParams = (HashMap<String, Object>) actionParams;
	}
	
	public void setViewParams(Map<String, Object> viewParams) {
		
		this.viewParams = (HashMap<String, Object>) viewParams;
	}
	
	public Map<String, Object> getActionParams() {
		
		return this.actionParams;
	}
	
	public void setSessionParams(Map<String, Object> sessionParams) {
		
		this.sessionParams = (HashMap<String, Object>) sessionParams;
	}
	
	public Map<String, Object> getSessionParams() {
		
		return this.sessionParams;
	}
	
	public Map<String, Object> getViewParams() {
		
		return this.viewParams;
	}
	
	public Object getActionParam(String name) {
		
		return this.actionParams.get(name);
	}
	
	public String getActionView() {
		
		return this.actionView;
	}
}

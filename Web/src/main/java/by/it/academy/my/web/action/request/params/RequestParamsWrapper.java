package by.it.academy.my.web.action.request.params;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class RequestParamsWrapper<T extends Serializable> {
	
	private Map<String, T> inputParams = new HashMap<>();
	
	public RequestParamsWrapper() {
		
		// ...
	}
	
	public RequestParamsWrapper(Map<String, T> inputParams) {
		
		this.inputParams = inputParams;
	}
	
	public void setInputParams(Map<String, T> inputParams) {
		
		this.inputParams = inputParams;
	}
	
	public void setInputParam(final String name, T param) {
		
		this.inputParams.put(name, param);
	}
	
	public Map<String, T> getInputParams() {
		
		return this.inputParams;
	}
	
	public T getInputParam(final String name) {
		
		return this.inputParams.get(name);
	}
}

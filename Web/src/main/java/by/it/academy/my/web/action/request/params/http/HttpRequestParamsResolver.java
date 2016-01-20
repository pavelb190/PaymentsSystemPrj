package by.it.academy.my.web.action.request.params.http;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import by.it.academy.my.web.action.request.params.RequestParamsResolver;
import by.it.academy.my.web.action.request.params.RequestParamsWrapper;

public class HttpRequestParamsResolver extends RequestParamsResolver {
	
	private HttpServletRequest request;
	
	public HttpRequestParamsResolver(HttpServletRequest req) {
		
		this.request = req;
	}
	
	@Override
	public RequestParamsWrapper<String> resolve() {
		
		Map<String, String> inputParams = new HashMap<>();
		
		Map<String, String[]> parameterMap = this.request.getParameterMap();
		
		for(Map.Entry<String, String[]> param : parameterMap.entrySet()) {
			
			inputParams.put(param.getKey(), param.getValue()[0]);
		}
		
		return new RequestParamsWrapper<String>(inputParams);
	}

}

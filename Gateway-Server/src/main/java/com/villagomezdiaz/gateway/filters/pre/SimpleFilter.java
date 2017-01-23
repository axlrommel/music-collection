package com.villagomezdiaz.gateway.filters.pre;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class SimpleFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(SimpleFilter.class);
	
	@Override
	public boolean shouldFilter() {

		return true; //always executed
	}

	@Override
	public Object run() {
		
		//filter functionality
		RequestContext ctx = RequestContext.getCurrentContext();
	    HttpServletRequest request = ctx.getRequest();

	    log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));

		return null;
	}

	@Override
	public String filterType() {

		return "pre"; //it could be "route" for a routing filter
	}

	@Override
	public int filterOrder() {

		return 1; //the order in which it's executed relative to other filters
	}

}

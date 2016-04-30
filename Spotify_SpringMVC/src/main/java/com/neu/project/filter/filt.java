package com.neu.project.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class filt
 */
public class filt implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

	    

		
		HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;
        
        String e = request.getParameter("pagedata");
    
        if(e !=null)
        {
        	HttpSession session = req.getSession();

            if(e.equals("songperpage"))
            {
            	String name = request.getParameter("query");
            	String result = name.replaceAll("[\\-\\+\\.\\^:,]<>","");
            	session.setAttribute("sname", result);
            	session.setAttribute("numofchild", name);
            }
            
            
            
        }
        
		chain.doFilter(request, response);
	}


	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	
	public void destroy() {
		// TODO Auto-generated method stub
	}


}

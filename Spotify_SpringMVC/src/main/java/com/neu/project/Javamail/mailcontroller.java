package com.neu.project.Javamail;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mailsend")
public class mailcontroller {

	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody void Submit(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {

		String to = request.getParameter("to");
		String subject = request.getParameter("subject");
		String mailbody = request.getParameter("mailbody");
				
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
	    	 
		try{
	    	mail mm = (mail) context.getBean("mail");
	        mm.sendMail(to,subject,mailbody);
	        
	 	        PrintWriter out=response.getWriter();
		        out.print("");
		        out.flush();
		}
		catch(Exception e){}
		PrintWriter out=response.getWriter();
        out.print("");
        out.flush();
		
	}
	
	
	
}

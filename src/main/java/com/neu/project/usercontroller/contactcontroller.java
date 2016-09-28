package com.neu.project.usercontroller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neu.project.pojo.User;

@Controller
@RequestMapping("/contact")
public class contactcontroller {

	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("user") User user,BindingResult result,Model model,HttpServletRequest request) {
		
		if(request.getSession().getAttribute("loginUser")==null)
		{
	    	return "redirect:/";
		}
		
		return "contact";
	}

}

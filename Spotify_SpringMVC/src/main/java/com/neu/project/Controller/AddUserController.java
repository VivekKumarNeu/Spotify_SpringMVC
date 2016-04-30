package com.neu.project.Controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.project.DAO.UserDAO;
import com.neu.project.myexception.AdException;
import com.neu.project.pojo.Person;
import com.neu.project.pojo.User;

@Controller
@RequestMapping("/adduser")
public class AddUserController {
	@Autowired
	@Qualifier("userValidator")
	UserValidator validator;

	@Autowired
	@Qualifier("UserDAO")
	UserDAO userDao;
	
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@RequestMapping(method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("user") User user, BindingResult result,Model model,HttpServletRequest request) throws Exception {
		validator.validate(user, result);
		if (result.hasErrors()) {
			return "login";
		}
		boolean flag=true;
		try {
			HttpSession session = request.getSession();
			//UserDAO userDao = new UserDAO();
			boolean isuseralreadyindb = userDao.alreadyExists(user.getUserName());
			if(!isuseralreadyindb){
			User checkuser = userDao.create(user.getUserName(), user.getPassword(), user.getEmail(), user.getFirstName(), user.getLastName(), user.getAge(),user.getRole());
			flag = false;
			if(checkuser != null)
				model.addAttribute("QQ", "Added");
			}
			if(flag)
			model.addAttribute("isuserthere", "yes");
			// DAO.close();
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}
		
		return "login";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("user") User user, BindingResult result,Model model, HttpServletRequest request) {
		
		if(request.getSession().getAttribute("loginUser")==null)
		{
	    	return "redirect:/";
		}
		
		return "login";
	}


}
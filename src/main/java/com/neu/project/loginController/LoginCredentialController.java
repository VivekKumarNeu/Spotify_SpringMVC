package com.neu.project.loginController;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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

import com.neu.project.DAO.PlaylistDAO;
import com.neu.project.DAO.UserDAO;
import com.neu.project.pojo.PlayList;
import com.neu.project.pojo.User;

@Controller
@RequestMapping("/verifyuser")
public class LoginCredentialController {

//	@Autowired
//	@Qualifier("loginValidator")
//	LoginValidator loginValidator;
	
	@Autowired
	@Qualifier("UserDAO")
	UserDAO userdao;
	
	@Autowired
	@Qualifier("PlaylistDAO")
	PlaylistDAO playlistdao;
	
//	@InitBinder
//	private void initBinder(WebDataBinder binder)
//	{
//		binder.setValidator(loginValidator);
//	}
	
	
	
	@RequestMapping(method = RequestMethod.POST)
	public String doSubmitAction(@ModelAttribute("user") User user, BindingResult result,Model model,HttpServletRequest request) throws Exception {
//		loginValidator.validate(user, result);
//		if (result.hasErrors()) {
//			return "login";
//		}
		
		HttpSession session = request.getSession();
		
		user = userdao.get(user.getUserName(), user.getPassword());
		if(user != null){
		if(user.getRole().equals("Admin"))
		{
			
			session.setAttribute("loginUser", user);
			model.addAttribute("userbean", user);
			model.addAttribute("userage",  user.getAge());
			
			List<User> userL = null;
			List<PlayList> playL = null;
			userL = userdao.getallusers();
			playL =  playlistdao.getallplaylists();
			
			session.setAttribute("allusershere", userL);
			session.setAttribute("allplaylistshere", playL);
			
			
			
			return "redirect:/adminarea";
		}
		else
		{
			session.setAttribute("loginUser", user);
			session.setAttribute("countofsongs", 3);
			session.setAttribute("statofuser", user.getStatus());
			
			model.addAttribute("userbean", user);
			
			User user1 = (User) session.getAttribute("loginUser");
			long userID = user1.getPersonID();
			
			List<PlayList> platL = playlistdao.getcurrentuserplaylist(userID);
			
			session.setAttribute("localplaylistval", platL);
			
			return "redirect:/mainframe";
		}
		} else
		{
			session.setAttribute("loginUser", "Invaliduser");
			return "redirect:/";
		}
		
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest request) {
		
			
		HttpSession session = request.getSession();
		session.invalidate();
		return "login";
	}
	}
	
	
	

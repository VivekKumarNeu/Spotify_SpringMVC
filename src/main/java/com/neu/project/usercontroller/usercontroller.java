package com.neu.project.usercontroller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.neu.project.DAO.PlaylistDAO;
import com.neu.project.DAO.TracksDAO;
import com.neu.project.DAO.UserDAO;
import com.neu.project.pojo.PlayList;
import com.neu.project.pojo.Track;
import com.neu.project.pojo.User;

@Controller
@RequestMapping("/usercontoller")
public class usercontroller {

	@Autowired
	@Qualifier("PlaylistDAO")
	PlaylistDAO playlistdao;
	
	@Autowired
	@Qualifier("TracksDAO")
	TracksDAO tr;
	
	@Autowired
	@Qualifier("UserDAO")
	UserDAO userdao;
	static int c =3;
	static int de =0;
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody void Submit(HttpServletRequest request, HttpServletResponse response, Model model) {
		
//		HttpSession session = request.getSession();
//		User user = (User) session.getAttribute("loginUser");
//		long userID = user.getPersonID();
//		
//		//get all the albums of user
//		PlaylistDAO playlistdao = new PlaylistDAO();
//		List<PlayList> platL = playlistdao.getcurrentuserplaylist(userID);
//		session.setAttribute("localplaylistval", platL);
//		//get tracks of playlist 
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/allsongs")
	public @ResponseBody void Submitdo(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("loginUser");
		String count = request.getParameter("hiddensong");
		String bysend = request.getParameter("newlistsize");
		int cc = Integer.parseInt(bysend); 
		Set<Track> pagination= new HashSet<Track>();
		List<PlayList> platL = playlistdao.getcurrentuserplaylist(user.getPersonID());
		
		//TracksDAO tr = new TracksDAO();
		Set<Track> allthesongs = tr.getallalbums(platL);
		int i=0;
		for(Track s : allthesongs){
			{
				if(i < de)
					pagination.add(s);
			
			}
			i++;
		}
		for(Track qq : pagination)
				System.out.println(qq.getTrackDuration());
	//		
		Gson gson = new Gson();
		String json = new Gson().toJson(pagination);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
		
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/deleteasong")
	public @ResponseBody void deletesong(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {

	String r = request.getParameter("trackid");
	//TracksDAO tr = new TracksDAO();
	tr.deletesong(Long.valueOf(r));
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/requestupdate")
	public @ResponseBody void requestupdate(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {

	 User user = (User) request.getSession().getAttribute("loginUser");
		try{
			userdao.changeuserrequest(user.getUserName());
		}
		catch(Exception e){}
		PrintWriter out=response.getWriter();
        //out.print(userL);
		out.flush();
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/showmoresongs")
	public @ResponseBody void getmoresongs(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("loginUser");
		String count = request.getParameter("hiddensong");
		String bysend = request.getParameter("newlistsize");
		int cc = Integer.parseInt(bysend); 
		cc = cc+3;
		Set<Track> pagination= new HashSet<Track>();
		List<PlayList> platL = playlistdao.getcurrentuserplaylist(user.getPersonID());
		
		Set<Track> allthesongs = tr.getallalbums(platL);
		int i=0;
		for(Track s : allthesongs){
			{
				if(i < cc)
					pagination.add(s);
			
			}
			i++;
		}
		for(Track qq : pagination)
				System.out.println(qq.getTrackDuration());
			de = cc;
		Gson gson = new Gson();
		String json = new Gson().toJson(pagination);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
		
	
	}
	
}
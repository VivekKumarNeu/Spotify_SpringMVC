package com.neu.project.admincontroller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.neu.project.DAO.AdminDAO;
import com.neu.project.DAO.AdminUserDAO;
import com.neu.project.DAO.PlaylistDAO;
import com.neu.project.DAO.UserDAO;
import com.neu.project.myexception.AdException;
import com.neu.project.pojo.PlayList;
import com.neu.project.pojo.User;

@Controller
@RequestMapping("/getusers")
public class admincontroller {
	
	@Autowired
	@Qualifier("AdminDAO")
	AdminDAO admindao;
	
	@Autowired
	@Qualifier("UserDAO")
	UserDAO userdao;
	
	@Autowired
	@Qualifier("PlaylistDAO")
	PlaylistDAO playlistdao;
	
	@Autowired
	@Qualifier("AdminUserDAO")
	AdminUserDAO adminuserdao;

	@RequestMapping(method = RequestMethod.POST,produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void Submit(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {

		//AdminUserDAO admindao = new AdminUserDAO();
		try{
		 User username=(User) request.getSession().getAttribute("loginUser");
		 List<User> userlist = adminuserdao.getallusers();
		 model.addAttribute("userlists", userlist);
		  //System.out.println(userlist.get(0).getAge());
		 JSONObject objOuter = new JSONObject();
		 String ok = "ok";
		 String no = "no";
		 int i=0;
	        if(userlist!=null)
	        {
	            for(User user:userlist)
	            {
	                i++;
	                JSONObject objInner = new JSONObject();
	                objInner.put("UserNameJson",user.getUserName());
	                objInner.put("approveButton","<input type='button' class='btn btn-success' name="+user.getFirstName()+":"+"ok"+" id="+user.getPersonID()+" onClick='requestdetails(name,id)' value='Approve Request' />");
	               
	                //objInner.put("approveButton","<input type='button' class='btn btn-success' name='"+ +"'  onClick='RequestJoin("+group.getId()+","+group.getUser().getId()+")' value='Request To Join'/>");
	                
	                objOuter.put("json"+i,objInner);
	            }
	        }
	        try{
	        PrintWriter out=response.getWriter();
	        out.print(objOuter);
	        out.flush();
	        }
	        catch(Exception e){}
		}
		catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}
		
}

	
	@RequestMapping(method = RequestMethod.POST, value = "/approverequest")
	public @ResponseBody void approverequestforpremium(HttpServletRequest request, HttpServletResponse response, Model model) {

		String User = request.getParameter("query");
		String[] username = User.split(":");
		String usernamee = username[0];
		String resp = username[1];
		String UserNamePersonId = request.getParameter("personId");
		int result=0;
		//AdminDAO admindao = new AdminDAO();
		try{
		result = admindao.requeststatus(usernamee, resp,UserNamePersonId);
		System.out.println(result);
		}
		catch(Exception e){}
		
        try{        	
        PrintWriter out=response.getWriter();
        out.print(result);
        out.flush();
        
        }
		catch(Exception e){}
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/getuseralbums")
	public @ResponseBody void getuserAlbums(HttpServletRequest request, HttpServletResponse response, Model model) {
		
		List<PlayList> platL = null;
		List<User> userL = null;
		
		
		try{
		platL =  playlistdao.getallplaylists();
		userL = userdao.getallusers();
		}
		catch(Exception e){}
		System.out.println(platL);
		System.out.println(userL);
		try{
		PrintWriter out=response.getWriter();
        //out.print(userL);
		out.flush();
		}
		catch(Exception e){}
		HttpSession session = request.getSession();
		session.setAttribute("allusershere", userL);
	
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/getpdf")
	public @ResponseBody void getpdf(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception{
		
		HttpSession session = request.getSession();
		List<User> userL = (List<User>) session.getAttribute("allusershere");
		List<PlayList> playL = (List<PlayList>) session.getAttribute("allplaylistshere");
		
		int lenofusertable = userL.size();

		Document d = new Document();
		PdfWriter.getInstance(d, new FileOutputStream("E:\\Spring Eclipse\\FinalProject\\src\\main\\webapp\\resources\\images\\report.pdf"));
		d.open();
		
		d.add(new Paragraph("User album List"));
		d.add(new Paragraph(""));
		for(User u : userL)
		{
			PdfPTable pt = new PdfPTable(2);	
			PdfPTable ptusername = new PdfPTable(1);
			ptusername.addCell(u.getFirstName());
			d.add(Chunk.NEWLINE );
			for(PlayList p : u.getPlaylists())
			{
				pt.addCell("PlayList ID:"+p.getPlaylistID());
				pt.addCell("PlayList Name:"+p.getPlaylistName());
			}
			d.add(ptusername);
			d.add(pt);
		}
		
		
		d.close();
		
		File f = new File("E:\\Spring Eclipse\\FinalProject\\src\\main\\webapp\\resources\\images\\test.txt");
        f.delete();
		
		
	}
	
	
}
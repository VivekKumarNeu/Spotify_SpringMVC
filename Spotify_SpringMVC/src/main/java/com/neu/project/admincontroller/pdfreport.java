package com.neu.project.admincontroller;

import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.neu.project.pojo.PlayList;
import com.neu.project.pojo.User;

@Controller
@RequestMapping("/generatepdf")
public class pdfreport {

	@RequestMapping(method = RequestMethod.GET)
	protected String doSubmitAction(Model model,HttpServletRequest request) throws Exception {

		HttpSession session = request.getSession();
		List<User> userL = (List<User>) session.getAttribute("allusershere");
		List<PlayList> playL = (List<PlayList>) session.getAttribute("allplaylistshere");
		
		int lenofusertable = userL.size();

		Document d = new Document();
		PdfWriter.getInstance(d, new FileOutputStream("c:/report.pdf"));
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
		
		return "adminarea";
		
		 
	}
	
}

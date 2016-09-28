package com.neu.project.songDbSave;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.neu.project.DAO.PlaylistDAO;
import com.neu.project.DAO.UserDAO;
import com.neu.project.DAO.UserSaveToDbDDAO;
import com.neu.project.DAO.playlistAlbDAO;
import com.neu.project.myexception.AdException;
import com.neu.project.pojo.Album;
import com.neu.project.pojo.Artist;
import com.neu.project.pojo.PlayList;
import com.neu.project.pojo.User;
import com.neu.project.setArtistData.setArtistData;
import com.neu.project.setTrack.InsertTracks;

@Controller
@RequestMapping("/songtodb")
public class songtodb {

	@Autowired
	@Qualifier("PlaylistDAO")
	PlaylistDAO playlistda;
	
	@Autowired
	@Qualifier("UserDAO")
	UserDAO userdao;
	
	@Autowired
	@Qualifier("setArtistData")
	setArtistData setartist;
	
	@Autowired
	@Qualifier("InsertTracks")
	InsertTracks inserttrackplay;
	
	@Autowired
	@Qualifier("InsertTracks")
	InsertTracks inserttrack;
	
	@Autowired
	@Qualifier("PlaylistDAO")
	PlaylistDAO playlistdao;
	
	@Autowired
	@Qualifier("playlistAlbDAO")
	playlistAlbDAO pp;
	
	@Autowired
	@Qualifier("UserSaveToDbDDAO")
	UserSaveToDbDDAO savetodb;
	
	
	@RequestMapping(method = RequestMethod.POST,produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void Submit(@RequestParam("query") String name, @RequestParam("playlistname") String playlistname, @RequestParam("hiddenName") String hiddenName, HttpServletResponse response) {
		// query --id
		//playlistname - name of playlist
		
		if(playlistname.equals(""))
			playlistname = "default";
		
		boolean playlistpresent = false;
		PlayList checkplaylistglobal = null;
		try{
			List checkplaylist = playlistda.existingplaylist(playlistname);
			 
			if(checkplaylist.size() > 0){
				checkplaylistglobal = (PlayList) checkplaylist.get(0);
				playlistpresent =  true;
			}

		} catch(Exception e){}
		
		
		// Album Name
		String albumname = "https://api.spotify.com/v1/albums/"+name;
		RestTemplate albumresttemp = new RestTemplate();

		String albumrestData = albumresttemp.getForObject(albumname, String.class);
		JSONObject albumjsonObject = new JSONObject(albumrestData);
		String albname = albumjsonObject.getString("name");
				
		//tracks
		String url = "https://api.spotify.com/v1/albums/"+name+"/tracks?limit=5";
		RestTemplate restTemplate = new RestTemplate();

		String restData = restTemplate.getForObject(url, String.class);
		List<String> songsname = new ArrayList<String>();
		
		JSONObject jsonObject = new JSONObject(restData);
		JSONArray items = jsonObject.getJSONArray("items");
		for (int i = 0; i < items.length(); ++i) {
		    JSONObject rec = items.getJSONObject(i);
		    songsname.add(rec.getString("name"));
		}
		//getting artist name
		JSONArray jsonitemsObject = jsonObject.getJSONArray("items");
		JSONObject jsonartistsObject = jsonitemsObject.getJSONObject(0);
		JSONArray vivek = jsonartistsObject.getJSONArray("artists");
		String artistname = vivek.getJSONObject(0).getString("name");
		
		//setArtistData setartist = new setArtistData();
		JSONArray jsonitemsObjectx = albumjsonObject.getJSONArray("artists");
		JSONObject jsonartistsObject1 = jsonitemsObjectx.getJSONObject(0);
		String urlid = jsonartistsObject1.getString("id");
		Artist artist = setartist.getartistdata(urlid, artistname);
		
		// Adding playlist
		//InsertTracks inserttrackplay = new InsertTracks();
		//UserDAO userdao = new UserDAO();
		User userr = null;
		try{
		userr = userdao.getuser(hiddenName);
		}
		catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}

		// adding to playlist
		if(!playlistpresent){
		//PlaylistDAO playlistdao = new PlaylistDAO();
		PlayList playl = null;
		try{
			playl = playlistdao.addtoplaylist(playlistname, inserttrackplay.getalbumTracks(name, albname),userr);
		}
		catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}
	
		
		
		// adding to album
		Album abl = null ;
		try{
			//UserSaveToDbDDAO savetodb = new UserSaveToDbDDAO();	
			//InsertTracks inserttrack = new InsertTracks();
			abl = savetodb.inserttoalbums(albname, inserttrack.getalbumTracks(name, albname), artist);
		}
		catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}
		try{
		//playlistAlbDAO pp = new playlistAlbDAO();
		pp.buildplaylistabs(abl, playl);
		}
		catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}
		
		try{
		PrintWriter out=response.getWriter();
        out.print("true");
		out.flush();
		}
		catch(Exception e){}
		
		}
		else
		{
			Album abl = null ;
			//UserSaveToDbDDAO savetodb = new UserSaveToDbDDAO();	
			//InsertTracks inserttrack = new InsertTracks();
			try{
			abl = savetodb.inserttoalbums(albname, inserttrack.getalbumTracks(name, albname), artist);
			}catch(Exception e){}
			
			//playlistAlbDAO pp = new playlistAlbDAO();
			try{
			pp.addtoExisting(abl,checkplaylistglobal);
			} catch(Exception e){}
			
		}
	}
	
}	

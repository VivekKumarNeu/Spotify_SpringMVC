package com.neu.project.setArtistData;

import java.util.HashSet;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.client.RestTemplate;

import com.neu.project.DAO.PlaylistDAO;
import com.neu.project.pojo.Artist;

public class setArtistData {

	public Artist getartistdata(String urlid, String artistName)
	{
		boolean flag = false;
		String url = "https://api.spotify.com/v1/artists/"+urlid;
		RestTemplate restTemplate = new RestTemplate();

		String restData = restTemplate.getForObject(url, String.class);

		JSONObject albumjsonObject = new JSONObject(restData);
		JSONArray jsonitemsObjectx = albumjsonObject.getJSONArray("genres");
		String genreId;
		if(jsonitemsObjectx.length() < 3)
			genreId = "EDM";
		else
			genreId = jsonitemsObjectx.getString(0);
		Artist artist = new Artist();
		artist.setArtistName(artistName);
		artist.setGenreID(genreId);
		
		return artist;
		
		
	}
	
	
	
	
	
}

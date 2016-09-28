package com.neu.project.setTrack;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

import com.neu.project.pojo.Track;

public class InsertTracks {

	
	public Set<Track> getalbumTracks(String name, String albumName)
	{
		
		String url = "https://api.spotify.com/v1/albums/"+name+"/tracks?limit=5";
		RestTemplate restTemplate = new RestTemplate();

		String restData = restTemplate.getForObject(url, String.class);
		Set<Track> songsname = new HashSet<Track>();
		
		
		JSONObject jsonObject = new JSONObject(restData);
		JSONArray items = jsonObject.getJSONArray("items");
		for (int i = 0; i < items.length(); ++i) {
			
		    JSONObject rec = items.getJSONObject(i);
		    Track t = new Track();
		    t.setTrackName(rec.getString("name"));
		    int sec = rec.getInt("duration_ms");
		    int seconds = (int) ((sec / 1000) % 60);
		    int minutes = (int) ((sec / 1000) / 60);
		    t.setTrackDuration(minutes +":" + seconds);
		    songsname.add(t);
		}
	
		return songsname;
	}
	
	
	
}

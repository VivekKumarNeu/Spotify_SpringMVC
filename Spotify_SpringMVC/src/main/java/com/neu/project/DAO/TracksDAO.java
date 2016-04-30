package com.neu.project.DAO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.SQLQuery;

import com.neu.project.pojo.Album;
import com.neu.project.pojo.PlayList;
import com.neu.project.pojo.Track;
import com.neu.project.pojo.playlistAlb;

public class TracksDAO extends DAO{

	public TracksDAO()
	{}
	
	static Set<Track> alltracks;
	static Set<Track> alltracks1;
	
	public Set<Track> getallalbums(List<PlayList> play)
	{
		alltracks = new HashSet<Track>();
		TracksDAO ttt = new TracksDAO();
		List<Album> alb = new ArrayList<Album>();
		
		for(PlayList p : play)
			{
			ttt.getalbumID(p.getPlaylistID(), alb);
			}
		
		return alltracks;
	}
	
	public void getalbumID(long PlayID,List<Album> alb)
	{
	
		begin();
			Query q=getSession().createQuery("from playlistAlb where playlistID = :playID");
            q.setLong("playID",PlayID);
            List<playlistAlb> albList =  q.list();
    		commit();
    		for(int i=0; i < albList.size() ; i++)
    		{
    			alb.add(albList.get(i).getAlbum());
    		}
            
    		for(int j=0; j < alb.size(); j++)
    		{
    			long iid = alb.get(j).getAlbumID();
    			begin();
    			String sql = "SELECT * FROM TRACK WHERE albumID = :iid";
    			SQLQuery query = getSession().createSQLQuery(sql).addEntity(Track.class);
    			query.setLong("iid", iid);
                List<Track> temp =  (List<Track>) query.list();
                commit();
                Track www1 = temp.get(0);
                for(int x =0; x < temp.size() ; x++){
                	Track www = temp.get(x);
                    alltracks.add(www);
                		
                }
    		}
	}
	
	public void deletesong(long id)
	{
		begin();
		Query query = getSession().createQuery("DELETE Track where trackID = :idd");
		query.setLong("idd", id);
		int result = query.executeUpdate();
        commit();
		System.out.println(result);
		
		
	}

	
	
	
	
	
	public Set<Track> getallalbumsppp(List<PlayList> play,int count)
	{
		alltracks1 = new HashSet<Track>();
		TracksDAO ttt1 = new TracksDAO();
		List<Album> alb = new ArrayList<Album>();
		
		for(PlayList p : play)
			{
			ttt1.getalbumIDppp(p.getPlaylistID(), alb,count);
			}
		
		return alltracks;
	}
	
	
	public Set<Track> getalbumIDppp(long PlayID,List<Album> alb, int count)
	{
	
		begin();
			Query q=getSession().createQuery("from playlistAlb where playlistID = :playID");
            q.setLong("playID",PlayID);
            List<playlistAlb> albList =  q.list();
    		commit();
    		for(int i=0; i < albList.size() ; i++)
    		{
    			alb.add(albList.get(i).getAlbum());
    		}
            
    		for(int j=0; j < alb.size(); j++)
    		{
    			long iid = alb.get(j).getAlbumID();
    			begin();
    			Query queryupdate = getSession().createQuery("from playlistAlb");
    			q.setFirstResult(count);
    			q.setMaxResults(count+3);
    			queryupdate.setLong("iid", iid);
                List<Track> temp =  (List<Track>) queryupdate.list();
                commit();
                Track www1 = temp.get(0);
                for(int x =0; x < temp.size() ; x++){
                	Track www = temp.get(x);
                 alltracks.add(www);
                 return alltracks;
                		
                }
    		}
    		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
}

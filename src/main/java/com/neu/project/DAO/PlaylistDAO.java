package com.neu.project.DAO;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import com.neu.project.myexception.AdException;
import com.neu.project.pojo.PlayList;
import com.neu.project.pojo.Track;
import com.neu.project.pojo.User;

public class PlaylistDAO extends DAO{

	public PlaylistDAO()
	{}
	
	public PlayList addtoplaylist(String playlistname, Set<Track> track, User user) throws AdException 
	{
		begin();
        Query q = getSession().createQuery("from PlayList where playlistName = :playlistname");
        q.setString("playlistname", playlistname);
        List play = q.list();
        commit();

       
        	PlayList playlist = new PlayList();
    		playlist.setPlaylistName(playlistname);
    		//playlist.setTracks(track);
    		playlist.setUser(user);
    		begin();
    		getSession().save(playlist);
            commit();
            return playlist;
        	
        }
     
	
	public List<PlayList> getallplaylists() throws AdException
	{
		 begin();
		 String sql = "SELECT * FROM PLAYLIST";
		 SQLQuery query = getSession().createSQLQuery(sql);
		 query.addEntity(PlayList.class);
		 List results = query.list();
		 commit();
		return results;
		
		
	}
        
	public List getcurrentuserplaylist(long userId)
	{
		
		begin();
		Query q = getSession().createQuery("from PlayList where user = :userId");
        q.setLong("userId", userId);
        List currrentuserlist = q.list();
        commit();
		
		return currrentuserlist;
		
	}
	
	public List getallplaylist(int count)
	{
		Criteria crit = getSession().createCriteria(PlayList.class);
        ProjectionList projList = Projections.projectionList();
        projList.add(Projections.max(String.valueOf(count)));
        projList.add(Projections.min("0"));
        crit.setProjection(projList);
        List results = crit.list();
        return results;
	}
	
	public List existingplaylist(String playlistname) throws AdException
	{
		try
		{
			begin();
			Query q=getSession().createQuery("from PlayList where playlistName = :playlistname");
            q.setString("playlistname",playlistname);
            List<PlayList> currrentplaylist = (List<PlayList>) q.list();
            commit();
            return currrentplaylist;
		}
		catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get user " + e);
        }
		
	}
    
}
        
	
	



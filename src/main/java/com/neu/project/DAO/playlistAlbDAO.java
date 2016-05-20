package com.neu.project.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.project.myexception.AdException;
import com.neu.project.pojo.Album;
import com.neu.project.pojo.PlayList;
import com.neu.project.pojo.User;
import com.neu.project.pojo.playlistAlb;

public class playlistAlbDAO extends DAO{

	public playlistAlbDAO()
	{}

	public void buildplaylistabs(Album album , PlayList play) throws AdException
	{
		
		try {
            begin();
            playlistAlb playl = new playlistAlb();
            playl.setAlbum(album);
            playl.setPlaylist(play);
            getSession().save(playl);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get user " + e);
        }
		
		
	}
	public List<Album> buildplaylistabs(String playlistId) throws AdException
	{
		List<Album> albList=null;
		try {
            begin();
            Query q=getSession().createQuery("from playlistAlb where playlist=:playlistId");
            q.setString("playlistId",playlistId);
            albList=q.list();

            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get user " + e);
        }
		
		return albList;
	}

	public void addtoExisting(Album album , PlayList play) throws AdException
	{
		playlistAlbDAO ww = new playlistAlbDAO();
		boolean shouldbeaddedornot = doesalbumexistinplaylist(album , play);
		if(!shouldbeaddedornot)
			ww.deleteplaylistalbum(album);
		
		if(shouldbeaddedornot){
		try{
			begin();
			playlistAlb p = new playlistAlb();
			p.setAlbum(album);
			p.setPlaylist(play);
			getSession().save(p);
            commit();
		}
		catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get user " + e);
        }
		}
		
	}
	
	public static boolean doesalbumexistinplaylist(Album album , PlayList play) throws AdException
	{
		String albumName = album.getAlbumName();
		Query q=getSession().createQuery("from playlistAlb where playlistID=:playlistid");
		q.setLong("playlistid", play.getPlaylistID());
		List<playlistAlb> albList =  q.list();
		
		for(int i=0; i < albList.size() ; i++)
		{
			if(albList.get(i).getAlbum().getAlbumName().equals(album.getAlbumName()))
			{
				return false;
			}
		}
			
			return true;
	}
	
	public void deleteplaylistalbum(Album album) throws AdException
	{
		try{
		begin();
		Query q=getSession().createQuery("DELETE from Album WHERE albumID=:albumId");
		q.setLong("albumId", album.getAlbumID());
		int result = q.executeUpdate();
		commit();
		}
		catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get user " + e);
        }
	}
}

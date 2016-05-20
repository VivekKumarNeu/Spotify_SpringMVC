package com.neu.project.DAO;

import java.util.Set;

import org.hibernate.HibernateException;

import com.neu.project.myexception.AdException;
import com.neu.project.pojo.Album;
import com.neu.project.pojo.Artist;
import com.neu.project.pojo.Track;

public class UserSaveToDbDDAO extends DAO{

	public UserSaveToDbDDAO()
	{}
	
	public Album inserttoalbums(String albumname, Set<Track> track, Artist artist) throws AdException {
        try {
            begin();
        	Album album = new Album();
        	album.setAlbumName(albumname);
        	album.setTracks(track);
        	album.setArtist(artist);
        	getSession().save(album);
        	commit();
            return album;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get user " + albumname, e);
        }
    }
	
	
	
}

package com.neu.project.pojo;

import java.security.acl.Group;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="playlistAlb")
public class playlistAlb {

	 @Id
     @GeneratedValue
     @Column(name = "playlistAlbid", unique=true, nullable = false)
     private int id;
	
	 @OneToOne
	 @JoinColumn(name="playlistID")
	 private PlayList playlist;
	 
	 @OneToOne
	 @JoinColumn(name="albumID")
	 private Album album;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PlayList getPlaylist() {
		return playlist;
	}

	public void setPlaylist(PlayList playlist) {
		this.playlist = playlist;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}
	
}

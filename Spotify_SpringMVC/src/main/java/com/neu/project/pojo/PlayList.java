package com.neu.project.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="playlist")
public class PlayList {

	@Id
	@GeneratedValue
	@Column(name = "playlistID", unique=true, nullable = false)
	private int playlistID;
	
	@Column(name = "playlistName")
	private String playlistName;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
    @JoinColumn(name = "user")
	private User user;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="PLAYLIST_TRACK", 
    joinColumns={@JoinColumn(name="playlistID")}, 
    inverseJoinColumns={@JoinColumn(name="trackID")})
    private Set<Track> tracks = new HashSet<Track>();

	public int getPlaylistID() {
		return playlistID;
	}

	public void setPlaylistID(int playlistID) {
		this.playlistID = playlistID;
	}

	public String getPlaylistName() {
		return playlistName;
	}

	public void setPlaylistName(String playlistName) {
		this.playlistName = playlistName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Track> getTracks() {
		return tracks;
	}

	public void setTracks(Set<Track> tracks) {
		this.tracks = tracks;
	}
	
	
}

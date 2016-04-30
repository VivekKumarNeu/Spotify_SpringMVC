package com.neu.project.pojo;

import java.util.ArrayList;
import java.util.List;
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
import javax.persistence.Table;

@Entity
@Table(name="track")
public class Track {

	
	@Id
	@GeneratedValue
	@Column(name = "trackID", unique=true, nullable = false)
	private int trackID;
	
	@Column(name = "trackName")
	private String trackName;
	
	@Column(name = "trackDuration")
	private String trackDuration;
	
//	@ManyToMany(cascade = {CascadeType.ALL})
//	@JoinTable(name="TRACK_ARTIST", 
//    joinColumns={@JoinColumn(name="trackID")}, 
//    inverseJoinColumns={@JoinColumn(name="artistID")})
//    private List<Artist> artists = new ArrayList<Artist>();

	public int getTrackID() {
		return trackID;
	}

	public void setTrackID(int trackID) {
		this.trackID = trackID;
	}

	public String getTrackName() {
		return trackName;
	}

	public void setTrackName(String trackName) {
		this.trackName = trackName;
	}

	public String getTrackDuration() {
		return trackDuration;
	}

	public void setTrackDuration(String trackDuration) {
		this.trackDuration = trackDuration;
	}

//	public Album getAlbum() {
//		return album;
//	}
//
//	public void setAlbum(Album album) {
//		this.album = album;
//	}

//	public List<Artist> getArtists() {
//		return artists;
//	}
//
//	public void setArtists(List<Artist> artists) {
//		this.artists = artists;
//	}
	
	
}

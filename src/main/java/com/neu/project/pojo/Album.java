package com.neu.project.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="album")
public class Album {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int albumID;
	
	@Column(name = "albumName")
	private String albumName;
	
	@OneToMany(fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
	@JoinColumn(name="albumID")
    private Set<Track> tracks;

	//onetoone
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "album", cascade = CascadeType.ALL)
	@Cascade(org.hibernate.annotations.CascadeType.DELETE)
    private Artist artist;

	public int getAlbumID() {
		return albumID;
	}

	public void setAlbumID(int albumID) {
		this.albumID = albumID;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public Set<Track> getTracks() {
		return tracks;
	}

	public void setTracks(Set<Track> tracks) {
		this.tracks = tracks;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	
}

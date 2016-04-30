package com.neu.project.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="artist")
public class Artist {
	
	@Id
	@GeneratedValue
	@Column(name = "artistID", unique=true, nullable = false)
	private int artistID;
	
	@Column(name = "artistName")
	private String artistName;
	
	@Column(name = "genreID")
	private String genreID;
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	@Cascade(org.hibernate.annotations.CascadeType.DELETE)
	private Album album;

	public int getArtistID() {
		return artistID;
	}

	public void setArtistID(int artistID) {
		this.artistID = artistID;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getGenreID() {
		return genreID;
	}

	public void setGenreID(String genreID) {
		this.genreID = genreID;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}



}

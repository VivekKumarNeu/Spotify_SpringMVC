package com.neu.project.pojo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


//  name,  password, email
@Entity
@Table(name="user")
@PrimaryKeyJoinColumn(name="personID")
public class User extends Person{
	
	@Column(name="user")
    private String userName;
	
	@Column(name="password")
    private String password;
	
	@Column(name="email")
    private String email;
	
	@Column(name="role")
	private String role = "Admin";
	
	@Column(name="status")
	private String status = "No";
	
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name = "user")
	private Set<PlayList> playlists;
	
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    User() {
    }

    
    public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public String getEmail() {
		return email;
		
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<PlayList> getPlaylists() {
		return playlists;
	}

	public void setPlaylists(Set<PlayList> playlists) {
		this.playlists = playlists;
	}
	
}
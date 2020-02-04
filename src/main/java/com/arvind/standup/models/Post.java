package com.arvind.standup.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "posts")
public class Post {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	@NotNull
	String description;
	@ManyToOne
	private PostThread postThread;
	@OneToOne
	private User user;
	
	public Post() {
		
	}
	public Post(int id, String description, PostThread postThread, User user) {
		this.id = id;
		this.description = description;
		this.postThread = postThread;
		this.user = user;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public PostThread getThread() {
		return postThread;
	}
	public void setPostThread(PostThread postThread) {
		this.postThread = postThread;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}

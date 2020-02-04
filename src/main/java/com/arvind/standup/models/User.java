package com.arvind.standup.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class User {
	@Id
	@Column(name = "id", updatable = false, nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	String name;
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY,
    cascade = {
        CascadeType.ALL
    },
    mappedBy = "users")
	
    private Set<Team> teams = new HashSet<>();
	
	public User() {
		
	}
	public User(int id, String name, Set < Team > teams) {
		this.id = id;
		this.name = name;
		this.teams = teams;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Team> getTeams() {
		return teams;
	}
	public void setTeams(Set<Team> teams) {
		this.teams = teams;
	}
	
}

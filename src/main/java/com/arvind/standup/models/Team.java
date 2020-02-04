package com.arvind.standup.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "teams")
public class Team {
	@Id
	@Column(name = "id", updatable = false, nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	String name;
	
	@ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.ALL
            })
    @JoinTable(name = "user_team_mapping",
            joinColumns = { @JoinColumn(name = "team_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id") })

    private Set<User> users = new HashSet<>();

	public Team() {
		
	}
	
	public Team(int id, String name) {
		this.id = id;
		this.name = name;
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

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
}

package com.arvind.standup.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.arvind.standup.exceptions.TeamNotFoundException;
import com.arvind.standup.models.Team;
import com.arvind.standup.repository.TeamRepository;

@RestController
public class TeamController {
	@Autowired
	TeamRepository teamRepository;
	
	@GetMapping("/teams")
	public List<Team> index() {
		return teamRepository.findAll();
	}
	
	@PostMapping("/teams")
	public Team create(@Valid @RequestBody Team team) {
		return teamRepository.save(team);
	}
	
	@GetMapping("/teams/{id}")
	public Optional<Team> show(@PathVariable(value = "id") Integer teamId) {
		return teamRepository.findById(teamId);
	}
	
	@PutMapping("/teams/{id}")
	public Team update(@PathVariable(value = "id") Integer teamId, @Valid @RequestBody Team teamParams) throws TeamNotFoundException {
		Team team = teamRepository.findById(teamId)
				.orElseThrow(() -> new TeamNotFoundException());
		team.setName(teamParams.getName());
		Team savedTeam = teamRepository.save(team);
		return savedTeam;
	}
}

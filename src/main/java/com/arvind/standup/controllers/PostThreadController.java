package com.arvind.standup.controllers;

import java.sql.Date;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.arvind.standup.models.PostThread;
import com.arvind.standup.repository.PostThreadRepository;

@RestController
public class PostThreadController {
	@Autowired
	PostThreadRepository postThreadRepository;
	
//	@GetMapping("/threads/{team_id}")
//	public List<PostThread> getThreadsByTeam(@PathVariable(value = "team_id") int teamId) {
//		return postThreadRepository.findByTeamId(teamId);
//	}
	
	@GetMapping("/threads/{thread_id}")
	public Optional<PostThread> getThreadsById(@PathVariable(value = "thread_id") int id) {
		return postThreadRepository.findById(id);
	}
	
	@PostMapping("/threads")
	public PostThread create(@Valid @RequestBody PostThread postThread) {
		return postThreadRepository.save(postThread);
	}
	
	@GetMapping("/threads/{team_id}/{date}")
	public PostThread show(@PathVariable(value = "team_id") int teamId, @PathVariable(value = "date") Date threadDate) {
		return postThreadRepository.findByTeamIdAndDate(teamId, threadDate);
	}
}

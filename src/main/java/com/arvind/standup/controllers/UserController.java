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

import com.arvind.standup.exceptions.UserNotFoundException;
import com.arvind.standup.models.User;
import com.arvind.standup.repository.UserRepository;

@RestController
public class UserController {
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/users")
	public List<User> index() {
		return userRepository.findAll();
	}
	
	@PostMapping("/users")
	public User create(@Valid @RequestBody User user) {
		return userRepository.save(user);
	}
	
	@GetMapping("/users/{id}")
	public Optional<User> show(@PathVariable(value = "id") Integer teamId) {
		return userRepository.findById(teamId);
	}
	
	@PutMapping("/users/{id}")
	public User update(@PathVariable(value = "id") Integer userId, @Valid @RequestBody User userParams) throws UserNotFoundException {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new UserNotFoundException());
		user.setName(userParams.getName());
		User savedTeam = userRepository.save(user);
		return savedTeam;
	}

}

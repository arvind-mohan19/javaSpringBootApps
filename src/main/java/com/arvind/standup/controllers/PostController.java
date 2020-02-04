package com.arvind.standup.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;

import com.arvind.standup.exceptions.ThreadNotFoundException;
import com.arvind.standup.models.Post;
import com.arvind.standup.models.PostThread;
import com.arvind.standup.repository.PostRepository;
import com.arvind.standup.repository.PostThreadRepository;

@RestController
public class PostController {
	@Autowired
	PostRepository postRepository;
	
	@Autowired
	PostThreadRepository postThreadRepository;
	
	@GetMapping("/threads/{thread_id}/posts")
	public List<Post> getPosts(@PathVariable(value = "thread_id") int threadId) throws ThreadNotFoundException {
		return postRepository.findByPostThreadId(threadId);
	}
	
	@PostMapping("/threads/{thread_id}/posts")
	public Post create(@PathVariable(value = "thread_id") int threadId, @Valid @RequestBody Post post) {
		return postThreadRepository.findById(threadId).map(postThread -> {
			post.setPostThread(postThread);
			return postRepository.save(post);
		}).orElseThrow(() -> new ResourceAccessException("Thread" + threadId + " not found"));
	}
}

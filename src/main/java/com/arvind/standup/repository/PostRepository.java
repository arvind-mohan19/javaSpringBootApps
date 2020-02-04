package com.arvind.standup.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arvind.standup.models.Post;
import com.arvind.standup.models.PostThread;

public interface PostRepository extends JpaRepository<Post, Integer>{

	List<Post> findByPostThreadId(int post_thread_id);
}

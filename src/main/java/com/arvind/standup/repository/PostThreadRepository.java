package com.arvind.standup.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arvind.standup.models.PostThread;
import com.arvind.standup.models.Team;

public interface PostThreadRepository extends JpaRepository<PostThread, Integer>{
	List<PostThread> findByTeamId(int teamId);
	PostThread findByTeamIdAndDate(int teamId, Date date);
}

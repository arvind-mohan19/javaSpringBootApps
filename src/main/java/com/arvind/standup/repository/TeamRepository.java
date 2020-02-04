package com.arvind.standup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arvind.standup.models.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer>{

}

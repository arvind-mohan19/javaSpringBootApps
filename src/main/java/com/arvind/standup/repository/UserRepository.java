package com.arvind.standup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arvind.standup.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}

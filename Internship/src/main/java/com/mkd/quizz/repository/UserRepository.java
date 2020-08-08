package com.mkd.quizz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mkd.quizz.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

}

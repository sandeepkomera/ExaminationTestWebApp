package com.slokam.Examination.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.slokam.Examination.entity.UserPojo;

@Repository
public interface UserDao extends JpaRepository<UserPojo, Long> {

	
}

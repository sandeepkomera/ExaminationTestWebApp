package com.slokam.Examination.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.slokam.Examination.entity.QuestionPojo;

@Repository
public interface QuestionDao extends JpaRepository<QuestionPojo, Long>{

	
}

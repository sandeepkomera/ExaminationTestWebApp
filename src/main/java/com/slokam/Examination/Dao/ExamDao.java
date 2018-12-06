package com.slokam.Examination.Dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.slokam.Examination.entity.ExamPojo;

@Repository
public interface ExamDao extends JpaRepository<ExamPojo, Long>{

	@Query("select e.examName, e.id from ExamPojo e ")
	public List<Object[]> GetAllExamDetails(ExamPojo examPojo);
}

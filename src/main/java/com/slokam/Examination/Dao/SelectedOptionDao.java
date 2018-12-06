package com.slokam.Examination.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.slokam.Examination.entity.SelectedOption;

@Repository
public interface SelectedOptionDao extends JpaRepository<SelectedOption, Long>{

	@Query ("select s from SelectedOption s join s.examuser eu join s.question q where eu.id=?1 and q.id=?2")
	public List<SelectedOption> getExistingOptions(Long examUserId,Long questionId);
	
	@Query("from SelectedOption s where s.examuser.id=?1 and s.option.correct=true")
	public List<SelectedOption> getSelectOptionsByExamUser(Long examUserId);
}

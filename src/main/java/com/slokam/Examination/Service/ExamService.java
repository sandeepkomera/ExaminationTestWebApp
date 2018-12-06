package com.slokam.Examination.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slokam.Examination.Dao.ExamDao;
import com.slokam.Examination.entity.ExamPojo;

@Service
public class ExamService {

	@Autowired
	private ExamDao examDao;

	public void saveExam(ExamPojo exam) throws Exception{
/*
		if(true) {
			throw new Exception();
		}*/
		
		exam.setCreatedDate(new Date());
		examDao.save(exam);

	}

	public List<Object[]> getALLExamDetails(ExamPojo exams) {
		return examDao.GetAllExamDetails(exams);

	}
}
package com.slokam.Examination.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slokam.Examination.Dao.QualificationDao;
import com.slokam.Examination.entity.Qualification;

@Service
public class QualificationService {
	@Autowired
	private QualificationDao qualificationDao;
	
	public List<Qualification> getqualification(){
		return qualificationDao.findAll();
	}

}

package com.slokam.Examination.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.slokam.Examination.Dao.NationalityDao;
import com.slokam.Examination.entity.Nationality;

@Service
public class NationalityService {
	
	@Autowired
	private NationalityDao nationalityDao;
	
	public List<Nationality> getDetails(){
		
		return nationalityDao.findAll();
	}
	
	public void saveNation(Nationality nation) {
	
		nationalityDao.save(nation);
		
	}

}

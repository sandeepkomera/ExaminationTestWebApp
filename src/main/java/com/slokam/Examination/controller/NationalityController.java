package com.slokam.Examination.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slokam.Examination.Dao.NationalityDao;
import com.slokam.Examination.Service.NationalityService;
import com.slokam.Examination.entity.Nationality;


@RestController
@RequestMapping("nationality")
@CrossOrigin
public class NationalityController {
	@Autowired
	private NationalityService nationalityservice;
	
	@GetMapping("/all")
	public ResponseEntity<List<Nationality>> getDetails(){
		List<Nationality> list = nationalityservice.getDetails();

		ResponseEntity<List<Nationality>> re = new ResponseEntity<List<Nationality>>(list,HttpStatus.OK);
		return re;
	}
	
	
	@PostMapping
	public ResponseEntity<Nationality> SaveNation(@RequestBody Nationality nation){
		
		
		
		return null;
		
	}

}

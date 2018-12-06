package com.slokam.Examination.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slokam.Examination.Service.QualificationService;
import com.slokam.Examination.entity.Qualification;


@RestController
@RequestMapping("qualification")
@CrossOrigin
public class QualificationController {

	@Autowired
	private QualificationService qualificationService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Qualification>> getqualification(){

		List<Qualification> list = qualificationService.getqualification();
		ResponseEntity<List<Qualification>> re = new ResponseEntity<List<Qualification>>(list,HttpStatus.OK);
		return re;
		
	}
	
}

package com.slokam.Examination.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slokam.Examination.Service.ExamUserService;
import com.slokam.Examination.entity.ExamUser;

@RestController
@RequestMapping("examUser")
public class ExamUserController {
	
	@Autowired
	private ExamUserService examUserService;
	
	@PostMapping()
	public void saveExamUser(@RequestBody ExamUser examUser ) {
		examUserService.saveStartedTime(examUser);
	}
	
	@PostMapping("/{euid}")
	public void endExamUser(@PathVariable Long euid) {
		examUserService.saveEndTime(euid);
	}

}

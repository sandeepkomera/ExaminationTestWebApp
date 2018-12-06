package com.slokam.Examination.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slokam.Examination.Service.QuestionService;
import com.slokam.Examination.entity.QuestionPojo;

@RestController
@RequestMapping("question")
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	@PostMapping
	public void saveQuestion(@RequestBody QuestionPojo question) {

		questionService.saveQuestion(question);
	}

	@GetMapping("/pojo/{id}" )
	public QuestionPojo getByID(@PathVariable long id) {
		
		return questionService.GetById(id);
	}

}
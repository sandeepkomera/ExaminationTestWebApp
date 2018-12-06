package com.slokam.Examination.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import com.slokam.Examination.Service.QuestionService;
import com.slokam.Examination.Service.ValidationException;
import com.slokam.Examination.entity.OptionPojo;
import com.slokam.Examination.entity.QuestionPojo;

import sun.print.resources.serviceui;

@RunWith(SpringRunner.class)
@DataJpaTest
@ComponentScan("com.slokam.Examination.controller,com.slokam.Examination.Service,com.slokam.Examination.controller")
public class QuestionServiceTest {

	@Autowired
	private QuestionService questionService;
	
	@Test(expected=ValidationException.class)
	public void test1() {
		QuestionPojo question = new QuestionPojo();
		question.setDescription("JAVA");
		questionService.saveQuestion(question);
		
		questionService.GetById(1);
		
	}
	@Test
	public void test2() {
		List<OptionPojo> list = new ArrayList<>();
		QuestionPojo q = new QuestionPojo();
		OptionPojo opt = new OptionPojo();
		opt.setDescription("first option");
		list.add(opt);
		q.setOptions(list);
		questionService.saveQuestion(q);
		QuestionPojo que = questionService.GetById(1);
		Assert.assertNotNull(que);
	}
	
	
	@Test
	public void test3() {
		List<OptionPojo> list = new ArrayList<>();
		QuestionPojo q = new QuestionPojo();
		OptionPojo opt = new OptionPojo();
		opt.setDescription("second option");
		list.add(opt);
		q.setOptions(list);
		questionService.saveQuestion(q);
		QuestionPojo que = questionService.GetById(3);
		Assert.assertNull(que);
	}
	
	
	
}

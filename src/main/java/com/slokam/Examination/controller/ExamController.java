package com.slokam.Examination.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slokam.Examination.Service.ExamService;
import com.slokam.Examination.entity.ExamPojo;

@RestController
@RequestMapping("exam")
public class ExamController {

	@Autowired
	private ExamService examService;
	
	//@Autowired
	//private MailSender mailSender;
	
	@PostMapping
	public void saveExam(@RequestBody ExamPojo exam) throws Exception {
		
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo("sandeep.komera@gmail.com");
		mail.setFrom("sandeep.komera@gmail.com");
		mail.setSubject("First Mail Through MailServer");
		mail.setText("This is the first message");
		
		//mailSender.send(mail);
		examService.saveExam(exam);

	}
	
	@GetMapping("/all")
	public List<Object[]>getALLExamDetails(ExamPojo exams){
		return examService.getALLExamDetails(exams);
	}
	
	@GetMapping("/file")
	public void fileRead() throws Exception{
		
		System.out.println("fileNotFound");
		FileReader fr = new FileReader("E:\\My WorkSpace\\Uploads\\");
		BufferedReader br = new BufferedReader(fr);
	}
   @Scheduled(fixedDelay =1000)
   @PostMapping("/savi")
   	public void print () {
		System.out.println("Local Server");
	}
}

package com.slokam.Examination.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.slokam.Examination.Service.UserService;
import com.slokam.Examination.entity.UserPojo;

import ch.qos.logback.core.util.FixedDelay;

@RestController
@RequestMapping("users")
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@PostMapping
	public ResponseEntity SaveUser(@RequestBody UserPojo userPojo) {
		System.out.println(userPojo);
		userService.save(userPojo);
		return new ResponseEntity(HttpStatus.OK);

	}
	
	@GetMapping("/all")
	public ResponseEntity<List<UserPojo>> getAllUser() {
		List<UserPojo> list = userService.getAll();
		ResponseEntity<List<UserPojo>> re = new ResponseEntity<List<UserPojo>>(list,HttpStatus.OK);
		return re;
	}
	
	@PostMapping("/savefile")
	public void saveUser(@RequestParam ("upFile")MultipartFile multiPart) {
		
		System.out.println(multiPart.getOriginalFilename());
		System.out.println(multiPart.getSize());
		System.out.println(multiPart.getName());
		System.out.println(multiPart.getContentType());
		
		try {
			multiPart.transferTo(new File("E:\\My WorkSpace\\Uploads\\"+multiPart.getOriginalFilename()));
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}

	}
	
	@GetMapping("/imageName/{image}")
	public FileSystemResource getImage(@PathVariable ("image") String image) {
		FileSystemResource fr = new FileSystemResource("E:\\My WorkSpace\\Uploads\\"+image);
		return fr;
	}
	
	@GetMapping("/getImagenames")
	public String[] getImageNames() {
		File file = new File("E:\\My WorkSpace\\Uploads\\");
		return file.list();
	}
	
	@GetMapping("/video/{name}")
	public FileSystemResource getVideo(@PathVariable("name") String videoName) {
		FileSystemResource vid =  new FileSystemResource("E:\\My WorkSpace\\Videos\\"+videoName);
		return vid;
	}
	
	@GetMapping("/videoNames")
	public List<String> getVideoNames(){
		List<String>videoNames = new ArrayList<>();
		File file = new File("E:\\My WorkSpace\\Videos\\");
		String [] fileName = file.list();
		for(int i=0;i<fileName.length;i++) {
			String name = fileName[i];
			if(name.endsWith(".mp4")) {
				videoNames.add(name);				
			}
		}
		return videoNames;
	}
	
}

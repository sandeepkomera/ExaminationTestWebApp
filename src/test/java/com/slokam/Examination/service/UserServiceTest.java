package com.slokam.Examination.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import com.slokam.Examination.Service.UserService;
import com.slokam.Examination.entity.UserPojo;


@RunWith(SpringRunner.class)
@DataJpaTest
@ComponentScan("com.slokam.Examination.controller,com.slokam.Examination.Service,com.slokam.Examination.controller")
public class UserServiceTest {

	@Autowired
	private UserService userService;
	
	@Test
	public void createUserTest() {
		
		UserPojo user = new UserPojo();
		user.setName("sandeep");
		System.out.println("Before saving ::" + user.getId());
		userService.save(user);
		System.out.println("After Saving :: "+user.getId());
		
		Assert.assertEquals(2, user.getId());
		
		List<UserPojo> list = userService.getAll();
		boolean flag=false;
		for (UserPojo userPojo : list) {
			if(userPojo.getName().equals(user.getName())) {
				flag=true;
			}
		}
		
		Assert.assertTrue(flag);
		
		
	}
	@Test
	public void createUser2() {
		UserPojo user2 = new UserPojo();
		user2.setName("dev");
		System.out.println("Before Saving"+user2.getId());
		userService.save(user2);
		System.out.println("After Saving "+user2.getId());
		Assert.assertEquals(1, user2.getId());
		
		List<UserPojo> list2 = userService.getAll();
		boolean flag2 = false;
		for (UserPojo userPojo : list2) {
			if (userPojo.getName().equals(user2.getName())) {
				flag2=true;
			}
			Assert.assertTrue(flag2);
		}
		
	}
	
}

package com.slokam.Examination;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.slokam.Examination.controller.UserController;
import com.slokam.Examination.entity.UserPojo;

@RunWith(SpringRunner.class)
@DataJpaTest
@ComponentScan("com.slokam.Examination.controller,com.slokam.Examination.Service,com.slokam.Examination.controller")
@EntityScan
public class TestController {
	

	@Autowired
	private UserController userController;
	
	@Autowired
	private EntityManager entityManager;
	
	@Test
	public void saveandverify() {
		entityManager.merge(new UserPojo());
		ResponseEntity<List<UserPojo>> re = userController.getAllUser();
		System.out.println(re.getBody().size());
		System.out.println(re.getStatusCode());
		
	}
	

}


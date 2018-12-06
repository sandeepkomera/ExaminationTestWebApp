package com.slokam.Examination;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.slokam.Examination.controller.NationalityController;
import com.slokam.Examination.entity.Nationality;

@DataJpaTest
@RunWith(SpringRunner.class)
@ComponentScan("com.slokam.Examination.controller,com.slokam.Examination.Service,com.slokam.Examination.Dao")
public class NationalityControllerTest {

	@Autowired
	private EntityManager entitymanager;
	
	@Autowired
	private NationalityController controller;
	
	@Test
	public void save() {
		
		Nationality nat = new Nationality();
		nat.setName("India");
		entitymanager.merge(nat);
		Nationality nat2 = new Nationality();
		nat2.setName("India");
		ResponseEntity actual = controller.SaveNation(nat2);
		
	}
	
}

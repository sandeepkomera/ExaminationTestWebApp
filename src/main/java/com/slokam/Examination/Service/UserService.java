package com.slokam.Examination.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slokam.Examination.Dao.UserDao;
import com.slokam.Examination.entity.UserPojo;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public void save (UserPojo userPojo) {
		userDao.save(userPojo);
	}
	
	public List<UserPojo> getAll(){
		return userDao.findAll();
	}
	
}

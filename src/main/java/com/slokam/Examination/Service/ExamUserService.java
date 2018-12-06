package com.slokam.Examination.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slokam.Examination.Dao.ExamUserDao;
import com.slokam.Examination.Dao.SelectedOptionDao;
import com.slokam.Examination.entity.ExamUser;
import com.slokam.Examination.entity.SelectedOption;

@Service
public class ExamUserService {

	@Autowired
	private ExamUserDao examUserDao;
	
	@Autowired
	private SelectedOptionDao selectedOptionDao;
	
	public void saveStartedTime(ExamUser examuser) {
		examuser.setStart(new Date());
		examUserDao.save(examuser);
	}
	
	public void saveEndTime(Long examUserId) {
		List<SelectedOption> correctOptions = selectedOptionDao.getSelectOptionsByExamUser(examUserId);
		
		Optional<ExamUser> optional = examUserDao.findById(examUserId);
		if(optional.isPresent()) {
			ExamUser exmusr=optional.get();
			if(correctOptions.isEmpty()) {
				exmusr.setResult(0);
			}else {
				exmusr.setResult(correctOptions.size());
			}
			exmusr.setEnd(new Date());
			
			examUserDao.save(exmusr);
		}
		
		
	}
	
	
}

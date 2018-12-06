package com.slokam.Examination.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slokam.Examination.Dao.SelectedOptionDao;
import com.slokam.Examination.entity.OptionPojo;
import com.slokam.Examination.entity.SelectedOption;


@Service
public class SelectedOptionService {

	@Autowired
	private SelectedOptionDao selectedOptionDao;
	
	public void saveSelectedOptions(List<SelectedOption> selectedList) {
		selectedOptionDao.saveAll(selectedList);
	}
	
	public List<SelectedOption> getExistingOptions(Long examUserId, Long questionId){
		List<SelectedOption> selectlist = selectedOptionDao.getExistingOptions(examUserId, questionId);
		for (SelectedOption selectedOption : selectlist) {
			selectedOption.setQuestion(null);
			OptionPojo option = selectedOption.getOption();
			option.setQuestion(null);
			
			selectedOption.setExamuser(null);;;
		}
		return selectlist;
	}
	
	
}

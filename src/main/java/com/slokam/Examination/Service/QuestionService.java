package com.slokam.Examination.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.slokam.Examination.Dao.QuestionDao;
import com.slokam.Examination.entity.OptionPojo;
import com.slokam.Examination.entity.QuestionPojo;

@Service
public class QuestionService {

	@Autowired
	private QuestionDao questionDao;

	/*public void saveQuestion(QuestionPojo question) {

		List<OptionPojo> opt = question.getOptions();
		for (OptionPojo optionPojo : opt) {
			optionPojo.setQuestion(question);
		}

		questionDao.save(question);
	}

	public QuestionPojo GetById(long id) {

		Optional<QuestionPojo> optional = questionDao.findById(id);

		if (optional.isPresent()) {
			QuestionPojo questionPojo = optional.get();
			List<OptionPojo> optionalList = questionPojo.getOptions();
			for (OptionPojo optionPojo : optionalList) {
				optionPojo.setQuestion(null);
			}
			return optional.get();
		} else {
			return null;
		}

	}
*/
	public void saveQuestion(QuestionPojo question) {

		List<OptionPojo> opt = question.getOptions();
		if(opt!=null) {
		for (OptionPojo optionPojo : opt) {
			optionPojo.setQuestion(question);
		}

		questionDao.save(question);
		}else {
			throw new ValidationException("Enter Data");
		}
	}

	public QuestionPojo GetById(long id) {

		Optional<QuestionPojo> optional = questionDao.findById(id);

		if (optional.isPresent()) {
			QuestionPojo questionPojo = optional.get();
			List<OptionPojo> optionalList = questionPojo.getOptions();
			for (OptionPojo optionPojo : optionalList) {
				optionPojo.setQuestion(null);
			}
			return optional.get();
		} else {
			return null;
		}

	}
}

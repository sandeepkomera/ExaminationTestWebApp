package com.slokam.Examination.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slokam.Examination.Service.SelectedOptionService;
import com.slokam.Examination.entity.SelectedOption;

@RestController
@RequestMapping("selectedOptions")
public class SelectedOptionController{
	
	@Autowired
	private SelectedOptionService selectedOptionService;
	
	@PostMapping
	public void saveSelectedOption(@RequestBody List<SelectedOption> selectedList) {
	
		selectedOptionService.saveSelectedOptions(selectedList);
	}

	public List<SelectedOption> getExistingOptions(@PathVariable ("euid") Long examUserId,@PathVariable("qid")Long questionId){
		
		return selectedOptionService.getExistingOptions(examUserId, questionId);
	}
	
}

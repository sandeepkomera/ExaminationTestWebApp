package com.slokam.Examination.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "selectedOption")
public class SelectedOption {

	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne
	@JoinColumn(name ="qid")
	private QuestionPojo question;
	
	@OneToOne
	@JoinColumn(name="oid")
	private OptionPojo option;
	
	@ManyToOne
	@JoinColumn(name="euid")
	private ExamUser examuser;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public QuestionPojo getQuestion() {
		return question;
	}

	public void setQuestion(QuestionPojo question) {
		this.question = question;
	}

	public OptionPojo getOption() {
		return option;
	}

	public void setOption(OptionPojo option) {
		this.option = option;
	}

	public ExamUser getExamuser() {
		return examuser;
	}

	public void setExamuser(ExamUser examuser) {
		this.examuser = examuser;
	}

	

	
}

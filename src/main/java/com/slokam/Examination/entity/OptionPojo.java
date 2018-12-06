package com.slokam.Examination.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "optionname")
public class OptionPojo {

	@Id
	@GeneratedValue
	private long id;
	private String description;

	@ManyToOne
	@JoinColumn(name = "qid")
	private QuestionPojo question;
	private boolean correct;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public QuestionPojo getQuestion() {
		return question;
	}

	public void setQuestion(QuestionPojo question) {
		this.question = question;
	}

	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}

}

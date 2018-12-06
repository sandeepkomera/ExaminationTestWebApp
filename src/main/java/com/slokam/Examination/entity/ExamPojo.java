package com.slokam.Examination.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "exam")
public class ExamPojo {

	@Id
	@GeneratedValue
	private long id;
	private String examName;
	
	@ManyToOne
	@JoinColumn(name="cbid")
	private UserPojo createdBy;
	private String subject;
	private Date createdDate;

	@ManyToMany
	@JoinTable(name="exam_question",joinColumns= {@JoinColumn(name="eid")},
							 inverseJoinColumns= {@JoinColumn(name="qid")})
	private List<QuestionPojo> question;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public UserPojo getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(UserPojo createdBy) {
		this.createdBy = createdBy;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public List<QuestionPojo> getQuestion() {
		return question;
	}

	public void setQuestion(List<QuestionPojo> question) {
		this.question = question;
	}

}

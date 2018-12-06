package com.slokam.Examination.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "examUser")
public class ExamUser {

	@Id
	@GeneratedValue
	private long id;

	@ManyToOne
	@JoinColumn(name = "uid")
	private UserPojo user;

	@ManyToOne
	@JoinColumn(name = "eid")
	private ExamPojo exam;
	private Date start;
	private Date end;
	private Integer result;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public UserPojo getUser() {
		return user;
	}

	public void setUser(UserPojo user) {
		this.user = user;
	}

	public ExamPojo getExam() {
		return exam;
	}

	public void setExam(ExamPojo exam) {
		this.exam = exam;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

}

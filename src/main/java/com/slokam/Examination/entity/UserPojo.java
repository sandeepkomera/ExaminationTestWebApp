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
@Table(name = "user")
public class UserPojo {

	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String password;
	
	private Date dob;
	private String gender;
	@ManyToOne
	@JoinColumn(name="nid")
	private Nationality nation;
	
	@ManyToMany
	@JoinTable(name="user_qualification",
			joinColumns= {@JoinColumn(name="uid")},
			inverseJoinColumns= {@JoinColumn(name="qid")})
		private List<Qualification> qualification;
	
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}


	public Nationality getNation() {
		return nation;
	}

	public void setNation(Nationality nation) {
		this.nation = nation;
	}

	public List<Qualification> getQualification() {
		return qualification;
	}

	public void setQualification(List<Qualification> qualification) {
		this.qualification = qualification;
	}

	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserPojo [id=" + id + ", name=" + name + ", password=" + password + ", dob=" + dob + ", gender="
				+ gender + ", nation=" + nation + ", qualification=" + qualification + "]";
	}

}

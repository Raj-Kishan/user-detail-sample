package com.sample.entities;

import java.util.Date;

public class Users implements java.io.Serializable {

	private static final long serialVersionUID = 783817834696933944L;

	private String userId;
	private String firstname;
	private String lastname;
	private Integer age;
	private Date joineddate;

	public Users() {
	}

	public Users(String userId) {
		this.userId = userId;
	}

	public Users(String userId, String firstname, String lastname, Integer age, Date joineddate) {
		this.userId = userId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.joineddate = joineddate;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getJoineddate() {
		return this.joineddate;
	}

	public void setJoineddate(Date joineddate) {
		this.joineddate = joineddate;
	}

}

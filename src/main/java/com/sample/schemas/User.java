package com.sample.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "firstName", "lastName", "age", "joinedDate", "userId" })
@XmlRootElement(name = "User")
public class User {

	@XmlElement(name = "FirstName", required = true)
	protected String firstName;

	@XmlElement(name = "LastName", required = true)
	protected String lastName;

	@XmlElement(name = "Age")
	protected int age;

	@XmlElement(name = "JoinedDate", required = true)
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar joinedDate;

	@XmlElement(name = "UserId", required = true)
	protected String userId;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String value) {
		this.firstName = value;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String value) {
		this.lastName = value;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int value) {
		this.age = value;
	}

	public XMLGregorianCalendar getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(XMLGregorianCalendar value) {
		this.joinedDate = value;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String value) {
		this.userId = value;
	}

}

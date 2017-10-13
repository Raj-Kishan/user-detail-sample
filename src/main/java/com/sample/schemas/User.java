package com.sample.schemas;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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

	@NotNull
	@Size(min = 3)
	@XmlElement(name = "FirstName", required = true)
	protected String firstName;

	@NotNull
	@Size(min = 3)
	@XmlElement(name = "LastName", required = true)
	protected String lastName;

	@XmlElement(name = "Age")
	@Min(18)
	@Max(70)
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

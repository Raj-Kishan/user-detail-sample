package com.sample.schemas;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "user" })
@XmlRootElement(name = "Users")
public class Users {

	@XmlElement(name = "User", required = true)
	protected List<User> user;

	public List<User> getUser() {
		if (user == null) {
			user = new ArrayList<User>();
		}
		return this.user;
	}

}

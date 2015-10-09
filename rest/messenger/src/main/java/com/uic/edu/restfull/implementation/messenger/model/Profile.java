package com.uic.edu.restfull.implementation.messenger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Profile {
	private long id;
	private String proflieName;
	private String firstName;
	private String lastName;

	public Profile() {
	}

	public Profile(long id, String proflieName, String firstName, String lastName) {
		this.id = id;
		this.proflieName = proflieName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.created = new Date();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProfileName() {
		return proflieName;
	}

	public void setProfileName(String proflieName) {
		this.proflieName = proflieName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	private Date created;

}

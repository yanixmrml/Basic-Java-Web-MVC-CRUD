package org.yanixmrml.entity;


public class User {
	private int userID;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String middlename;
	
	
	public User() {
		super();
	}
	
	public User(int userID, String username, String password, String firstname, String lastname, String middlename) {
		super();
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.middlename = middlename;
	}

	public User(String username, String password, String firstname, String lastname, String middlename) {
		super();
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.middlename = middlename;
	}

	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getMiddlename() {
		return middlename;
	}
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}
	
	
}

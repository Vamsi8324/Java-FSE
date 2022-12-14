package com.java.solid.app;

public class DatabaseDetails {
	String url="";
	String userName="";
	String password="";
	
	//Class for storing db details
	public DatabaseDetails(String url, String userName, String password) {
		super();
		this.url = url;
		this.userName = userName;
		this.password = password;
	}
}

package com.ECart.Project.jwt;
    
public class JwtRequest {
	private String username;
	private String userpassword;

	public JwtRequest() {
		System.out.println("jwt Request");
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	
}

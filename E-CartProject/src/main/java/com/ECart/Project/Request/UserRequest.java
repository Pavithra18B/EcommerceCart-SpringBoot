package com.ECart.Project.Request;

import java.util.Set;

import lombok.Data;

@Data
public class UserRequest {

	private String username;

	private String firstname;

	private String lastname;

	private String userpassword;

	private String emailid;

	private Set<Integer> role;

}

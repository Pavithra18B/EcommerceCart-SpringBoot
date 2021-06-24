package com.ECart.Project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ECart.Project.ControllerInterface.UserControllerInterface;
import com.ECart.Project.Entity.User;
import com.ECart.Project.Request.UserRequest;
import com.ECart.Project.Service.UserService;

@RestController
public class UserController implements UserControllerInterface {
	@Autowired
	private UserService userService;

	/*
	 * @PostConstruct public void UserRole() {
	 * System.out.println("set default user function "); userService.UserRole();
	 * 
	 * }
	 */
     
	@Override
	@PostMapping("/adduser")
	public User addUser(@RequestBody UserRequest userRequest) throws Exception {

		System.out.println("User controller");
		return userService.addUser(userRequest);
	}

	/*
	 * @DeleteMapping("/removeuser/{userid}")
	 * 
	 * @PreAuthorize("hasRole('Admin')") public void delUser(@PathVariable("userid")
	 * Long userid) { userService.delUser(userid); }
	 */
}

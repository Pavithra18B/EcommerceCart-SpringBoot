package com.ECart.Project.ControllerInterface;

import com.ECart.Project.Entity.User;
import com.ECart.Project.Request.UserRequest;

public interface UserControllerInterface {
	public User addUser(UserRequest userRequest) throws Exception;

}

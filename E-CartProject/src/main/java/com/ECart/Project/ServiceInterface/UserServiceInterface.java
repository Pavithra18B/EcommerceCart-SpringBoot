package com.ECart.Project.ServiceInterface;

import com.ECart.Project.Entity.User;
import com.ECart.Project.Request.UserRequest;

public interface UserServiceInterface {
	public User addUser(UserRequest userRequest) throws Exception;

}

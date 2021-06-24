package com.ECart.Project.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ECart.Project.ControllerInterface.RoleControllerInterface;
import com.ECart.Project.Entity.Role;
import com.ECart.Project.Request.RoleRequest;
import com.ECart.Project.Service.RoleService;

@RestController
public class RoleController implements RoleControllerInterface {
	
	@Autowired
	private RoleService roleService;

	@PostMapping("/addrole")
	@PreAuthorize("hasRole('Admin')")
	public Role addRole(@RequestBody RoleRequest roleRequest) {
		return roleService.addRole(roleRequest);
	}
}

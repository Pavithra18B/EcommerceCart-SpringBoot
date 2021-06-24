package com.ECart.Project.Service;
  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ECart.Project.Entity.Role;
import com.ECart.Project.Repository.RoleRepository;
import com.ECart.Project.Request.RoleRequest;
import com.ECart.Project.ServiceInterface.RoleServiceInterface;

@Service
public class RoleService implements RoleServiceInterface {
	@Autowired
	private RoleRepository roleRepository;

	public Role addRole(RoleRequest roleRequest) {
	
		Role role = new Role();
		System.out.println(role.toString());
		role.setRolename(roleRequest.getRolename());
		role.setRoledescription(roleRequest.getRoledescription());
		
		return roleRepository.save(role);
	}

}

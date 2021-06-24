package com.ECart.Project.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ECart.Project.Entity.Role;
import com.ECart.Project.Entity.User;
import com.ECart.Project.Repository.RoleRepository;
import com.ECart.Project.Repository.UserRepository;
import com.ECart.Project.Request.UserRequest;
import com.ECart.Project.ServiceInterface.UserServiceInterface;

@Service
public class UserService implements UserServiceInterface {
	@Autowired 
	private UserRepository userRepository;

	@Autowired 
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passEncode;


	
	/*
	 * public void UserRole() { Role holderrole = new Role();
	 * holderrole.setRolename("Holder");
	 * holderrole.setRoledescription("defualt role for new user");
	 * roleRepo.save(holderrole);
	 * 
	 * }
	 */
	 

	public String getEncodedPass(String userpassword) {
	return passEncode.encode(userpassword);
	
	}


	public User addUser(UserRequest userRequest) throws Exception {
		User user = new User();
		Set<Role> roles = new HashSet<>();
		System.out.println(user.toString());
		user.setUsername(userRequest.getUsername() );
		user.setFirstname(userRequest.getFirstname());
		user.setLastname(userRequest.getLastname());
		user.setEmailid(userRequest.getEmailid());
		user.setUserpassword(getEncodedPass(userRequest.getUserpassword()));
		
		for(Integer roleid: userRequest.getRole()) {
			Optional<Role> role = roleRepository.findById(roleid);
			if(!role.isPresent()) {
			throw new Exception ("Role not found");
			}else {
				roles.add(role.get());
				System.out.println("Getting role");
			}
		}
		user.setRole(roles);
		return userRepository.save(user);
	}


	//public void delUser(Long userid) {
	// userRepository.delete(user);}
		// TODO Auto-generated method stub
		


}

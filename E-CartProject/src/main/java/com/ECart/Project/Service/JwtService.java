package com.ECart.Project.Service;
  
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ECart.Project.Entity.User;
import com.ECart.Project.Repository.UserRepository;
import com.ECart.Project.Util.JwtUtil;
import com.ECart.Project.jwt.JwtRequest;
import com.ECart.Project.jwt.JwtResponse;

@Service
public class JwtService implements UserDetailsService {
	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AuthenticationManager authenticationManager;


	//returning generated t0ken

	public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception {
		System.out.println("getting user name (jwt service)");

		String username = jwtRequest.getUsername();
		String userpassword = jwtRequest.getUserpassword();
		//authenticate(user_name, user_password);

		// UserDetails userDetails = loadUserByUsername(user_name);


		User user = userRepository.findByUserName(username);
		System.out.println(user);
		String newGeneratedToken = jwtUtil.generateToken(username);
		return new JwtResponse(user,newGeneratedToken);

	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		System.out.println("able to find (jwt Service class)");

		User user = userRepository.findByUserName(username);

		if (user != null) {
			return new org.springframework.security.core.userdetails.User(
					user.getUsername(),
					user.getUserpassword(),
					getAuthority(user)
					);
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}

	}


	private Set getAuthority(User user) {
		System.out.println("autharity to role(jwt service)");

		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		user.getRole().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRolename()));
		});
		return authorities;
	}

	private void authenticate(String username, String userpassword) throws Exception {

		System.out.println("credentail exceptions");
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, userpassword));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}

}

package com.ECart.Project.Repository;
  
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ECart.Project.Entity.User;

@Repository
public interface UserRepository extends BaseRepository<User, Integer>{
	
	@Query("SELECT u FROM User u WHERE u.username = ?1")
	 User findByUserName(String username);

}

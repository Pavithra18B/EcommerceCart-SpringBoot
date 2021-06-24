package com.ECart.Project.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ECart.Project.Entity.Role;
   
@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

}

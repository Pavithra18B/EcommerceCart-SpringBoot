package com.ECart.Project.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
    
@Data
@Entity
@Table(name = "role")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "roleid")
	private int roleid;
	
	@Column(name = "rolename")
	private String rolename;
	
	@Column(name = "roledescription")
	private String roledescription;
	
	
	
	
	public Role() {
	System.out.println("Role Entity");
	}
}

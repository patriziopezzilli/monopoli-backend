package com.ristorantemonopoli.backend.authentication.service;

import java.util.List;

import com.ristorantemonopoli.backend.database.entity.Role;
import com.ristorantemonopoli.backend.database.entity.User;

public interface UserService {
	
    User save(User user);
    
    User findByUsername(String username);
    
	void saveRole(Role role);
	
	List<Role> getRoles(String username);
	
}
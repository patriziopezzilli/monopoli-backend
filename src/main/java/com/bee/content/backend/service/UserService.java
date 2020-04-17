package com.bee.content.backend.service;

import java.util.List;

import com.bee.content.backend.database.entity.Role;
import com.bee.content.backend.database.entity.User;

public interface UserService {
	
    User save(User user, String merchant);
    
    User findByUsername(String username, String merchant);
    
	void saveRole(Role role, String merchant);
	
	List<Role> getRoles(String username, String merchant);
	
}
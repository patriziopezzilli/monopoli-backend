package com.ristorantemonopoli.backend.service.impl;

import com.ristorantemonopoli.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ristorantemonopoli.backend.database.entity.Role;
import com.ristorantemonopoli.backend.database.entity.User;
import com.ristorantemonopoli.backend.database.repository.RoleRepository;
import com.ristorantemonopoli.backend.database.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
	
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user = userRepository.save(user);
        return user;
    }
    
    @Override
    public void saveRole(Role role) {
    	roleRepository.save(role);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    @Override
    public List<Role> getRoles(String username) {
    	List<Role> roles = new ArrayList<Role>();
    	return roles;
    }
    
    
}
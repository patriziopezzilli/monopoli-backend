package com.bee.content.backend.service.impl;

import com.bee.content.backend.utils.ThreadState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bee.content.backend.database.entity.Role;
import com.bee.content.backend.database.entity.User;
import com.bee.content.backend.database.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
	        if (null != user) {
		        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		        for (Role role : user.getRoles()) {
		            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
		        }
		        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
	        } else {
	        	throw new UsernameNotFoundException("USER NOT FOUND");
	        }
        
        }
       
}
package com.bee.content.backend.service.impl;

import com.bee.content.backend.database.entity.Role;
import com.bee.content.backend.database.entity.User;
import com.bee.content.backend.database.repository.RoleRepository;
import com.bee.content.backend.database.repository.UserRepository;
import com.bee.content.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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
    public User save(User user, String merchant) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setMerchant(merchant);
        user = userRepository.save(user);
        return user;
    }

    @Override
    public void saveRole(Role role, String merchant) {
        roleRepository.save(role);
    }

    @Override
    public User findByUsername(String username, String merchant) {
        if (null == merchant) {
            return userRepository.findByUsername(username);
        }

        return userRepository.findByUsernameAndMerchant(username, merchant);
    }

    @Override
    public List<Role> getRoles(String username, String merchant) {
        List<Role> roles = new ArrayList<Role>();
        return roles;
    }


}
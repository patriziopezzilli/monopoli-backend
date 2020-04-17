package com.bee.content.backend;

import java.util.HashSet;
import java.util.Set;

import com.bee.content.backend.service.UserService;
import com.bee.content.backend.database.entity.Role;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bee.content.backend.database.entity.User;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ApplicationTest {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private UserService userService;

	@Ignore
	@Test
	public void testUserDetails() {
		System.out.println("Database URL is : "+ env.getProperty("spring.datasource.url"));
		User userDetails  = userService.findByUsername("prasad.suseela@gmail.com", "Test");
		System.out.println(userDetails.getUsername());
	}

	@Ignore
	@Test
	public void testSaveUser() {
		
		User user = new User();
		user.setId(2L);
		user.setUsername("contact@akveo.com");
		user.setPassword("password123");
		user.setFirstName("Nebular");
		user.setMiddleName("Developer");
		user.setMerchant("Test");
		user.setLastName("Suseela");
		Set<Role> roles = new HashSet<Role>();
		Role role = new Role();
		role.setId(2L);
		role.setName("developer");
		roles.add(role);
		userService.saveRole(role, "Test");
		user.setRoles(roles);
		User userDetails  = userService.save(user, "Test");
		System.out.println(userDetails.getUsername() + " && " +userDetails.getPassword());
	}

}
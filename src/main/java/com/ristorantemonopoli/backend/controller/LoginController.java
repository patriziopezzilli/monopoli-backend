package com.ristorantemonopoli.backend.controller;

import static com.ristorantemonopoli.backend.constants.SecurityConstants.HEADER_STRING;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ristorantemonopoli.backend.authentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ristorantemonopoli.backend.database.entity.Role;
import com.ristorantemonopoli.backend.database.entity.User;
import com.ristorantemonopoli.backend.dto.LoginDTO;

@RestController
public class LoginController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/auth/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public LoginDTO login(User user, HttpServletResponse response) {
		String jwtToken = response.getHeader(HEADER_STRING);
		LoginDTO loginDTO = new LoginDTO();
		LoginDTO.Data data = loginDTO.new Data();
		data.setToken(jwtToken);
		loginDTO.setData(data);
		return loginDTO;
    }
	
	@RequestMapping(value = "/auth/logout", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<LoginDTO> logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		SecurityContextHolder.clearContext();
        HttpSession session= request.getSession(false);
        if(session != null) {
            session.invalidate();
        }
        if (null != request.getCookies()) {
        	for(Cookie cookie : request.getCookies()) {
            	cookie.setMaxAge(0);
        	}
        }
        
        response.addHeader(HEADER_STRING,"");
        LoginDTO authResult = new LoginDTO();
		return new ResponseEntity<LoginDTO>(authResult, HttpStatus.OK);
	}
	
	
   @PostMapping("/sign-up")
    public void signUp(@RequestBody User user) {
	   Role admin = new Role();
	   admin.setName("Admin");
	   admin.setId(1L);
	   Set<Role> roles = new HashSet<Role>();
	   roles.add(admin);
	   user.setRoles(roles);
	   userService.save(user);
    }
}

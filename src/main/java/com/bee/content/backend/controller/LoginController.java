package com.bee.content.backend.controller;

import com.bee.content.backend.constants.SecurityConstants;
import com.bee.content.backend.database.entity.User;
import com.bee.content.backend.dto.LoginDTO;
import com.bee.content.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class LoginController {

    @RequestMapping(value = "/auth/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public LoginDTO login(User user, HttpServletResponse response) {
        String jwtToken = response.getHeader(SecurityConstants.HEADER_STRING);
        LoginDTO loginDTO = new LoginDTO();
        LoginDTO.Data data = loginDTO.new Data();
        data.setToken(jwtToken);
        loginDTO.setData(data);
        return loginDTO;
    }

    @RequestMapping(value = "/auth/logout", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<LoginDTO> logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
        SecurityContextHolder.clearContext();
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        if (null != request.getCookies()) {
            for (Cookie cookie : request.getCookies()) {
                cookie.setMaxAge(0);
            }
        }

        response.addHeader(SecurityConstants.HEADER_STRING, "");
        LoginDTO authResult = new LoginDTO();
        return new ResponseEntity<LoginDTO>(authResult, HttpStatus.OK);
    }
}

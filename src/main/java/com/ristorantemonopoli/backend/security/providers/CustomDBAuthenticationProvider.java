package com.ristorantemonopoli.backend.security.providers;

import java.util.ArrayList;
import java.util.List;

import com.ristorantemonopoli.backend.authentication.service.UserService;
import com.ristorantemonopoli.backend.database.entity.ApplicationUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CustomDBAuthenticationProvider implements AuthenticationProvider {

    private Logger logger = LoggerFactory.getLogger(CustomDBAuthenticationProvider.class);

    @Autowired
    UserService userService;
    
    @Override
    @Transactional
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {

        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        List<GrantedAuthority> roles = new ArrayList<>();

        if (authenticate(username, password)) {
            ApplicationUser appUser = new ApplicationUser();
            logger.debug("Going to fetch roles from DB as a part of successful authentication");
            com.ristorantemonopoli.backend.database.entity.User userEntity = userService.findByUsername(username);

            if (null != userEntity) {
                appUser.setFirstName(userEntity.getUsername());
                appUser.setLastName("");
                userEntity.getRoles().forEach(roles::add);
               
            }

            User user = new User(username, password, true, true, true, true, roles);
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user, password, roles);
            token.setDetails(appUser);

            return token;
        } else {
            return null;
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(
                UsernamePasswordAuthenticationToken.class);
    }

    /**
     *
     * @param username username
     * @param password password
     * @return authentication status
     */
    private boolean authenticate(String username, String encodedPasswordFromUI) {
    	
    	com.ristorantemonopoli.backend.database.entity.User userEntity = userService.findByUsername(username);
    	if(null != userEntity && userEntity.getPassword().equals(encodedPasswordFromUI)) {
    		return true;
    	} else {
    		return false;
    	}
    
    }
}
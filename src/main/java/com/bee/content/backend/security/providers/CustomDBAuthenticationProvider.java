package com.bee.content.backend.security.providers;

import com.bee.content.backend.dto.ApplicationUser;
import com.bee.content.backend.service.UserService;
import com.bee.content.backend.utils.ThreadState;
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

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomDBAuthenticationProvider implements AuthenticationProvider {

    private Logger logger = LoggerFactory.getLogger(CustomDBAuthenticationProvider.class);

    @Autowired
    private UserService userService;

    @Override
    @Transactional
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {

        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        List<GrantedAuthority> roles = new ArrayList<>();

        if (authenticate(username, password)) {
            ApplicationUser appUser = new ApplicationUser();
            com.bee.content.backend.database.entity.User userEntity = userService.findByUsername(username, ThreadState.INSTANCE.getMerchant());
            System.out.println("> found user " + userEntity);

            if (null != userEntity) {
                appUser.setFirstName(userEntity.getUsername());
                appUser.setLastName("");
                userEntity.getRoles().forEach(roles::add);
                appUser.setMerchant(userEntity.getMerchant());

                System.out.println("> set merchant from user entity " + appUser.getMerchant());
                ThreadState.INSTANCE.setMerchant(appUser.getMerchant());
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
     * @param username username
     * @return authentication status
     */
    private boolean authenticate(String username, String encodedPasswordFromUI) {

        com.bee.content.backend.database.entity.User userEntity = userService.findByUsername(username, ThreadState.INSTANCE.getMerchant());
        System.out.println("> found user " + userEntity);
        if (null != userEntity && userEntity.getPassword().equals(encodedPasswordFromUI)) {
            System.out.println("> PASSWORD ok");
            return true;
        } else {
            System.out.println("> PASSWORD wrong");
            return false;
        }

    }
}
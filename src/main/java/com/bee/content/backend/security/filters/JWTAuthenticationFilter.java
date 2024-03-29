package com.bee.content.backend.security.filters;

import com.bee.content.backend.database.entity.MerchantEntity;
import com.bee.content.backend.dto.ApplicationUser;
import com.bee.content.backend.service.MerchantService;
import com.bee.content.backend.service.UserService;
import com.bee.content.backend.utils.ThreadState;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import static com.bee.content.backend.constants.SecurityConstants.*;


public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    Logger logger = LoggerFactory.getLogger(JWTAuthenticationFilter.class);

    private UserService userService;
    private MerchantService merchantService;
    private AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, UserService userService, MerchantService merchantService) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.merchantService = merchantService;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException {
        try {

            InputStream ist = req.getInputStream();
            res.setHeader("Access-Control-Allow-Headers", "Authorization");
            res.setHeader("Access-Control-Expose-Headers", "Authorization");
            logger.debug("Attempting for Authentication......");

            ApplicationUser creds = new ObjectMapper()
                    .readValue(ist, ApplicationUser.class);
            System.out.println("> found creds " + creds);

            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            creds.getEmail(),
                            creds.getPassword(),
                            new ArrayList<>())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {

        logger.debug("Successfully authenticated....");
        List<String> roles = new ArrayList<String>();

        for (GrantedAuthority authority : auth.getAuthorities()) {
            roles.add(authority.getAuthority());
        }

        ApplicationUser loggedInUser = new ApplicationUser();
        String userName = ((User) auth.getPrincipal()).getUsername();
        loggedInUser.setEmail(userName);
        loggedInUser.setRoles(roles);

        com.bee.content.backend.database.entity.User user = userService.findByUsername(userName, null);
        MerchantEntity merchantEntity = merchantService.retrieveMerchant(user.getMerchant());

        System.out.println("Merchant " + ThreadState.INSTANCE.getMerchant());
        String token = Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .setExpiration(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000))
                .claim("id", user.getId())
                .claim("email", ((User) auth.getPrincipal()).getUsername())
                .claim("firstName", user.getFirstName())
                .claim("lastName", user.getLastName())
                .claim("merchant", user.getMerchant())
                .claim("merchantTitle", merchantEntity.getName())
                .claim("merchantUrl", merchantEntity.getUrl())
                .claim("merchantPlan", merchantEntity.getPlan())
                .claim("template", merchantEntity.getTemplate())
                .claim("roles", roles)
                .compact();

        logger.debug("Appending token in the response.");
        res.addHeader(HEADER_STRING, TOKEN_PREFIX + token);

        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        Map<String, String> jsonMap = new HashMap<>();
        jsonMap.put("token", token);
        JSONObject jsonObject = new JSONObject(jsonMap);
        res.getWriter().write(jsonObject.toString());
    }

    @Override
    public void setPasswordParameter(String passwordParameter) {
        super.setPasswordParameter("password");
    }


    @Override
    public void setUsernameParameter(String usernameParameter) {
        super.setUsernameParameter("email");
    }


}
package com.bee.content.backend.config;

import com.bee.content.backend.constants.SecurityConstants;
import com.bee.content.backend.security.filters.JWTAuthenticationFilter;
import com.bee.content.backend.security.filters.JWTAuthorizationFilter;
import com.bee.content.backend.service.MerchantService;
import com.bee.content.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.Collections;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    @Autowired
    private MerchantService merchantService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        JWTAuthenticationFilter authenticationFilter = new JWTAuthenticationFilter(authenticationManager(), userService, merchantService);
        authenticationFilter.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher(SecurityConstants.LOGIN_URL));
        http.cors()
                .and()
                .csrf()
                .disable();

        http.authorizeRequests().requestMatchers(EndpointRequest.toAnyEndpoint())
                .permitAll().antMatchers(HttpMethod.GET, "/health")
                .permitAll().antMatchers(HttpMethod.POST, SecurityConstants.LOGIN_URL).permitAll().anyRequest().authenticated().and()
                .addFilter(authenticationFilter).addFilter(new JWTAuthorizationFilter(authenticationManager()));
    }

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    protected CorsFilter crossFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.setAllowedHeaders(Collections.singletonList("*"));
        config.setAllowedOrigins(Collections.singletonList("*"));
        //config.setAllowedHeaders("*"); whitelist all sites
        //config.setAllowedOrigins("*"); whitelist all headers
        config.addAllowedMethod(HttpMethod.OPTIONS);
        config.addAllowedMethod(HttpMethod.GET);
        config.addAllowedMethod(HttpMethod.POST);
        config.addAllowedMethod(HttpMethod.PUT);
        config.addAllowedMethod(HttpMethod.DELETE);
        config.addExposedHeader("Authorization");
        config.setMaxAge(new Long(1800));

        source.registerCorsConfiguration("/api/**", config);
        source.registerCorsConfiguration("/v2/api-docs", config);
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(bCryptPasswordEncoder());
        return authenticationProvider;
    }
}
package com.bee.content.backend.service;

public interface SecurityService {

    String findLoggedInUsername(String merchant);

    void autologin(String username, String password, String merchant);

}

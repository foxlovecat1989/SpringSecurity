package com.example.springsecurity.dao;

import com.example.springsecurity.auth.ApplicationUser;

import java.util.Optional;

public interface ApplicationUserDao {
    Optional<ApplicationUser> selectApplicationUserByName(String name);
}

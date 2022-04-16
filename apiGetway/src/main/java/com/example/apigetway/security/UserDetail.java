package com.example.apigetway.security;

import lombok.Data;

import java.util.Collection;
@Data
public class UserDetail {
    private String username;
    private String userId;
    private Collection<Authority> authorities;

}

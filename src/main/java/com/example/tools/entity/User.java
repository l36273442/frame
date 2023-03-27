package com.example.tools.entity;

import lombok.Data;

import java.math.BigInteger;

@Data
public class User {
    private long id;
    private String account;
    private String name;
    private String email;
    private String telephone;
    private int ctime;
    private int lastLoginTime;
    private int uptime;
    private int status;
}

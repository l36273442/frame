package com.example.tools.service;


import com.example.tools.dao.UserMapper;
import com.example.tools.dao2.TestMapper;
import com.example.tools.entity.User;
import com.example.tools.entity2.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


@Service
public class UserService {

    @Autowired(required = false)
    private UserMapper userMapper;

    @Autowired(required = false)
    private TestMapper testMapper;

    public int AddUserInfo(BigInteger id, String name) {
        return 0;
    }

    public List<User> getAll() {
        List<User> list = new ArrayList<>();
        list = userMapper.selectAll();
        return list;
    }

    public List<User> getByNname(String name) {
        return userMapper.getByName(name);
    }
}
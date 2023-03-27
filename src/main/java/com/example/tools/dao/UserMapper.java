package com.example.tools.dao;


import com.example.tools.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface UserMapper {

    int insertUserInfo(User user);

    List<User> selectAll();

    List<User> getByName(String name);
}
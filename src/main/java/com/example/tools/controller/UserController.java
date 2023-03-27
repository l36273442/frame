package com.example.tools.controller;


import com.example.tools.entity.User;
import com.example.tools.service.UserService;
import com.example.tools.utils.BaseController;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;

@Controller
public class UserController extends BaseController {

    @Autowired
    private UserService userService;
    @Autowired
    private HttpServletRequest request;

    //@Autowired
    //@Qualifier("r1RedisTemplate")
    //private RedisTemplate r1Redis;

    //@Autowired
    //@Qualifier("r2RedisTemplate")
    //private RedisTemplate r2Redis;


    //上传用户信息
    @GetMapping("/adduser")
    @ResponseBody
    public int AddUserInfo() {
        int res = userService.AddUserInfo(BigInteger.valueOf(4), "haha");
        return res;
    }

    @RequestMapping("/getall")
    @ResponseBody
    public List<User> getAll() {
        HashMap<String, Object> name = new HashMap<>();
        name.put(String.valueOf(System.currentTimeMillis()), System.currentTimeMillis());
        List<User> list = userService.getAll();
        return list;
    }

    @RequestMapping("/getbyname")
    @ResponseBody
    public List<User> getByName(@Param("n") String name) {
        List<User> list = userService.getByNname(name);
        for (User a : list) {
            System.out.print(a.getName());
        }
        return list;
    }
    /*
    @RequestMapping("/testredis")
    @ResponseBody
    public String testRedis(){
        String s = String.valueOf(r1Redis.opsForValue().get("n"));
        System.out.println(s);
        r2Redis.opsForValue().set("x","12345");
        System.out.println(String.valueOf(r2Redis.opsForValue().get("x")));
        System.out.println(String.valueOf(r1Redis.opsForValue().get("x")));
        return "OK";
    }
     */
}
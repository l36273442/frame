package com.example.tools.controller;


import com.example.tools.entity.User;
import com.example.tools.service.AsyncService;
import com.example.tools.utils.BaseController;
import org.python.core.Py;
import org.python.core.PySystemState;
import org.python.jline.internal.InputStreamReader;
import org.python.util.PythonInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.env.Environment;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.Charset;


@EnableAsync
@Controller
@Service
public class TestController extends BaseController {
    @Autowired
    AsyncService asyncService;
    @Autowired(required = false)
    private User user;

    @Autowired
    private Environment environment;
    @RequestMapping("test111")
    @ResponseBody
    public String test111() {
        try {
            asyncService.test();
        } catch (Exception e) {

        }
        System.out.println("aaaaaaaaaaaa");
        return "dfdfdsfdfdsf";

    }

    @RequestMapping("/test")
    public String test(Model model) {
        model.addAttribute("msg", "标准变量表达式");

        User user = new User();
        user.setId(1);
        user.setName(environment.getProperty("aa"));
        user.setAccount("123");

        model.addAttribute("user", user);
        return "test";
    }

    @RequestMapping("/test/python")
    @ResponseBody
    public String python() {

        PySystemState sys = Py.getSystemState();
        sys.path.add("D:\\python36\\Lib\\site-packages");
        Process proc;
        try {
            proc = Runtime.getRuntime().exec("python E:\\python\\tools\\test.py");// 执行py文件
            //用输入输出流来截取结果
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream(), Charset.forName("GBK")));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
                System.out.println("--------");
            }
            in.close();
            proc.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "ddsdffd";
    }
}

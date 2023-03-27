package com.example.tools.task;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling  //开启定时任务
public class TestTask {

    @Scheduled(cron = "0/1 * * * * ?")
    public void test() {

        System.out.println("hello" + System.currentTimeMillis());
    }
}

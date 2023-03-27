package com.example.tools.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AsyncService {

    @Async
    public void test() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Async " + System.currentTimeMillis());
    }
}

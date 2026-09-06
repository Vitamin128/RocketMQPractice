package com.example.rocketmq.controller;


import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestController
@RequestMapping("/mq")
public class RocketMQController {

    private final RocketMQTemplate rocketMQTemplate;

    RocketMQController(RocketMQTemplate rocketMQTemplate)
    {
        this.rocketMQTemplate=rocketMQTemplate;
    }

    @GetMapping("/send")
    public String Send()
    {
        rocketMQTemplate.convertAndSend(
                "test-topic",
                "Hello,RocketMQ"
        );
        return "发送成功";
    }
}

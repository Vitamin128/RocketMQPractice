package com.example.rocketmq.controller;


import com.example.rocketmq.dao.User;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
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
        User user=new User();
        user.setId(10);
        user.setName("2415");
        user.setScore(10);

        rocketMQTemplate.syncSend("test-topic:PAY", MessageBuilder.withPayload(user).build(),3000,2);
        return "发送成功";
    }
}

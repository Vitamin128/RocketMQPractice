package com.example.rocketmq.controller;


import com.example.rocketmq.dao.User;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.common.message.MessageConst;
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

        for(int i=0;i<5;i++)
        {
            user.setTime(i);
            rocketMQTemplate.syncSend("test-topic:PAY", MessageBuilder.withPayload(user).build(),3000,2);
        }
        return "发送成功";
    }

    @GetMapping("/sendKey")
    public String SendKey()
    {
        Message<String>message=MessageBuilder.withPayload("hello-key-test")
                .setHeader(MessageConst.PROPERTY_KEYS,"ORDER-1001")
                .build();
        SendResult result=new SendResult();
        int count=10000;
        while((count--)!=0)
        {
            result=rocketMQTemplate.syncSend("key_test_20261007",message);
        }
        if(result.getSendStatus().equals(SendStatus.SEND_OK))
        {
            return "Success";
        }
        return "FAIL";
    }
}

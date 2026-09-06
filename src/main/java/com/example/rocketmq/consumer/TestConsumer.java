package com.example.rocketmq.consumer;

import com.example.rocketmq.dao.User;
//import com.example.rocketmq.dao.user;
//import org.apache.catalina.User;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(topic = "test-topic",
        selectorExpression = "PAY",
        consumerGroup = "test-consumer-group")
public class TestConsumer implements RocketMQListener<User> {

    @Override
    public void onMessage(User user)
    {
        System.out.println(user);
    }

}

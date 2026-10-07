package com.example.rocketmq.consumer;
import com.example.rocketmq.dao.User;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(topic = "test-topic",
        selectorExpression = "PAY",
        consumerGroup = "test-consumer-group",
        messageModel=MessageModel.BROADCASTING)
public class TestConsumer_1 implements RocketMQListener<User> {

    @Override
    public void onMessage(User user)
    {
        System.out.println(user);
    }

}

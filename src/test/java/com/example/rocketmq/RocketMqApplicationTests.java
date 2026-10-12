package com.example.rocketmq;

import com.example.rocketmq.dao.User;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tools.jackson.databind.ObjectMapper;

import java.nio.charset.StandardCharsets;

@SpringBootTest
class RocketMqApplicationTests {

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void contextLoads() throws ClassNotFoundException, MQClientException {
//        DefaultMQProducer producer=new DefaultMQProducer("demo-producer-group");
//        producer.setNamesrvAddr("122.51.120.198:9876");
//        producer.start();
//        try {
//            Message message=new Message("key_test_20261007","hello".getBytes(StandardCharsets.UTF_8));
//            message.setKeys("ORDER-1001");
//            SendResult result=producer.send(message);
//            System.out.println("MessageQueue:"+result.getMessageQueue());
//            System.out.println("MsgId:"+result.getMsgId());
//            System.out.println("OffsetMsgId:"+result.getOffsetMsgId());
//            System.out.println("RecallHandle:"+result.getRecallHandle());
//            System.out.println("RegionId:"+result.getRegionId());
//
//        } catch (MQBrokerException | RemotingException | InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        finally {
//            producer.shutdown();
//        }
        User user=new User();
        user.setId(10);
        user.setName("2415");
        user.setScore(10);

        String JsonMessage= objectMapper.writeValueAsString(user);
        System.out.println(user);
        System.out.println(JsonMessage);
    }

}

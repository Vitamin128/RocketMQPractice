package com.example.rocketmq;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.charset.StandardCharsets;

@SpringBootTest
class RocketMqApplicationTests {

    @Test
    void contextLoads() throws ClassNotFoundException, MQClientException {
        DefaultMQProducer producer=new DefaultMQProducer("demo-producer-group");
        producer.setNamesrvAddr("122.51.120.198:9876");
        producer.start();
        try {
            Message message=new Message("key_test_20261007","hello".getBytes(StandardCharsets.UTF_8));
            message.setKeys("ORDER-1001");
            SendResult result=producer.send(message);
            System.out.println(result.getMessageQueue());
        } catch (MQBrokerException | RemotingException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            producer.shutdown();
        }
    }

}

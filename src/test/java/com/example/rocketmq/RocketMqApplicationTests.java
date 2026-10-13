package com.example.rocketmq;

import com.example.rocketmq.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RocketMqApplicationTests {

    @Autowired
    OrderService orderService;

    @Test
    void contextLoads(){
        System.out.println(orderService.pay());
    }

}

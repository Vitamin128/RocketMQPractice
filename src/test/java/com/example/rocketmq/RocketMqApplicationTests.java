package com.example.rocketmq;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

@SpringBootTest
class RocketMqApplicationTests {

    @Test
    void contextLoads() throws ClassNotFoundException {
        Class<?>clazz=Class.forName("com.example.rocketmq.dao.User");
        Field[]fields=clazz.getFields();
        Method[] methods=clazz.getMethods();
        System.out.println(Arrays.toString(methods));
        System.out.println(Arrays.toString(fields));
    }

}

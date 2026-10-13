package com.example.rocketmq.service;

import com.example.rocketmq.inter.PayService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final PayService payService;
    OrderService(WeChatService payServiceOut)
    {
        payService=payServiceOut;
    }
    public String pay()
    {
        return payService.pay();
    }
}

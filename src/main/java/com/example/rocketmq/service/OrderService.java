package com.example.rocketmq.service;

import com.example.rocketmq.inter.PayService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
//    @Autowired
//    private PayService payService;

    @Resource(name="weChatService")
    private PayService payService;

    public String pay()
    {
        return payService.pay();
    }
}

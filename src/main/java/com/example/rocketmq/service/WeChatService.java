package com.example.rocketmq.service;

import com.example.rocketmq.inter.PayService;
import org.springframework.stereotype.Service;

@Service("weChatService")
public class WeChatService implements PayService {
    public String pay()
    {
        return "WeChatService";
    }
}

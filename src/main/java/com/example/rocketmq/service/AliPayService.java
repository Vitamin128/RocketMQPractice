package com.example.rocketmq.service;

import com.example.rocketmq.inter.PayService;
import org.springframework.stereotype.Service;

@Service("aliPayService")
public class AliPayService implements PayService {
    @Override
    public String pay()
    {
        return "支付宝支付";
    }
}

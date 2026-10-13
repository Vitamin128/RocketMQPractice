package com.example.rocketmq.service;

import com.example.rocketmq.inter.PayService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service("aliPayService")
@Qualifier("mobile")
public class AliPayService implements PayService {
    @Override
    public String pay()
    {
        return "支付宝支付";
    }
}

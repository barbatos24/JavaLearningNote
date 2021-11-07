package com.russellzhou.javalearningnote.redis.controller;

import com.russellzhou.javalearningnote.redis.Exception.CongestionException;
import com.russellzhou.javalearningnote.redis.service.DistributeLockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DistributeLockController {

    @Autowired
    private DistributeLockService distributeLockService;

    @RequestMapping("/select_info.do")
    public String select_info(String product_id) {
        return distributeLockService.select_info(product_id);
    }
    @RequestMapping("/order.do")
    public String order(String product_id) throws CongestionException {
        //模拟无同步机制的情况
        //return distributeLockService.order1(product_id);

        //模拟加了synchronized的情况
        //return distributeLockService.order2(product_id);

        //模拟加了分布式锁的情况
        return distributeLockService.order3(product_id);
    }

}

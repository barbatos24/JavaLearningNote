package com.russellzhou.javalearningnote.redis.service;

import com.russellzhou.javalearningnote.redis.Exception.CongestionException;
import com.russellzhou.javalearningnote.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class DistributeLockService {

    private static Logger logger = LoggerFactory.getLogger(DistributeLockService.class);

    @Autowired
    private RedisLock redisLock;
    //商品详情
    private static HashMap<String, Integer> product = new HashMap();
    //订单表
    private static HashMap<String, String> orders = new HashMap();
    //库存表
    private static HashMap<String, Integer> stock = new HashMap();

    static {
        product.put("123", 10000);
        stock.put("123", 10000);
    }

    public String select_info(String product_id) {
        return "限量抢购商品123共" + product.get(product_id) + ",现在成功下单" + orders.size()
                + ",剩余库存" + stock.get(product_id) + "件";
    }

    /**
     * 下单
     * 任何同步机制都不做，明显会产生超卖现象
     * @param product_id
     * @return
     */
    public String order1(String product_id) {
        if (stock.get(product_id) == 0) {
            return "活动已经结束了";
            //已近买完了
        } else {
            //还没有卖完
            try {
                //模拟操作数据库
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            orders.put(StringUtil.getuuid(), product_id);
            stock.put(product_id, stock.get(product_id) - 1);
            logger.info("当前已累计{}笔订单,剩余库存还剩{}",orders.size(),stock.get(product_id));
        }
        return select_info(product_id);
    }

    /**
     * 下单
     * 加了synchronized锁强行进行同步，唯一的缺点就是性能消耗变得更多，响应时间延长
     * @param product_id
     * @return
     */
    public synchronized String order2(String product_id) {
        if (stock.get(product_id) == 0) {
            return "活动已经结束了";
            //已近买完了
        } else {
            //还没有卖完
            try {
                //模拟操作数据库
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            orders.put(StringUtil.getuuid(), product_id);
            stock.put(product_id, stock.get(product_id) - 1);
            logger.info("当前已累计{}笔订单,剩余库存还剩{}",orders.size(),stock.get(product_id));
        }
        return select_info(product_id);
    }

    /**
     * 高并发没问题，效率还行
     *
     * @param product_id
     * @return
     */
    public String order3(String product_id) throws CongestionException {
        /**
         * redis加锁
         */
        String value = System.currentTimeMillis() + 10000 + "";
        if (!redisLock.lock1(product_id, value)) {
            //系统繁忙，请稍后再试
            throw new CongestionException();
        }
        if (stock.get(product_id) == 0) {
            return "活动已经结束了";
            //已近买完了
        } else {
            //还没有卖完
            try {
                //模拟操作数据库
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            orders.put(StringUtil.getuuid(), product_id);
            stock.put(product_id, stock.get(product_id) - 1);
            logger.info("当前已累计{}笔订单,剩余库存还剩{}",orders.size(),stock.get(product_id));
        }
        /**
         * redis解锁
         */
        redisLock.unlock(product_id, value);
        return select_info(product_id);
    }

}

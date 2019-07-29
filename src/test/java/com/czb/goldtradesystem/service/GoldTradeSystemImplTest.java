package com.czb.goldtradesystem.service;

import com.czb.goldtradesystem.GoldTradeSystemApplication;
import com.czb.goldtradesystem.api.in.*;
import com.czb.goldtradesystem.api.out.*;
import com.czb.goldtradesystem.model.QueryAllTradeRecordResponse;
import com.czb.goldtradesystem.model.UserInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
//import redis.clients.jedis.Jedis;
//
//import javax.annotation.Resource;
import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoldTradeSystemImplTest {
    private static final Logger log = LogManager.getLogger();

    @Autowired
    private GoldTradeSystemImpl goldTradeSystem;

    @Test
    public void validLogin() {
        ValidLoginIn in = new ValidLoginIn();
        in.setPassword("123456");
        in.setUserName("灿包");
        ValidLoginOut out = new ValidLoginOut();
        out = goldTradeSystem.validLogin(in);
        System.out.println("haha-------------------"+out);
        log.error("----------------------out={}-----------------------",out);
    }

    @Test
    public void queryAllProductInfo() {
    }

    @Test
    public void purchaseGoldOut() {
        PurchaseGoldIn in = new PurchaseGoldIn();
        in.setIdCardNum("33022619940707xxxx");
        in.setPurchaseAmount(new BigDecimal("2"));
        in.setProductType("1");
        PurchaseGoldOut out = goldTradeSystem.purchaseGold(in);
        log.info("{}",out.toString());
    }

    @Test
    public void sellGold() {
        SellGoldIn in = new SellGoldIn();
        in.setIdCardNum("33022619940707xxxx");
        in.setSellAmount(new BigDecimal("2"));
        in.setProductType("1");
        SellGoldOut out = goldTradeSystem.sellGold(in);
        log.info("{}", out.getErrCode());
    }
    @Test
    public void queryPurchaseGoldInfo() {
        PurchaseGoldInfoIn in = new PurchaseGoldInfoIn();
        in.setIdCardNum("33022619940707xxxx");
        in.setProductType("1");
        PurchaseGoldInfoOut out = goldTradeSystem.purchaseGoldInfo(in);
        log.info("{}",out.getGoldPurchaseInfoList().toString());
    }
    @Test
    //卖出信息测试
    public void querySellGoldInfo() {
        SellGoldInfoIn in = new SellGoldInfoIn();
        in.setIdCardNum("33022619940707xxxx");

        SellGoldInfoOut out = goldTradeSystem.sellGoldInfo(in);
        log.info("{}", out.getGoldSellInfoList().toString());
    }
    @Test
    //用户信息查询
    public void testQueryUserInfo() {
        UserInfoIn in = new UserInfoIn();

        in.setIdCardNum("33022619940707xxxx");

        UserInfoOut out = goldTradeSystem.queryUserInfo(in);
        log.info("{}", out.getUserInfoList().toString());
    }
    @Test
    //买入记录查询控制
    public void testQueryPurchaseRecord() {
        PurchaseGoldInfoIn in = new PurchaseGoldInfoIn();

        in.setIdCardNum("33022619940707xxxx");
        in.setProductType("1");

        PurchaseGoldInfoOut out = goldTradeSystem.purchaseGoldInfo(in);
        log.info("{}", out.toString());
    }
    @Test
    //卖出记录查询控制
    public void testQuerySellRecord() {
        SellGoldInfoIn in = new SellGoldInfoIn();

        in.setIdCardNum("33022619940707xxxx");
        in.setProductType("1");

       SellGoldInfoOut out = goldTradeSystem.sellGoldInfo(in);
        log.info("{}", out.toString());
    }

    @Test
    public void queryUserAllTradeInfo() {
        UserAllTradeInfoIn in = new UserAllTradeInfoIn();
        in.setIdCardNum("33022619940707xxxx");
        //in.setProductType("1");

        UserAllTradeInfoOut out = goldTradeSystem.queryUserAllTradeInfo(in);
        log.info("{}", out.toString());

    }

    @Test
    public void queryUserHoldInfo() {
        QueryUserHoldInfoIn in = new QueryUserHoldInfoIn();
        in.setIdCardNum("33022619940707xxxx");
        QueryUserHoldInfoOut out = goldTradeSystem.queryUserHoldInfo(in);
        log.info("out={}", out.toString());
    }
//    @Test
//    public void redisTester() {
//        Jedis jedis = new Jedis("localhost", 6379, 100000);
//        int i = 0;
//        try {
//            long start = System.currentTimeMillis();// 开始毫秒数
//            while (true) {
//                long end = System.currentTimeMillis();
//                if (end - start >= 1000) {// 当大于等于1000毫秒（相当于1秒）时，结束操作
//                    break;
//                }
//                i++;
//                jedis.set("test" + i, i + "");
//            }
//        } finally {// 关闭连接
//            jedis.close();
//        }
//        // 打印1秒内对Redis的操作次数
//        System.out.println("redis每秒操作：" + i + "次");
//    }

    @Test
    public void balanceInfo() {
        BalanceInfoIn  in = new BalanceInfoIn();
        in.setIdCardNum("33022619940707xxxx");
        BalanceInfoOut out = goldTradeSystem.balanceInfo(in);
        log.info("out={}", out.toString());
    }
}
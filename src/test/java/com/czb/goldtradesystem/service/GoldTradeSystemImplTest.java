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

import javax.annotation.Resource;

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
        in.setPurchaseAmount("2");
        in.setProductType("1");
        PurchaseGoldOut out = goldTradeSystem.purchaseGold(in);
        log.info("{}",out.toString());
    }

    @Test
    public void sellGold() {
        SellGoldIn in = new SellGoldIn();
        in.setIdCardNum("33022619940707xxxx");
        in.setSellAmount("2");
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
        in.setProductType("1");

        UserAllTradeInfoOut out = goldTradeSystem.queryUserAllTradeInfo(in);
        log.info("{}", out.toString());

    }
}
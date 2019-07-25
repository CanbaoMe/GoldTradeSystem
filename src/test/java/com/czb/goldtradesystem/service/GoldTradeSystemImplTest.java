package com.czb.goldtradesystem.service;

import com.czb.goldtradesystem.GoldTradeSystemApplication;
import com.czb.goldtradesystem.api.in.PurchaseGoldIn;
import com.czb.goldtradesystem.api.in.SellGoldIn;
import com.czb.goldtradesystem.api.in.ValidLoginIn;
import com.czb.goldtradesystem.api.out.PurchaseGoldOut;
import com.czb.goldtradesystem.api.out.SellGoldOut;
import com.czb.goldtradesystem.api.out.ValidLoginOut;
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
}
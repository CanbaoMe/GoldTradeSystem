package com.czb.goldtradesystem.controller;

import com.czb.goldtradesystem.api.in.SellGoldIn;
import com.czb.goldtradesystem.api.out.SellGoldOut;
import com.czb.goldtradesystem.model.SellRequest;
import com.czb.goldtradesystem.model.SellResponse;
import com.czb.goldtradesystem.service.GoldTradeSystemImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class SellGoldController extends BaseController{
    @Autowired
    GoldTradeSystemImpl goldTradeSystem;

    @PostMapping("/sell")
    public SellResponse sell(@RequestBody @Valid SellRequest sellRequest){
        SellResponse sellResponse =new SellResponse();
        logger.info(sellRequest.getIdCardNum());
        SellGoldIn in = new SellGoldIn();
        in.setProductType(sellRequest.getProductType());
        in.setSellAmount(sellRequest.getSellAmount());
        in.setIdCardNum(sellRequest.getIdCardNum());
        SellGoldOut out = new SellGoldOut();
        try{
            out = goldTradeSystem.sellGold(in);
        }catch (Exception e){
            logger.error("卖出黄金发生错误",e);
            throw e;
        }
        sellResponse.setErrCode(out.getErrCode());
        sellResponse.setErrMsg(out.getErrMsg());
        return sellResponse;
    }
}

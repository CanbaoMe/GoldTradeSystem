package com.czb.goldtradesystem.controller;

import com.czb.goldtradesystem.api.BizException;
import com.czb.goldtradesystem.api.in.SellGoldInfoIn;
import com.czb.goldtradesystem.api.out.SellGoldInfoOut;
import com.czb.goldtradesystem.mapper.GoldSellInfoMapper;
import com.czb.goldtradesystem.model.QueryRecordRequest;
import com.czb.goldtradesystem.model.QueryRecordResponse;
import com.czb.goldtradesystem.service.GoldTradeSystemImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.apache.logging.log4j.LogManager;
import  org.apache.logging.log4j.Logger;
import javax.annotation.Resource;
import javax.validation.Valid;

public class SellQueryRecController extends BaseController{

    private static final Logger log = LogManager.getLogger();

    @Autowired
    GoldTradeSystemImpl goldTradeSystem;
    @Resource
    private GoldSellInfoMapper goldSellInfoMapper;
    @PostMapping("/querysellrecord")
    public QueryRecordResponse sellqueryrecord(@RequestBody @Valid QueryRecordRequest sellqueryRecordRequest){

        logger.info(sellqueryRecordRequest.getIdCardNum());
        QueryRecordResponse sellQueryRecordResponse = new QueryRecordResponse();
        SellGoldInfoIn in = new SellGoldInfoIn();
        in.setIdCardNum(sellqueryRecordRequest.getIdCardNum());
        in.setProductType(sellqueryRecordRequest.getProductType());
        SellGoldInfoOut out = new SellGoldInfoOut();
        try{
            out = goldTradeSystem.sellGoldInfo(in);
        }catch(Exception e){
            log.error(e.getMessage(),e);
            throw  e;

        }
        sellQueryRecordResponse.setProductType(out.getProductType());
        sellQueryRecordResponse.setSellAmount(out.getSellAmount());
        sellQueryRecordResponse.setEarnMoney(out.getEarnMoney());
        sellQueryRecordResponse.setOprTime(out.getOprTime());
        return sellQueryRecordResponse;

    }

}

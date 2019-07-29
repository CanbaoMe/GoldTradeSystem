package com.czb.goldtradesystem.controller;

import com.czb.goldtradesystem.api.in.SellGoldInfoIn;
import com.czb.goldtradesystem.api.out.SellGoldInfoOut;
import com.czb.goldtradesystem.mapper.GoldSellInfoMapper;
import com.czb.goldtradesystem.model.QuerySellRecordRequest;
import com.czb.goldtradesystem.model.QuerySellRecordResponse;
import com.czb.goldtradesystem.service.GoldTradeSystemImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.apache.logging.log4j.LogManager;
import  org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
public class QuerySellRecordController extends BaseController{

    private static final Logger log = LogManager.getLogger();

    @Autowired
    GoldTradeSystemImpl goldTradeSystem;
    @Resource
    private GoldSellInfoMapper goldSellInfoMapper;
    @PostMapping("/querysellrecord")
    public QuerySellRecordResponse querySellRecord(@RequestBody @Valid QuerySellRecordRequest querySellRecordRequest){
        logger.info(querySellRecordRequest.getIdCardNum());
        QuerySellRecordResponse querySellRecordResponse = new QuerySellRecordResponse();
        SellGoldInfoIn in = new SellGoldInfoIn();
        in.setIdCardNum(querySellRecordRequest.getIdCardNum());
        in.setProductType(querySellRecordRequest.getProductType());
        SellGoldInfoOut out = new SellGoldInfoOut();
        try{
            out = goldTradeSystem.sellGoldInfo(in);
            logger.info("out={}",out);
        }catch(Exception e){
            log.error(e.getMessage(),e);
            throw  e;
        }
        querySellRecordResponse.setGoldSellInfoList(out.getGoldSellInfoList());
        querySellRecordResponse.setErrCode(out.getErrCode());
        querySellRecordResponse.setErrMsg(out.getErrMsg());
        return querySellRecordResponse;
    }
}

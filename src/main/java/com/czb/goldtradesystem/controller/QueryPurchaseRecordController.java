package com.czb.goldtradesystem.controller;

import com.czb.goldtradesystem.api.BizException;

import com.czb.goldtradesystem.api.in.PurchaseGoldInfoIn;
import com.czb.goldtradesystem.api.out.PurchaseGoldInfoOut;

import com.czb.goldtradesystem.mapper.GoldPurchaseInfoMapper;

import com.czb.goldtradesystem.model.*;
import com.czb.goldtradesystem.service.GoldTradeSystemImpl;
import jdk.internal.util.xml.PropertiesDefaultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import  org.apache.logging.log4j.Logger;


/**
 * @author wms bd
 */
@RestController
public class QueryRecordController extends BaseController {
    private static final Logger log = LogManager.getLogger();

    @Autowired
    GoldTradeSystemImpl goldTradeSystem;

    @Resource
    private GoldPurchaseInfoMapper goldPurchaseInfoMapper;

    @PostMapping("/queryPurchaseRecord")
    public QueryRecordResponse queryrecord(@RequestBody @Valid QueryRecordRequest queryRecordRequest){

        logger.info(queryRecordRequest.getIdCardNum());
        QueryRecordResponse queryRecordResponse = new QueryRecordResponse();
        PurchaseGoldInfoIn in_p = new PurchaseGoldInfoIn();
        in_p.setIdCardNum(queryRecordRequest.getIdCardNum());
        in_p.setProductType(queryRecordRequest.getProductType());
        PurchaseGoldInfoOut out_p = new PurchaseGoldInfoOut();
        try{
             out_p = goldTradeSystem.purchaseGoldInfo(in_p);
        }catch (Exception e){
            log.error(e.getMessage(),e);
            throw e;
        }
        queryRecordResponse.setProductType(out_p.getProductType());
        queryRecordResponse.setPurchaseAmount(out_p.getPurchaseAmount());
        queryRecordResponse.setUesdMoney(out_p.getUesdMoney());
        queryRecordResponse.setOprTime(out_p.getOprTime());
        queryRecordResponse.setErrCode(out_p.getErrCode());
        return queryRecordResponse;
    }

}
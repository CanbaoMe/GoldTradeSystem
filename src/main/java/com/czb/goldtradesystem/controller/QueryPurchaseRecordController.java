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
public class QueryPurchaseRecordController extends BaseController {
    private static final Logger log = LogManager.getLogger();

    @Autowired
    GoldTradeSystemImpl goldTradeSystem;

    @Resource
    private GoldPurchaseInfoMapper goldPurchaseInfoMapper;

    @PostMapping("/queryPurchaseRecord")
    public QueryRecordResponse queryrecord(@RequestBody @Valid QueryRecordRequest queryPurchaseRecordRequest){

        logger.info(queryPurchaseRecordRequest.getIdCardNum());
        QueryRecordResponse queryRecordResponse = new QueryRecordResponse();
        PurchaseGoldInfoIn in = new PurchaseGoldInfoIn();
        in.setIdCardNum(queryPurchaseRecordRequest.getIdCardNum());
        in.setProductType(queryPurchaseRecordRequest.getProductType());
        PurchaseGoldInfoOut out = new PurchaseGoldInfoOut();
        try{
            out = goldTradeSystem.purchaseGoldInfo(in);
        }catch (Exception e){
            log.error(e.getMessage(),e);
            throw e;
        }
        queryRecordResponse.setProductType(out.getProductType());
        queryRecordResponse.setPurchaseAmount(out.getPurchaseAmount());
        queryRecordResponse.setUesdMoney(out.getUesdMoney());
        queryRecordResponse.setOprTime(out.getOprTime());
        queryRecordResponse.setErrCode(out.getErrCode());
        return queryRecordResponse;
    }
}
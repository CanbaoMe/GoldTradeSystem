package com.czb.goldtradesystem.controller;

import com.czb.goldtradesystem.api.in.UserAllTradeInfoIn;
import com.czb.goldtradesystem.api.out.UserAllTradeInfoOut;
import com.czb.goldtradesystem.model.QueryAllTradeRecordRequest;
import com.czb.goldtradesystem.model.QueryAllTradeRecordResponse;
import com.czb.goldtradesystem.service.GoldTradeSystemImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class QueryAllTradeRecordController extends BaseController{
    private static final Logger log = LogManager.getLogger();

    @Autowired
    GoldTradeSystemImpl goldTradeSystem;

    @PostMapping("/queryAllTradeRecord")
    public QueryAllTradeRecordResponse queryAllTradeRecord(@RequestBody @Valid QueryAllTradeRecordRequest queryAllTradeRecordRequest ){
        QueryAllTradeRecordResponse queryAllTradeRecordResponse = new QueryAllTradeRecordResponse();
        UserAllTradeInfoIn in = new UserAllTradeInfoIn();
        in.setIdCardNum(queryAllTradeRecordRequest.getIdCardNum());
       // in.setProductType(queryAllTradeRecordRequest.getProductType());
        UserAllTradeInfoOut out = new UserAllTradeInfoOut();
        try{
            out = goldTradeSystem.queryUserAllTradeInfo(in);
        }catch (Exception e){
            log.error(e.getMessage(),e);
            throw e;
        }
        logger.info("getAllUserInfoList={}",out.getAllUserInfoList());
        queryAllTradeRecordResponse.setAllUserInfoList(out.getAllUserInfoList());
        queryAllTradeRecordResponse.setErrCode(out.getErrCode());
        queryAllTradeRecordResponse.setErrMsg(out.getErrMsg());

        return  queryAllTradeRecordResponse;
    }
}

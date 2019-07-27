package com.czb.goldtradesystem.controller;

import com.czb.goldtradesystem.api.in.QueryUserHoldInfoIn;
import com.czb.goldtradesystem.api.out.QueryUserHoldInfoOut;
import com.czb.goldtradesystem.service.GoldTradeSystemImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class QueryUserHoldRecordController extends BaseController{
    private static final Logger log = LogManager.getLogger();
    @Autowired
    GoldTradeSystemImpl goldTradeSystem;

    @PostMapping("/queryUserHoldRecord")
    public QueryUserHoldInfoOut queryUserHoldRecord(@RequestBody @Valid QueryUserHoldInfoIn queryUserHoldInfoIn){
        logger.info("用户查询功能");
        QueryUserHoldInfoOut out = new QueryUserHoldInfoOut();
        try{
            out = goldTradeSystem.queryUserHoldInfo(queryUserHoldInfoIn);
            logger.info("out={}",out);
        }catch(Exception e){
            log.error(e.getMessage(),e);
            throw  e;
        }
        return out;
    }


}

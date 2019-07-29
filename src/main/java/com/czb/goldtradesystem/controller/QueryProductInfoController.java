package com.czb.goldtradesystem.controller;

import com.czb.goldtradesystem.model.GoldProductInfo;
import com.czb.goldtradesystem.model.QueryAllTradeRecordResponse;
import com.czb.goldtradesystem.service.GoldTradeSystemImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QueryProductInfoController extends BaseController{
    private static final Logger log = LogManager.getLogger();

    @Autowired
    GoldTradeSystemImpl goldTradeSystem;

    @GetMapping("/queryProductInfo")
    public List<GoldProductInfo> queryProductInfo(){
        List<GoldProductInfo> goldProductInfoList = goldTradeSystem.queryAllProductInfo();
        return  goldProductInfoList;
    }
}

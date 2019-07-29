package com.czb.goldtradesystem.controller;

import com.czb.goldtradesystem.api.in.BalanceInfoIn;
import com.czb.goldtradesystem.api.out.BalanceInfoOut;
import com.czb.goldtradesystem.mapper.UserInfoMapper;
import com.czb.goldtradesystem.mapper.UserInfoMapper;
import com.czb.goldtradesystem.model.BalanceInfoRequest;
import com.czb.goldtradesystem.model.BalanceInfoResponse;
import com.czb.goldtradesystem.service.GoldTradeSystemImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class BalanceInfoController extends BaseController{
    private static final Logger log = LogManager.getLogger();

    @Autowired
    GoldTradeSystemImpl goldTradeSystem;



    @PostMapping("/querybalance")
    public BalanceInfoResponse balanceInfoResponse(@RequestBody @Valid BalanceInfoRequest balanceInfoRequest){
        logger.info(balanceInfoRequest.getIdCardNum());
        BalanceInfoResponse balanceInfoResponse = new BalanceInfoResponse();
        BalanceInfoIn in = new BalanceInfoIn();
        in.setIdCardNum(balanceInfoRequest.getIdCardNum());
        BalanceInfoOut out = new BalanceInfoOut();
        try{
            out = goldTradeSystem.balanceInfo(in);
        }catch (Exception e){
            log.error(e.getMessage(),e);
            throw e;
        }
        balanceInfoResponse.setErrMsg(out.getErrMsg());
        balanceInfoResponse.setErrCode(out.getErrCode());
        balanceInfoResponse.setBalance(out.getBalance());
        return balanceInfoResponse;
    }
}

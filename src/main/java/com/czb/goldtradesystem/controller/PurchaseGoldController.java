package com.czb.goldtradesystem.controller;

import com.czb.goldtradesystem.api.in.PurchaseGoldIn;
import com.czb.goldtradesystem.api.out.PurchaseGoldOut;
import com.czb.goldtradesystem.model.PurchaseReponse;
import com.czb.goldtradesystem.model.PurchaseRequest;
import com.czb.goldtradesystem.model.QueryRecordResponse;
import com.czb.goldtradesystem.service.GoldTradeSystemImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author crc
 */
@RestController
public class PurchaseGoldController extends BaseController{

    @Autowired
    GoldTradeSystemImpl goldTradeSystem;

    @PostMapping("/purchase")
    public PurchaseReponse purchase(@RequestBody @Valid PurchaseRequest purchaseRequest){
        logger.info(purchaseRequest.getIdCardNum());
        PurchaseReponse purchaseReponse = new PurchaseReponse();
        PurchaseGoldIn in = new PurchaseGoldIn();
        in.setIdCardNum(purchaseRequest.getIdCardNum());
        in.setProductType(purchaseRequest.getProductType());
        in.setPurchaseAmount(purchaseRequest.getPurchaseAmount());
        PurchaseGoldOut out = new PurchaseGoldOut();
        try{
                out = goldTradeSystem.purchaseGold(in);
        }catch (Exception e){
            logger.error("购买黄金发生错误",e);
            throw e;
        }

        purchaseReponse.setErrCode(out.getErrCode());
        purchaseReponse.setErrMsg(out.getErrMsg());

        return  purchaseReponse;
    }
}

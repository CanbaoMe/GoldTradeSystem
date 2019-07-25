package com.czb.goldtradesystem.service;

import com.czb.goldtradesystem.api.in.PurchaseGoldIn;
import com.czb.goldtradesystem.api.in.SellGoldIn;
import com.czb.goldtradesystem.api.in.ValidLoginIn;
import com.czb.goldtradesystem.api.out.PurchaseGoldOut;
import com.czb.goldtradesystem.api.out.SellGoldOut;
import com.czb.goldtradesystem.api.out.ValidLoginOut;
import com.czb.goldtradesystem.model.GoldProductInfo;

import java.util.List;


public interface GoldTradeSystem {
    //private static final long serialVersionUID = 1L;

    /**
     * 登入校验
     * @param in
     * @return
     */
    public ValidLoginOut validLogin(ValidLoginIn in);

    /**
     * 查询所有产品信息
     * @return
     */
    public List<GoldProductInfo> queryAllProductInfo();

    /**
     * 购买黄金功能
     * @param in
     * @return
     */
    public PurchaseGoldOut purchaseGold(PurchaseGoldIn in);

    /**
     * 卖出黄金功能
     * @param in
     * @return
     */
    public SellGoldOut sellGold(SellGoldIn in );

}

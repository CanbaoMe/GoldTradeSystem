package com.czb.goldtradesystem.service;

import com.czb.goldtradesystem.api.in.*;
import com.czb.goldtradesystem.api.out.*;


import com.czb.goldtradesystem.model.GoldProductInfo;
import com.czb.goldtradesystem.model.UserInfo;


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
     *      * 购买黄金功能
     *      * @param in
     *      * @return
     */
    public PurchaseGoldOut purchaseGold(PurchaseGoldIn in);

    /**
     * 查询购买信息
     * @param in
     * @return 购买信息(list)
     */
    public PurchaseGoldInfoOut purchaseGoldInfo(PurchaseGoldInfoIn in);

    /**
     * 卖出黄金功能
     * @param in
     * @return
     */

    public SellGoldOut sellGold(SellGoldIn in );
    /**
     * 卖出黄金信息
     * @param in
     * @return
     */
    public SellGoldInfoOut sellGoldInfo(SellGoldInfoIn in );

    /**
     * 查询用户所有信息
     * @param in
     * @return 所有信息
     */
    public UserInfoOut queryUserInfo(UserInfoIn in );

    /**
     * 查询用户所有交易信息
     * @param in
     * @return 所有信息
     */
    public UserAllTradeInfoOut queryUserAllTradeInfo(UserAllTradeInfoIn in );

    /**
     * 查询用户持仓信息
     * @param in
     * @return 所有信息
     */
    public QueryUserHoldInfoOut  queryUserHoldInfo(QueryUserHoldInfoIn in);

    /**
     * 查询余额
     * @param in
     * @return
     */
    public BalanceInfoOut balanceInfo(BalanceInfoIn in);

}

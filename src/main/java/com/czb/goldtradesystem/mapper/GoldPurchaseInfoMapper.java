package com.czb.goldtradesystem.mapper;

import com.czb.goldtradesystem.model.GoldPurchaseInfo;
import tk.mybatis.mapper.common.Mapper;

public interface GoldPurchaseInfoMapper extends Mapper<GoldPurchaseInfo> {
    int deleteByPrimaryKey(Integer id);

    GoldPurchaseInfo selectByPrimaryKey(Integer id);

}
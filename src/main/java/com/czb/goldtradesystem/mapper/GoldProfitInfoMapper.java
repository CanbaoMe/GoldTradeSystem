package com.czb.goldtradesystem.mapper;

import com.czb.goldtradesystem.model.GoldProfitInfo;
import tk.mybatis.mapper.common.Mapper;

public interface GoldProfitInfoMapper extends Mapper<GoldProfitInfo> {
    int deleteByPrimaryKey(String idCard);

    GoldProfitInfo selectByPrimaryKey(String idCard);
}
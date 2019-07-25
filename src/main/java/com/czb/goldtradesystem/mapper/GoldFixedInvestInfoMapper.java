package com.czb.goldtradesystem.mapper;

import com.czb.goldtradesystem.model.GoldFixedInvestInfo;
import tk.mybatis.mapper.common.Mapper;

public interface GoldFixedInvestInfoMapper extends Mapper<GoldFixedInvestInfo> {
    int deleteByPrimaryKey(String idCard);

    GoldFixedInvestInfo selectByPrimaryKey(String idCard);
}
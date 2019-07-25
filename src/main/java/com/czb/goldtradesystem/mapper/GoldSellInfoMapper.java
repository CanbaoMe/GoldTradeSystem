package com.czb.goldtradesystem.mapper;

import com.czb.goldtradesystem.model.GoldSellInfo;
import tk.mybatis.mapper.common.Mapper;

public interface GoldSellInfoMapper extends Mapper<GoldSellInfo> {
    int deleteByPrimaryKey(Integer id);

    GoldSellInfo selectByPrimaryKey(Integer id);
}
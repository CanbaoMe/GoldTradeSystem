package com.czb.goldtradesystem.mapper;

import com.czb.goldtradesystem.model.GoldPriceInfo;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.math.BigDecimal;

public interface GoldPriceInfoMapper extends Mapper<GoldPriceInfo> {
    @Select("select gold_price from gold_price_info where time = #{date}")
    BigDecimal getGoldPrice(String date);

    int deleteByPrimaryKey(Integer id);

    GoldPriceInfo selectByPrimaryKey(Integer id);

}
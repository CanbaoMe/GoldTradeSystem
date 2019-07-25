package com.czb.goldtradesystem.mapper;

import com.czb.goldtradesystem.model.GoldProductInfo;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface GoldProductInfoMapper extends Mapper<GoldProductInfo> {

    @Select("select * from gold_product_info")
    List<GoldProductInfo> queryAllProductInfo();

    int deleteByPrimaryKey(String productType);

    GoldProductInfo selectByPrimaryKey(String productType);

}
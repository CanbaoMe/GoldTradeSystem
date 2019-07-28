package com.czb.goldtradesystem.mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import com.czb.goldtradesystem.model.GoldHoldInfo;


public interface GoldHoldInfoMapper extends Mapper<GoldHoldInfo> {

    @Select("select * from gold_hold_info where id_card=#{idCard} and product_type = #{productType}")
     public GoldHoldInfo selectByIdAndType(@Param("idCard") String idCard, @Param("productType") String productType);
}
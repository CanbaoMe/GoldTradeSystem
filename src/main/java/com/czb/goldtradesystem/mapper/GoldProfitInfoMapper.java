package com.czb.goldtradesystem.mapper;

import com.czb.goldtradesystem.model.GoldProfitInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.math.BigDecimal;

public interface GoldProfitInfoMapper extends Mapper<GoldProfitInfo> {
    int deleteByPrimaryKey(String idCard);

    GoldProfitInfo selectByPrimaryKey(String idCard);

    @Update("update gold_profit_info set yesterday_profit=#{yesterdayProfit},total_profit=#{totalProfit},opr_time=#{oprTime} where id_card = #{idCard} and product_type = #{productType}")
    int updateByIdCardAndType(@Param("yesterdayProfit") BigDecimal yesterdayProfit,@Param("totalProfit") BigDecimal totalProfit,@Param("oprTime") String oprTime,@Param("productType") String productType,@Param("idCard") String idCard);

}
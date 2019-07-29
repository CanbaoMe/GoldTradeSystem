package com.czb.goldtradesystem.controller;

import com.czb.goldtradesystem.mapper.UserInfoMapper;
import com.czb.goldtradesystem.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@RestController
public class EverydayProfitController extends BaseController{

    @Resource
    UserInfoMapper userInfoMapper;

    @GetMapping("/everydayProfitController")
    public int calEverydayProfit(){
        List<UserInfo> userInfoList = userInfoMapper.selectAll();
        try {
            for(UserInfo userInfo : userInfoList){
                BigDecimal balance = userInfo.getBalance();
                logger.info("余额={}",balance);
                if(balance.compareTo(new BigDecimal(0)) != 0 ){
                    BigDecimal yesterdayProfit = balance.multiply(new BigDecimal(0.026));
                    logger.info("昨日收益={}",yesterdayProfit);
                    BigDecimal totalPrifit;
                    if(userInfo.getTotalBalanceProfit() != null)
                    {
                        totalPrifit = yesterdayProfit.add(userInfo.getTotalBalanceProfit());
                    }else{
                        totalPrifit= yesterdayProfit;
                    }
                    userInfo.setYesterdayBalanceProfit(yesterdayProfit);
                    userInfo.setTotalBalanceProfit(totalPrifit);
                    userInfoMapper.updateByPrimaryKey(userInfo);
                }
            }
        }catch (Exception e){
            logger.error("每日余额利润跑批发生错误",e);
            throw e;
        }
        return 200;
    }
}

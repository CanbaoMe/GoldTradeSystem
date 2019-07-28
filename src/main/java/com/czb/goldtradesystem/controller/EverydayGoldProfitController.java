package com.czb.goldtradesystem.controller;

import com.czb.goldtradesystem.mapper.*;
import com.czb.goldtradesystem.model.GoldHoldInfo;
import com.czb.goldtradesystem.model.GoldProfitInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
public class EverydayGoldProfitController extends BaseController{
    @Resource
    UserInfoMapper userInfoMapper;
    @Resource
    GoldHoldInfoMapper goldHoldInfoMapper;
    @Resource
    GoldProfitInfoMapper goldProfitInfoMapper;
    @Resource
    GoldProductInfoMapper goldProductInfoMapper;
    @Resource
    GoldPriceInfoMapper goldPriceInfoMapper;

    @GetMapping("/everydayGoldProfitController")
    public int calEverydayGoldProfitController() {
        Date getDate = Calendar.getInstance().getTime();
        String currentTime = new SimpleDateFormat("yyyyMMdd").format(getDate);
        BigDecimal currentGoldPrice = goldPriceInfoMapper.getGoldPrice(currentTime);

        //获取前一天的时间
        java.text.SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date date=new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        String yesterdayTime = sdf.format(calendar.getTime());
        logger.info("yesterdayTime={}",yesterdayTime);
        BigDecimal yesterdayGoldPrice = goldPriceInfoMapper.getGoldPrice(yesterdayTime);

        //获取持有数量
        List<GoldHoldInfo> goldHoldInfoList = goldHoldInfoMapper.selectAll();
        for(GoldHoldInfo goldHoldInfo : goldHoldInfoList){
            String idCard = goldHoldInfo.getIdCard();
            String productType = goldHoldInfo.getProductType();
            BigDecimal holdAmount = goldHoldInfo.getHoldAmount();

            GoldProfitInfo goldProfitInfo = new GoldProfitInfo();
            goldProfitInfo.setProductType(productType);
            goldHoldInfo.setIdCard(idCard);
            goldProfitInfo = goldProfitInfoMapper.selectOne(goldProfitInfo);

            BigDecimal yesterdayProfit = currentGoldPrice.multiply(holdAmount).subtract(yesterdayGoldPrice.multiply(holdAmount));
            BigDecimal totalProfit = yesterdayProfit.add(goldProfitInfo.getTotalProfit());
            logger.info("yesterdayGoldProfit={}",yesterdayProfit);
            logger.info("totalGoldProfit={}",totalProfit);

            goldProfitInfoMapper.updateByIdCardAndType(yesterdayProfit,totalProfit,currentTime,productType,idCard);
        }
        return 200;
    }
}

package com.czb.goldtradesystem.service;

import com.czb.goldtradesystem.api.AllUserInfo;
import com.czb.goldtradesystem.api.BizException;

import com.czb.goldtradesystem.api.MyGoldHoldInfo;
import com.czb.goldtradesystem.api.in.*;
import com.czb.goldtradesystem.api.out.*;


import com.czb.goldtradesystem.mapper.*;
import com.czb.goldtradesystem.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Service
public class GoldTradeSystemImpl implements GoldTradeSystem {
    private static final Logger log = LogManager.getLogger();

    @Resource
    private UserInfoMapper userInfoMapper;
    @Resource
    private GoldProductInfoMapper goldProductInfoMapper;
    @Resource
    private GoldPriceInfoMapper goldPriceInfoMapper;
    @Resource
    private GoldHoldInfoMapper goldHoldInfoMapper;
    @Resource
    private GoldPurchaseInfoMapper goldPurchaseInfoMapper;
    @Resource
    private  GoldSellInfoMapper goldSellInfoMapper;
    @Resource
    private  GoldProfitInfoMapper goldProfitInfoMapper;


    @Override
    public ValidLoginOut validLogin(ValidLoginIn in)  {
        //校验用户名 密码是否在数据库中匹配
        ValidLoginOut out = new ValidLoginOut();
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(in.getUserName());
        userInfo.setPassword(in.getPassword());
        UserInfo userInfo1 = new UserInfo();
        try{
            userInfo1 = userInfoMapper.selectOne(userInfo);
            out.setIdCardNum(userInfo1.getIdCard());
            out.setSuccess();
            out.setSuccessMsg();
        } catch(BizException e){
            log.error("用户不存在");
        } catch (Exception e) {
            log.error("查询失败，请稍后再试",e);
            throw e;
        }
        if(userInfo1 == null){
            out.setFailure();
            out.setErrMsg("用户不存在");
        }
        return out;
    }

    @Override
    public List<GoldProductInfo> queryAllProductInfo() {
        List<GoldProductInfo> goldProductInfoList = goldProductInfoMapper.queryAllProductInfo();
        return goldProductInfoList;
    }

    @Override
    @Transactional
    public PurchaseGoldOut purchaseGold(PurchaseGoldIn in) {
        PurchaseGoldOut out = new PurchaseGoldOut();
        String purchaseAmount = in.getPurchaseAmount();
        String productType = in.getProductType();
        String idCardNum = in.getIdCardNum();

        Date getDate = Calendar.getInstance().getTime();
        String currentTime = new SimpleDateFormat("yyyyMMdd").format(getDate);
        GoldProductInfo goldProductInfo = new GoldProductInfo();
        //获取当日黄金价格
        BigDecimal goldPrice = goldPriceInfoMapper.getGoldPrice(currentTime);
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(idCardNum);
        log.info("用户信息表：{}",userInfo.toString());
        BigDecimal balance = userInfo.getBalance();
        //购买黄金总价格
        BigDecimal totalMoney = (new BigDecimal(purchaseAmount)).multiply(goldPrice);
        if(totalMoney.compareTo(balance) > 1 ){
            throw new BizException("购买黄金余额不足");
        }
        balance = balance.subtract(totalMoney);
        userInfo.setBalance(balance);
        //更新用户信息表中余额
        userInfoMapper.updateByPrimaryKey(userInfo);

        //插入或更新黄金持有信息表
        GoldHoldInfo goldHoldInfo = new GoldHoldInfo();
        goldHoldInfo.setIdCard(idCardNum);
        try{
            GoldHoldInfo goldHoldInfo1 = goldHoldInfoMapper.selectOne(goldHoldInfo);
            if(goldHoldInfo1 == null){
                goldHoldInfo.setHoldAmount(purchaseAmount);
                goldHoldInfo.setOprTime(currentTime);
                goldHoldInfo.setProductType(productType);
                goldHoldInfoMapper.insert(goldHoldInfo);
            }
            goldHoldInfo1.setHoldAmount(String.valueOf(Integer.parseInt(purchaseAmount)+Integer.parseInt(goldHoldInfo1.getHoldAmount())));
            goldHoldInfoMapper.updateByPrimaryKey(goldHoldInfo1);
        }catch (Exception e){
            log.error("查询黄金持有信息表错误",e);
            throw e;
        }
        //买入黄金信息插入把数据插入表信息
        GoldPurchaseInfo goldPurchaseInfo =new GoldPurchaseInfo();
        goldPurchaseInfo.setIdCard(idCardNum);//
        goldPurchaseInfo.setPurchaseAmount(purchaseAmount);
        goldPurchaseInfo.setOprTime(currentTime);
        goldPurchaseInfo.setProductType(productType);
        goldPurchaseInfo.setUesdMoney(totalMoney);
        goldPurchaseInfoMapper.insert(goldPurchaseInfo);

        out.setSuccess();
        out.setErrMsg("购买黄金成功");
        return out;
    }

    @Override
    @Transactional
    public SellGoldOut sellGold(SellGoldIn in) {
        SellGoldOut out = new SellGoldOut();
        String idCardNum = in.getIdCardNum();
        String sellAmount = in.getSellAmount();
        String productType = in.getProductType();
        //更新持有量，如果持有数目小于卖出数量则报错
        GoldHoldInfo goldHoldInfo = new GoldHoldInfo();
        try{
            GoldHoldInfo goldHoldInfo1 = goldHoldInfoMapper.selectOne(goldHoldInfo);
            if(goldHoldInfo1 == null){
                throw new BizException("该客户黄金持有信息不存在");
            }
            if(Integer.parseInt(goldHoldInfo1.getHoldAmount()) < Integer.parseInt(sellAmount)){
                throw new BizException("卖出黄金数量大于持有量");
            }
            goldHoldInfo1.setHoldAmount(String.valueOf(Integer.parseInt(goldHoldInfo1.getHoldAmount())-Integer.parseInt(sellAmount)));
            goldHoldInfoMapper.updateByPrimaryKey(goldHoldInfo1);
        }catch (BizException e){
            log.error(e.getMessage());
        } catch (Exception e){
            log.error("查询黄金持有信息表错误",e);
            throw e;
        }

        Date getDate = Calendar.getInstance().getTime();
        String currentTime = new SimpleDateFormat("yyyyMMdd").format(getDate);
        GoldProductInfo goldProductInfo = new GoldProductInfo();

        //获取当日黄金价格
        BigDecimal goldPrice = goldPriceInfoMapper.getGoldPrice(currentTime);
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(idCardNum);
        BigDecimal totalSellMoney = (new BigDecimal(sellAmount)).multiply(goldPrice);
        userInfo.setBalance(userInfo.getBalance().add(totalSellMoney));
        userInfo.setLastLoginTime(currentTime);

        //更新账户余额
        userInfoMapper.updateByPrimaryKey(userInfo);

        //插入卖出黄金交易信息记录表
        GoldSellInfo goldSellInfo = new GoldSellInfo();
        goldSellInfo.setIdCard(idCardNum);
        goldSellInfo.setAddMoney(totalSellMoney);
        goldSellInfo.setOprTime(currentTime);
        goldSellInfo.setSellAmount(sellAmount);
        goldSellInfo.setProductType(productType);
        goldSellInfoMapper.insert(goldSellInfo);
        out.setSuccess();
        out.setErrMsg("卖出黄金成功");

        return  out;
    }

    @Override
    @Transactional
    public PurchaseGoldInfoOut purchaseGoldInfo(PurchaseGoldInfoIn in){
        String idCardNum = in.getIdCardNum();
        String producyType = in.getProductType();
        PurchaseGoldInfoOut out = new PurchaseGoldInfoOut();
        GoldPurchaseInfo goldPurchaseInfo = new GoldPurchaseInfo();
        goldPurchaseInfo.setIdCard(idCardNum);
        goldPurchaseInfo.setProductType(producyType);
        try{
            List<GoldPurchaseInfo> purchaseList = goldPurchaseInfoMapper.select(goldPurchaseInfo);
            if(purchaseList == null){
                out.setFailure();
                out.setErrMsg("该客户黄金购买信息不存在");
                throw new BizException("该客户黄金购买信息不存在");
            }
            out.setGoldPurchaseInfoList(purchaseList);
            out.setSuccess();
            out.setErrMsg("查询黄金购买记录信息成功");
        }catch(BizException e){
            log.error("该客户黄金购买信息不存在",e);
            throw e;
        } catch (Exception e){
            log.error("黄金购买信息查询错误",e);
            throw e;
        }
        return out;
    }


    @Override
    @Transactional
    public SellGoldInfoOut sellGoldInfo(SellGoldInfoIn in ){
        String idCardNum = in.getIdCardNum();
        String productType = in.getProductType();
        SellGoldInfoOut out = new SellGoldInfoOut();
        GoldSellInfo goldSellInfo=new GoldSellInfo();
        goldSellInfo.setIdCard(idCardNum);
        goldSellInfo.setProductType(productType);
        try{
            List<GoldSellInfo> list=goldSellInfoMapper.select(goldSellInfo);
            if(list == null){
                out.setFailure();
                out.setErrMsg("该客户黄金卖出信息不存在");
                throw new BizException("该客户黄金卖出信息不存在");
            }
            out.setGoldSellInfoList(list);
            out.setSuccess();
            out.setErrMsg("查询黄金卖出记录信息成功");
        } catch(BizException e){
            log.error("该客户黄金卖出信息不存在",e);
            throw e;
        }catch(Exception e){
            log.error("黄金卖出信息查询失败",e);
            throw  e;
        }
            return  out;
        }
    @Override
    @Transactional
    public UserInfoOut queryUserInfo(UserInfoIn in){
        UserInfoOut out = new UserInfoOut();
        String idCardNum = in.getIdCardNum();
        UserInfo userInfo = new UserInfo();
        userInfo.setIdCard(idCardNum);
        try{
            List<UserInfo> userList=userInfoMapper.select(userInfo);
            out.setUserInfoList(userList);
            if(userList == null){
                throw new BizException("该客户信息不存在");
            }
        }
        catch (BizException e){
            log.error("该客户信息不存在",e);
            throw e;
        }
        catch(Exception e){
            log.error("该客户信息查询失败",e);
            throw  e;
        }
        return  out;
    }

    @Override
    public UserAllTradeInfoOut queryUserAllTradeInfo(UserAllTradeInfoIn in) {
        UserAllTradeInfoOut out = new UserAllTradeInfoOut();
        String idCardNum = in.getIdCardNum();
        String productType = in.getProductType();

        GoldSellInfo goldSellInfo = new GoldSellInfo();
        goldSellInfo.setIdCard(idCardNum);
        goldSellInfo.setProductType(productType);

        GoldPurchaseInfo goldPurchaseInfo = new GoldPurchaseInfo();
        goldPurchaseInfo.setIdCard(idCardNum);
        goldPurchaseInfo.setProductType(productType);

        List<AllUserInfo> allUserInfoList = new ArrayList<>();
        try{
            List<GoldSellInfo> goldSellInfoList=goldSellInfoMapper.select(goldSellInfo);
            List<GoldPurchaseInfo> goldPurchaseInfoList = goldPurchaseInfoMapper.select(goldPurchaseInfo);
            if(goldSellInfoList == null && goldPurchaseInfoList == null){
                out.setFailure();
                out.setErrMsg("该客户交易信息不存在");
                throw new BizException("该客户交易信息不存在");
            }
            for(GoldSellInfo goldSellInfo1 : goldSellInfoList){
                AllUserInfo allUserInfo = new AllUserInfo();
                allUserInfo.setIdCard(goldSellInfo1.getIdCard());
                allUserInfo.setProductType(goldSellInfo1.getProductType());
                allUserInfo.setSellAmount(goldSellInfo1.getSellAmount());
                allUserInfo.setOprTime(goldSellInfo1.getOprTime());
                allUserInfo.setAddMoney(goldSellInfo1.getAddMoney());
                allUserInfoList.add(allUserInfo);
            }
            for(GoldPurchaseInfo purchaseInfo1 :  goldPurchaseInfoList){
                AllUserInfo allUserInfo = new AllUserInfo();
                allUserInfo.setIdCard(purchaseInfo1.getIdCard());
                allUserInfo.setProductType(purchaseInfo1.getProductType());
                allUserInfo.setPurchaseAmount(purchaseInfo1.getPurchaseAmount());
                allUserInfo.setOprTime(purchaseInfo1.getOprTime());
                allUserInfo.setUesdMoney(purchaseInfo1.getUesdMoney());
                allUserInfoList.add(allUserInfo);
            }
            out.setAllUserInfoList(allUserInfoList);
            out.setSuccess();
            out.setErrMsg("查询黄金交易信息记录成功");
        } catch(BizException e){
            log.error("该客户黄金交易信息不存在",e);
            throw e;
        }catch(Exception e){
            log.error("黄金交易信息查询失败",e);
            throw  e;
        }
        return out;
    }

    @Override
    public QueryUserHoldInfoOut queryUserHoldInfo(QueryUserHoldInfoIn in) {
        QueryUserHoldInfoOut out = new QueryUserHoldInfoOut();
        String idCardNum = in.getIdCardNum();

        GoldHoldInfo goldHoldInfo = new GoldHoldInfo();
        goldHoldInfo.setIdCard(idCardNum);

        Date getDate = Calendar.getInstance().getTime();
        String currentTime = new SimpleDateFormat("yyyyMMdd").format(getDate);

        List<MyGoldHoldInfo> myGoldHoldInfoList = new ArrayList<>();
        try{
            List<GoldHoldInfo> goldHoldInfoList = goldHoldInfoMapper.select(goldHoldInfo);
            log.info("goldHoldInfoList={}",goldHoldInfoList);
            if(goldHoldInfoList == null){
                throw new BizException("该客户持仓信息不存在");
            }
            for(GoldHoldInfo goldHoldInfo1 : goldHoldInfoList){
                MyGoldHoldInfo myGoldHoldInfo = new MyGoldHoldInfo();
                myGoldHoldInfo.setHoldAmount(goldHoldInfo1.getHoldAmount());
                myGoldHoldInfo.setIdCard(goldHoldInfo1.getIdCard());
                myGoldHoldInfo.setProductType(goldHoldInfo1.getProductType());

                //获取当日黄金持仓总价值
                BigDecimal goldPrice = goldPriceInfoMapper.getGoldPrice(currentTime);
                BigDecimal totalWorthMoney = (new BigDecimal(goldHoldInfo1.getHoldAmount())).multiply(goldPrice);
                myGoldHoldInfo.setTotalWorth(totalWorthMoney);
                log.info("当日黄金价格={}",totalWorthMoney);

                //获取产品名称
                GoldProductInfo goldProductInfo = new GoldProductInfo();
                goldProductInfo.setProductType(goldHoldInfo1.getProductType());
                GoldProductInfo goldProductInfo1 = goldProductInfoMapper.selectOne(goldProductInfo);
                myGoldHoldInfo.setProductName(goldProductInfo1.getProductName());
                log.info("获取产品名称={}",myGoldHoldInfo.getProductName());

                //获取昨日收益与总收益
                GoldProfitInfo goldProfitInfo = new GoldProfitInfo();
                goldProfitInfo.setIdCard(idCardNum);
                goldProfitInfo.setProductType(goldHoldInfo1.getProductType());
                GoldProfitInfo goldProfitInfo1 = goldProfitInfoMapper.selectOne(goldProfitInfo);
                myGoldHoldInfo.setYesterdayProfit(goldProfitInfo1.getYesterdayProfit());
                myGoldHoldInfo.setTotalProfit(goldProfitInfo1.getTotalProfit());
                log.info("获取昨日收益与总收益={},{}",myGoldHoldInfo.getYesterdayProfit(),myGoldHoldInfo.getTotalProfit());

                myGoldHoldInfoList.add(myGoldHoldInfo);
            }
            out.setMyGoldHoldInfoList(myGoldHoldInfoList);
            out.setSuccess();
            out.setErrMsg("用户持仓信息查询成功");
        }
        catch (BizException e){
            log.error("该客户持仓信息不存在",e);
            throw e;
        }
        catch(Exception e){
            log.error("该客户持仓信息查询失败",e);
            throw  e;
        }
        return out;
    }
}



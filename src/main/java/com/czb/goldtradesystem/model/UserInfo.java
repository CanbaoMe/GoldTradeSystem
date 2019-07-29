package com.czb.goldtradesystem.model;


import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Table(name = "user_info")
public class UserInfo {
    @Id
    private String idCard;

    @Column(name="user_name")
    private String userName;

    @Column(name="password")
    private String password;

    @Column(name="mobilephone")
    private String mobilephone;

    @Column(name="email")
    private String email;

    @Column(name="bind_acct_bank_num")
    private String bindAcctBankNum;

    @Column(name="gold_hold_amount")
    private BigDecimal goldHoldAmount;

    @Column(name="balance")
    private BigDecimal balance;

    @Column(name="add_time")
    private String addTime;

    @Column(name="last_login_time")
    private String lastLoginTime;

    @Column(name="yesterday_balance_profit")
    private BigDecimal yesterdayBalanceProfit;

    @Column(name="total_balance_profit")
    private BigDecimal totalBalanceProfit;

    @Override
    public String toString() {
        return "UserInfo{" +
                "idCard='" + idCard + '\'' +
                ", userName='" + userName + '\'' +
                // ", password='" + password + '\'' +
                ", mobilephone='" + mobilephone + '\'' +
                ", email='" + email + '\'' +
                ", bindAcctBankNum='" + bindAcctBankNum + '\'' +
                ", goldHoldAmount='" + goldHoldAmount + '\'' +
                ", balance=" + balance +
                ", addTime='" + addTime + '\'' +
                ", lastLoginTime='" + lastLoginTime + '\'' +
                '}';
    }
}
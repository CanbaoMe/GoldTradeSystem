package com.czb.goldtradesystem.model;


import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "user_info")
public class UserInfo {
    @Id
    private String idCard;

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
    private String goldHoldAmount;

    @Column(name="balance")
    private BigDecimal balance;

    @Column(name="add_time")
    private String addTime;

    @Column(name="last_login_time")
    private String lastLoginTime;

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone == null ? null : mobilephone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getBindAcctBankNum() {
        return bindAcctBankNum;
    }

    public void setBindAcctBankNum(String bindAcctBankNum) {
        this.bindAcctBankNum = bindAcctBankNum == null ? null : bindAcctBankNum.trim();
    }

    public String getGoldHoldAmount() {
        return goldHoldAmount;
    }

    public void setGoldHoldAmount(String goldHoldAmount) {
        this.goldHoldAmount = goldHoldAmount == null ? null : goldHoldAmount.trim();
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime == null ? null : addTime.trim();
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime == null ? null : lastLoginTime.trim();
    }
}
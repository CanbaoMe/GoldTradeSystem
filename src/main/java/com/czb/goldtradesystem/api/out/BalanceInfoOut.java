package com.czb.goldtradesystem.api.out;

import com.czb.goldtradesystem.model.UserInfo;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BalanceInfoOut extends ResponseOut{
    private static final long serialVersionUID = 1L;
    BigDecimal balance;
}
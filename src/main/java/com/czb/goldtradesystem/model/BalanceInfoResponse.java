package com.czb.goldtradesystem.model;

import com.czb.goldtradesystem.api.out.ResponseOut;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ApiModel("返回余额参数")
public class BalanceInfoResponse extends ResponseOut {
    private BigDecimal balance;
}

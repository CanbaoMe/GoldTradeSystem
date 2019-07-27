package com.czb.goldtradesystem.api.in;

import lombok.Data;

@Data
public class QueryUserHoldInfoIn extends RequestIn{
    private String idCardNum;
}

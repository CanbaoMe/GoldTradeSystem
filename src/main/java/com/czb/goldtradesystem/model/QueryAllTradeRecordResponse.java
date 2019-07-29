package com.czb.goldtradesystem.model;

import com.czb.goldtradesystem.api.AllUserInfo;
import com.czb.goldtradesystem.api.out.ResponseOut;
import lombok.Data;

import java.util.List;

@Data
public class QueryAllTradeRecordResponse extends ResponseOut {
    List<AllUserInfo> allUserInfoList;
}

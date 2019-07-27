package com.czb.goldtradesystem.model;

import com.czb.goldtradesystem.api.out.ResponseOut;
import lombok.Data;

import java.util.List;

@Data
public class QuerySellRecordResponse extends ResponseOut {
    List<GoldSellInfo> goldSellInfoList;
}

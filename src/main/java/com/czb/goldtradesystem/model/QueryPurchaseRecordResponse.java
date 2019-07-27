package com.czb.goldtradesystem.model;

import com.czb.goldtradesystem.api.out.ResponseOut;
import lombok.Data;

import java.util.List;

@Data
public class QueryPurchaseRecordResponse extends ResponseOut {
    List<GoldPurchaseInfo> goldPurchaseInfoList;
}

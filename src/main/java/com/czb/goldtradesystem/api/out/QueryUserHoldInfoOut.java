package com.czb.goldtradesystem.api.out;

import com.czb.goldtradesystem.api.MyGoldHoldInfo;
import lombok.Data;

import java.util.List;


@Data
public class QueryUserHoldInfoOut extends ResponseOut{
    private static final long serialVersionUID = 1L;
    List<MyGoldHoldInfo> myGoldHoldInfoList;
}

package com.czb.goldtradesystem.api.out;

import com.czb.goldtradesystem.api.AllUserInfo;
import lombok.Data;

import java.util.List;

@Data
public class UserAllTradeInfoOut extends ResponseOut{
    private static final long serialVersionUID = 1L;
    List<AllUserInfo> allUserInfoList;
}

package com.czb.goldtradesystem.api.out;
import com.czb.goldtradesystem.model.GoldSellInfo;
import com.czb.goldtradesystem.model.UserInfo;
import lombok.Data;

import java.util.List;

@Data
public class UserInfoOut extends ResponseOut{

    private static final long serialVersionUID = 1L;
    List<UserInfo> UserInfoList;
}

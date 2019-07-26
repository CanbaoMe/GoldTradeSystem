package com.czb.goldtradesystem.model;

import com.czb.goldtradesystem.api.out.ResponseOut;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("登录返回参数")
public class LoginResponse extends ResponseOut {

    @ApiModelProperty("返回用户身份证号")
    String idCardNum;

}

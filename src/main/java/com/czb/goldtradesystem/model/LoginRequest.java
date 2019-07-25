package com.czb.goldtradesystem.model;

import com.czb.goldtradesystem.api.in.RequestIn;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @author crc
 */
@ApiModel("登录请求参数")
public class LoginRequest extends RequestIn {

    @ApiModelProperty("用户名")
    @NotNull
    String userName;

    @ApiModelProperty("密码")
    @NotNull
    String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
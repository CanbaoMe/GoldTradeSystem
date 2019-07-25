package com.czb.goldtradesystem.controller;


import com.czb.goldtradesystem.api.in.ValidLoginIn;
import com.czb.goldtradesystem.api.out.ValidLoginOut;
import com.czb.goldtradesystem.mapper.UserInfoMapper;
import com.czb.goldtradesystem.model.LoginRequest;
import com.czb.goldtradesystem.model.LoginResponse;
import com.czb.goldtradesystem.model.UserInfo;
import com.czb.goldtradesystem.service.GoldTradeSystemImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author crc
 */
@RestController
@Api(description = "主页接口")
public class HomeController extends BaseController {
    @Resource
    private UserInfoMapper userInfoMapper;

    @Autowired
    GoldTradeSystemImpl goldTradeSystem;

    @PostMapping("/login")
    @ApiOperation("登录")
    public LoginResponse login(@RequestBody @Valid LoginRequest loginRequest) {
        logger.info(loginRequest.getUserName());
        LoginResponse loginResponse = new LoginResponse();
        String userName = loginRequest.getUserName();
        String password = loginRequest.getPassword();
        ValidLoginIn in = new ValidLoginIn();
        in.setUserName(userName);
        in.setPassword(password);
        ValidLoginOut out = goldTradeSystem.validLogin(in);
        loginResponse.setErrCode(out.getErrCode());
        loginResponse.setErrMsg(out.getErrMsg());
        return loginResponse;
    }

}

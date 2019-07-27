package com.czb.goldtradesystem.controller;

import com.czb.goldtradesystem.mapper.UserInfoMapper;
import com.czb.goldtradesystem.model.UserInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/consumer/dept")
public class TestController extends BaseController{
    @Resource
    private UserInfoMapper userInfoMapper;

    @GetMapping("/findAll")
    public List<UserInfo> findAll() {
        List<UserInfo> depts = userInfoMapper.selectAll();
        return depts;
    }
}

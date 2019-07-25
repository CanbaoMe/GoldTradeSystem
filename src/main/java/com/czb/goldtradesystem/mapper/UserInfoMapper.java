package com.czb.goldtradesystem.mapper;

import com.czb.goldtradesystem.model.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface UserInfoMapper extends Mapper<UserInfo> {
    @Select("select * from user_info where user_name=#{userName} and password=#{password} limit 1 ")
    UserInfo selectUserInfo(@Param("userName") String userName, @Param("password") String password);

    int deleteByPrimaryKey(String idCard);

    UserInfo selectByPrimaryKey(String idCard);
}
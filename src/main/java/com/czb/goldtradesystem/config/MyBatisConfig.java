package com.czb.goldtradesystem.config;

import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;

@Configuration
@MapperScan(basePackages = "com.czb.goldtradesystem.mapper")
public class MyBatisConfig {

}

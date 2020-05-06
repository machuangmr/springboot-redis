package com.example.demo.soundsystem;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class CDplayConfig{
    //该配置类可以通过java代码定义spring的配置规则，
    //@ComponentScan可以启用组件扫描，
    //如果这个类没有其他的配置的话，该注解会默认扫描与配置类相同的包
}

package com.example.demo.security;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoIdement {
//@Target ElementType.Method表示只在方法上
//@Retention：RetentionPolicy.Runtime表示只在运行时
}

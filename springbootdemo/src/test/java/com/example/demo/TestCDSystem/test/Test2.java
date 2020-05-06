package com.example.demo.TestCDSystem.test;

public class Test2 {
    public static void main(String[] args) {
        String str = "123、456";
        String[] split = str.split(",");
        for (String s : split) {
            System.out.println("s==" + s);
        }
    }
}

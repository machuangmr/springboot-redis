package com.example.demo;

import lombok.Data;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class TestNull {

    @Test
    public void test() {
        LocalDate matureDay = LocalDate.of(2020, 04,05);
        boolean flag = false;
        if (matureDay.isBefore(LocalDate.now())) {
            flag=true;
        }
        Assert.assertTrue(flag);
    }
}
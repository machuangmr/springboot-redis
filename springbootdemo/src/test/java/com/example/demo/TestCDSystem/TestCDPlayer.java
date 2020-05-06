package com.example.demo.TestCDSystem;

import com.example.demo.soundsystem.CD;
import com.example.demo.soundsystem.CDplayConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=CDplayConfig.class)
public class TestCDPlayer {
    //@ContextConfiguration注解会告诉他需要在CDplayConfig类中加载配置，
    @Autowired
    private CD cd;
    @Test
    public void testCdNotNull() {
        Assert.notNull(cd, "cd have been init");
    }
}

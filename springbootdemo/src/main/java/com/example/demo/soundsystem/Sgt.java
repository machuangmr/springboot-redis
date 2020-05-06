package com.example.demo.soundsystem;

import org.springframework.stereotype.Component;

@Component //将其声明为一个组件，并告知spring要为这个类创建bean
public class Sgt implements CD {

    private String title = "故乡的原风景";
    @Override
    public void play() {
        System.out.println("这首歌的标题是 " + title);
    }
}

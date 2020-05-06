package com.example.demo.TestCDSystem.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("123");
        list.add("456");
        list.add("789");
        Iterator<String> it = list.iterator();
        while(it.hasNext()) {
            String str = it.next();
            if (str.equalsIgnoreCase("123")) {
                it.remove();
            }
        }

        for (String s : list) {
            System.out.println(s);
        }
    }
}

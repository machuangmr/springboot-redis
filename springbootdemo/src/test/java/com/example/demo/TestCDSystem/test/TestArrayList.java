package com.example.demo.TestCDSystem.test;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestArrayList {
    public static void main(String[] args) {
        List<String>  strs = new ArrayList<>();
        for(int i=0; i < 10; i++) {
            strs.add("stres" + i);
        }
     //过滤掉list中的一些特定元素
        //方法1、使用for循环遍历, 可以简化使用collections.
        //strs.removeIf("stres2"::equals);
        /**
         * 该种方式删除后，list的大小发生了变化，而你的索引也发生了变化，所以在遍历的会漏掉数据，
         * 该种方式用于删除特定的一个元素时候使用。
         */
        //System.out.println(strs.get(2));

        //方法2、使用增强for进行遍历删除，会抛出concurrentmodifyException，
        /*
         * 因为在list.remove()方法会将修改modCount的值，然后在next方法中会进行判断，如果modcount和expectedmodcount的值
         * 不相等，则会抛出concurrentmodifyException，所以可以使用iter的remove方法
         *
         */
//        for (String str : strs) {
//            if ("stres2".equals(str)) {
//                strs.remove(str);
//            }
//        }
        //方法3、使用迭代器
        //Iterator<String> iterator = strs.iterator();
//        while (iterator.hasNext()) {
//            //使用迭代器获取下一个元素。
//            String str = iterator.next();
//            if ("stres2".equals(str)) {
//                iterator.remove();//注意这里使用迭代器的remove方法，
//            }
//        }
//        System.out.println(strs.toString());
        //方法4，使用java8stream的filter(推荐使用)
        List<String> strs2 = strs.stream()
                .filter(it -> !"stres2".equals(it))
                .collect(Collectors.toList());
        System.out.println(strs2.toString());
    }
}

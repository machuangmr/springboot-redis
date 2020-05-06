package com.example.demo;

public class TestThreadLocal {
    public static ThreadLocal<String> values = new ThreadLocal<>();
    /**
     * threadlocal 测试
     *
     * @throws Exception
     */

    public void testThreadLocal(){
        //开始时候，主线程设置值
        values.set("这个是主线程设置的值111");
        System.out.println("线程1 在运行前主线程的值" + values.get());
        new Thread(() -> {
            String v1 = values.get();
            System.out.println("线程1获取的到的值" + v1);
            values.set("线程1获取到的值456");
            System.out.println("线程1获取到的值" + values.get());
            System.out.println("线程1执行结束");
        }).start();
        System.out.println("线程1 运行结束后主线程的值" + values.get());
    }

    public static void main(String[] args) {
        TestThreadLocal testThreadLocal = new TestThreadLocal();
        testThreadLocal.testThreadLocal();
    }
}

package testInterview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: Src
 * @description: lambda表达式不能访问无final特性的局部变量;
 * @author: wsj
 * @create: 2024-10-16 15:59
 **/
public class LamdaDemo {
    public static void main(String[] args) {
        String str = "str";
        str += "yes";
        System.out.println(str);
        test02();

        AtomicInteger res = new AtomicInteger();
        List<Integer> list = new ArrayList<>();
        list.forEach(item -> {
             System.out.println(res.getAndIncrement());   // res++会报错
        });
    }
    // 不可访问非final的局部变量
    public static void test01() {
        String str = "str";
        new Thread(()->{
            // str += "yes";     // 报错
            System.out.println(str);
        }).start();
    }
    public static void test02() {
        String str = "str";
        new Thread(() -> {
            System.out.println(str);
        }).start();

    }
    public static void test03() {
        String str = "str";
        new Thread(()->{
             //str += "yes";     // 报错
            System.out.println(str);
        }).start();
    }

    public static void test05() {
        new Thread(()->{
            final int a = 0;   // 假设编译通过
            System.out.println(a);
        }).start();
    }




}

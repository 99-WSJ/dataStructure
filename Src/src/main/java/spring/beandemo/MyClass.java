package spring.beandemo;

import exam.test.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program: Src
 * @description: 只用@Autowired
 * Spring中如果一个类不加任何注解，在这个类里面有一个属性上面加了@Autowired会发生什么情况
 * 类不会被Spring管理
 * @Autowired 注解无效, 不会进行依赖注入
 *
 *
 * @author: wsj
 * @create: 2024-09-11 19:03
 **/
@Component
public class MyClass {
    @Autowired
    private User user;

    // 方法和构造函数
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        User user = myClass.user;
        System.out.println(user.toString());

    }
}

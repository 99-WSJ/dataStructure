package spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.pojo.UserInfo;
import spring.service.UserService;

import javax.annotation.Resource;

/**
 * @program: Src
 * @description: 依赖注入
 * 当应用程序需要使用某个 Bean 时，Spring 容器会自动将该 Bean 注入到应用程序中 ——依赖注入
 *  Java 反射机制实现的。它会使用 Java 反射机制来查找符合条件的 Bean
 *  怎么查找？byName和byType
 *  @Autowired 是先根据类型（byType）查找，如果存在多个 Bean 再根据名称（byName）进行查找
 *  @Resource 是先根据名称查找，如果（根据名称）查找不到，再根据类型进行查找
 * @author: wsj
 * @create: 2024-08-30 10:16
 **/

@RestController
@RequestMapping("/userInfo")
public class UserController {
     // 属性注入

     // 功能性问题：无法注入一个不可变的对象（final 修饰的对象）；
     // 通用性问题：只能适应于 IoC 容器；放入非IOC其他框架就不适合
     // 设计原则问题：更容易违背单一设计原则。操作简单，多个属性注入是否必要，容易滥用

    @Autowired
    @Resource
    private UserService userService;

    // setter 注入
    // 功能性问题：无法注入一个不可变的对象（final 修饰的对象）；
    // 注入对象可以被更改
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    // 构造器注入
    //    可注入不可变对象；
    //    注入对象不会被修改；
    //    注入对象会被完全初始化；
    //    通用性更好。
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/add")
    public UserInfo add(String username, String password) {
        return userService.add(username, password);
    }
}

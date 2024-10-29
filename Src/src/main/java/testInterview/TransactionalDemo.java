package testInterview;

import lombok.Data;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: Src
 * @description: 内部自调用出现事务失效
 * @author: wsj
 * @create: 2024-10-17 16:48
 **/
public class TransactionalDemo {
    public static void main(String[] args) {
        TransactionalDemo t = new TransactionalDemo();
        t.insertUser(new User());


    }

    @Transactional(rollbackFor = RuntimeException.class)
    public void insertUser(User user) {
        user.name = "wsj";
        throw new RuntimeException("");  // 手动抛出异常，测试事务回滚
    }


    public void invokeInsertUser(User user) {
        this.insertUser(user);  // 内部调用，事务失效，不能用this
    }


    /** 解决方法：引入自身的bean
    @Autowired
    @Lazy
    private UserService service;

    @Override
    public void invokeInsertUser(User user) {
        service.insertUser(user);  // 通过代理对象调用
    }
    */

    /**
     * 通过 ApplicationContext 获取 bean： 利用 ApplicationContext 来获取代理类的 bean，从而使用 AOP 代理功能
     * @Autowired
     * private ApplicationContext applicationContext;
     * @Override
     * public void invokeInsertUser(User user) {
     *     ((UserService) applicationContext.getBean("userService")).insertUser(user);  // 通过 ApplicationContext 获取代理
     * }
     */

    /**
     * 通过 AopContext 获取代理类： 使用 AopContext 来获取当前类的代理对象，然后通过代理对象调用方法
     * @Override
     * public void invokeInsertUser(User user) {
     *     ((UserService) AopContext.currentProxy()).insertUser(user);  // 通过 AopContext 获取代理对象
     * }
     */




}

@Data
class User{
    String name;
    int age;
}
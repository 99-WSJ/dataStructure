package test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/*
定义接口：首先定义一个或多个接口，以及它们的实现类。
创建InvocationHandler：实现InvocationHandler接口，重写invoke方法。
在这里可以插入自定义的逻辑，比如日志记录、权限检查等。
生成代理对象：通过调用Proxy.newProxyInstance方法，传入类加载器、接口数组
以及InvocationHandler实例，来动态生成代理对象。
 */


// 定义接口
interface Subject {
    void doSomething();
}

// 实现被代理的类
class RealSubject implements Subject {
    @Override
    public void doSomething() {
        System.out.println("RealSubject is doing something.");
    }
}

// 实现 InvocationHandler 接口
class DynamicProxy implements InvocationHandler {
    private Object target; // 被代理的对象

    public DynamicProxy(Object target) {
        this.target = target;
    }

    // 在代理对象上执行方法时，会调用该方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before method execution.");
        Object result = method.invoke(target, args); // 调用被代理对象的方法
        System.out.println("After method execution.");
        return result;
    }
}

public class ProxyExample {
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        // 创建动态代理对象
        Subject proxy = (Subject) Proxy.newProxyInstance(
                Subject.class.getClassLoader(), // 类加载器
                new Class<?>[] { Subject.class }, // 要实现的接口
                new DynamicProxy(realSubject) // InvocationHandler 实现类
        );
        // 通过动态代理对象调用方法
        proxy.doSomething();
    }
}

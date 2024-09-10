package handwrite;

import java.lang.annotation.Target;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: Src
 * @description: 动态代理
 * @author: wsj
 * @create: 2024-07-01 20:11
 **/
interface Person{
    void doSome();
}

class Student implements Person{

    @Override
    public void doSome() {
        System.out.println("real Object");
    }
}

class MyInvoke implements InvocationHandler {
    private Object target = null;

    public MyInvoke(Object obj) {
        this.target = obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理前======");
        Object res = method.invoke(target, args);
        System.out.println("代理后======");
        return res;
    }
}

public class DynamicProxyDemo {
    public static void main(String[] args) {
        Person person = new Student();
        MyInvoke handle = new MyInvoke(person);
        Person proxy = (Person) Proxy.newProxyInstance(person.getClass().getClassLoader(),
                            person.getClass().getInterfaces(), handle);
        proxy.doSome();

    }
}
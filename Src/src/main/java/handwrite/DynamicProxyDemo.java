package handwrite;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: Src
 * @description: 动态代理
 * @author: wsj
 * @create: 2024-07-01 20:11
 **/
public class DynamicProxyDemo {
    public static void main(String[] args) {
        Person person = new student();
        MyInvoke myInvoke = new MyInvoke(person);

        Person proxy = (Person) Proxy.newProxyInstance(person.getClass().getClassLoader(),
                person.getClass().getInterfaces(),
                myInvoke);
        proxy.doSomething();
    }
}

interface Person{
    void doSomething();
}
class student implements Person {

    @Override
    public void doSomething() {
        System.out.println("doing ==========");
    }
}

class MyInvoke implements InvocationHandler {
    private Object obj;
    public MyInvoke(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("doing before");
        Object res = method.invoke(obj, args);
        System.out.println("doing after");
        return obj;
    }
}


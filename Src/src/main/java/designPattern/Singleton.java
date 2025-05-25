package designPattern;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 饿汉模式  在类加载的时候已经初始化了，final修饰不会出现线程问题
 */
class Singleton1 {
    private static final  Singleton1 instance = new Singleton1();
    private Singleton1() {}
    public static Singleton1 getInstance() {
        return instance;
    }

}

/**
 * 懒汉模式  使用synchronized确保线程安全，可能会影响性能
 */
class Singleton2 {
    private static  Singleton2 instance;
    private Singleton2() {}
    public static synchronized Singleton2 getInstance() {
        if(instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}

/**
 * 懒汉式改进
 * 可以使用双重检查锁（Double-Checked Locking）来提高性能和线程安全性。
 * 双重检查锁模式只在实例未被创建时使用同步锁，一旦实例被创建，就不再需要同步，
 * 避免了每次都执行同步方法。
 */
public class Singleton {
    private static volatile Singleton instance;
    private Singleton() {}
    public static Singleton getInstance() {
        if(instance == null) {
            synchronized (Singleton.class) {
                if(instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 获取类的显式构造器
        Constructor<Singleton> construct =
                Singleton.class.getDeclaredConstructor();
        // 可访问私有构造器
        construct.setAccessible(true);
        // 利用反射构造新对象
        Singleton obj1 = construct.newInstance();
        // 通过正常方式获取单例对象
        Singleton obj2 = Singleton.getInstance();
        System.out.println(obj1 == obj2); // false
    }
}


// 懒加载（Lazy Loading）也被称为延迟加载，是一种常见的设计模式，其目的是在需要的时候才去创建对象或加载资源，而不是在初始化阶段就立即进行。懒加载的核心思想是推迟对象的创建或资源的加载，直到第一次使用时才进行。
//
//在懒加载中，对象的创建或资源的加载通常会延迟到以下几种情况之一：
//
//第一次访问对象时
//第一次访问对象的某个特定属性时
//当满足特定条件时
//懒加载可以提高程序的性能，因为它避免了在初始化阶段就加载和创建不需要的对象或资源。它也有助于节省内存，特别是对于大型对象或资源来说。
//
//在懒加载的实现中，一个常见的方式是通过在方法或属性中进行 null 检查，然后在需要时创建对象或加载资源。



package structure.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author wsj
 * @description
 * @date 2023年12月31日 15:50
 */
public class CollectionDemo1 {
    public static void main(String[] args) {
        //        Throwable throwable = new Error();
//        BinarySearch binarySearch = new BinarySearch();
        // 为了学习collection里面的方法
        Collection<String> coll = new ArrayList<>();
        boolean add = coll.add("11");
        boolean add1 = coll.add("11");
        System.out.println(add );
        System.out.println(coll );
        // contains是通过equals判断是不是含有传入的对象，依赖Object类的equals判断地址是否相同
        System.out.println("contains = " + coll.contains("11"));
        System.out.println("size= " + coll.size() );

        // 向上转型：将子类对象赋值给父类引用变量
        Animal animal = new Dog();
        System.out.println(animal.getClass()); // dog类

        // 使用父类引用调用父类方法
        animal.makeSound(); // 输出："Dog barks" - 调用了子类的重写方法

        // 无法通过父类引用调用子类特有的方法
        // animal.fetch(); // 这行代码会导致编译错误，因为 Animal 类没有 fetch() 方法

        // 但是，可以将父类引用强制转换为子类类型，以便访问子类特有的方法
        if (animal instanceof Dog) {
            Dog dog = (Dog) animal;  // 强制转换
            System.out.println(animal.getClass()); // dog类
            dog.fetch(); // 输出："Dog fetches the ball"
        }

        Collection<String> c = new ArrayList<>();

        //添加元素
        c.add("hello");
        c.add("world");
        c.add("java");
        c.add("javaee");

        //Iterator<E> iterator()：返回此集合中元素的迭代器，通过集合的iterator()方法得到
        Iterator<String> it = c.iterator();

        //用while循环改进元素的判断和获取,当前元素是否存在
        while (it.hasNext()) {
            String s = it.next();
            if ("world".equals(s)) {
//                c.remove("world");
                it.remove();
            }
        }
        System.out.println(c);

        for (String s : c) {
            System.out.println(s);
        }
        System.out.println(c);
//        System.out.println(it.hasNext());
//        System.out.println(it.next());

        //2.利用匿名内部类的形式
        //底层原理：
        //其实也会自己遍历集合，依次得到每一个元素
        //把得到的每一个元素，传递给下面的accept方法
        //s依次表示集合中的每一个数据
       /* coll.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });*/

        //lambda表达式
//        c.forEach(s -> System.out.println(s));

    }


}

class Animal {
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }

    public void fetch() {
        System.out.println("Dog fetches the ball");
    }
}
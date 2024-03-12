package structure.collection;

import java.util.*;

/**
 * @author wsj
 * @description
 * @date 2023年12月31日 15:50
 */
public class CollectionListDemo {
    public static void main(String[] args) {

        List<String> c = new ArrayList<>();

        //添加元素
        c.add("hello");
        c.add("world");
        c.add("java");
        c.add("javaee");

        //Iterator<E> iterator()：返回此集合中元素的迭代器，通过集合的iterator()方法得到
        Iterator<String> it = c.iterator();

        //用while循环改进元素的判断和获取,当前元素是否存在
//        while (it.hasNext()) {
//            String s = it.next();
//            if ("world".equals(s)) {
////                c.remove("world");
//                it.remove();
//            }
//        }
//        System.out.println(c);

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
//        coll.forEach((String s) -> {
//                System.out.println(s);
//            });

        c.forEach(s -> System.out.println(s));

        ListIterator<String> it2 = c.listIterator();
        while(it2.hasNext()){
            String str = it2.next();
            if("java".equals(str)){
                //qqq
                it2.add("qqq");
            }
        }
        for (int i = 0; i < c.size(); i++) {
            System.out.println(c.get(i));
        }

    }


}


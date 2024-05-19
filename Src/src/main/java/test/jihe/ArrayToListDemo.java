package test.jihe;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;


/**
 * @author 阿叙
 * Array转list,更改数组元素会影响list，引用类型
 * list转数组，更改list中元素，不会影响数组，因为 Arrays.copyOf()是返回新数组
 *
 */

public class ArrayToListDemo {
    public static void main(String[] args) {
        //// 创建一个数组
        //String[] array = {"apple", "banana", "cherry"};
        //
        //// 将数组转换为列表
        //List<String> list = Arrays.asList(array);
        //System.out.println(list);
        //
        //// 修改数组内容
        //array[0] = "apricot";
        //
        //// 输出列表内容
        //System.out.println("List: " + list);
        // 创建一个列表
        List<String> list = Arrays.asList("apple", "banana", "cherry");

        // 将列表转换为数组
        String[] array = list.toArray(new String[0]);

        // 修改列表内容
        list.set(0, "apricot");
        ConcurrentLinkedQueue s = new ConcurrentLinkedQueue();

        // 输出数组内容
        System.out.println("Array: " + Arrays.toString(array));

    }
}

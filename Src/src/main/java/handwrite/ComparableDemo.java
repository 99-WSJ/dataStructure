package handwrite;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @program: Src
 * @description: 比较器
 * @author: wsj
 * @create: 2024-07-01 20:25
 **/
public class ComparableDemo {
    public static void main(String[] args) {
        Fish fish1 = new Fish(4, "ye");
        Fish fish2 = new Fish(6, "hua");
        Fish fish3 = new Fish(5, "hu");
        List<Fish> list = new ArrayList<>();
        list.add(fish1);
        list.add(fish2);
        list.add(fish3);

        Collections.sort(list);
        list.forEach((fish -> System.out.println(fish.toString())));

    }
}

@Data
class Fish implements Comparable<Fish>{
    private int age;
    private String name;
    private int len;

    public Fish(int age, String name) {
        this.age = age;
        this.name = name;
    }
    public Fish(int age, String name, int len) {
        this.age = age;
        this.len = len;
        this.name = name;
    }

    @Override
    public int compareTo(Fish o) {
        //return this.age - o.age;  //年龄从小到大
        return this.getName().compareTo(o.getName());  //名字从小到大
    }
}

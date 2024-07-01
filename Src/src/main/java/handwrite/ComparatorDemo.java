package handwrite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @program: Src
 * @description: 比较器实现
 * @author: wsj
 * @create: 2024-07-01 20:32
 **/
public class ComparatorDemo {
    public static void main(String[] args) {
        Fish fish1 = new Fish(4, "ye", 4);
        Fish fish2 = new Fish(6, "hua", 4);
        Fish fish3 = new Fish(5, "hu", 5);
        List<Fish> list = new ArrayList<>();
        list.add(fish1);
        list.add(fish2);
        list.add(fish3);

        list.forEach(fish -> System.out.println(fish.toString()));
        Collections.sort(list, new AgeComparator());
        list.forEach(fish -> System.out.println("age:  " + fish.toString()));

        Collections.sort(list, new NameComparator());
        list.forEach(fish -> System.out.println("name:  " + fish.toString()));

        Collections.sort(list, new Comparator<Fish>() {
            @Override
            public int compare(Fish o1, Fish o2) {
                return o1.getLen() - o2.getLen();
            }
        });

        list.forEach(fish -> System.out.println("len:  " + fish.toString()));
        Collections.sort(list, (o1, o2) -> o1.getAge() - o2.getAge());
        list.forEach(fish -> System.out.println("age:  " + fish.toString()));

    }


}
class AgeComparator implements Comparator<Fish> {

    @Override
    public int compare(Fish o1, Fish o2) {
        return o1.getAge() - o2.getAge();
    }
}
class NameComparator implements Comparator<Fish> {

    @Override
    public int compare(Fish o1, Fish o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
package structure.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author wsj
 * @description
 * @date 2024年01月02日 21:23
 */
public class SetDemo {

    public static void main(String[] args) {
        Set<Object> set = new HashSet<>();
        set.add("qq");
        set.add("qq1");
        set.add("qq2");
        System.out.println(set);

        Iterator<Object> it = set.iterator();
        while(it.hasNext()) {
            Object next = it.next();
            System.out.println(next);
        }
    }
}

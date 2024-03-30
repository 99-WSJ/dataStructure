package structure.collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author wsj
 * @description
 * @date 2024年01月02日 21:23
 */
public class MapDemo {

    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("name","wsj");
        hashMap.put("age","25");
        hashMap.put("gender","man");
        System.out.println(hashMap);

    }
}

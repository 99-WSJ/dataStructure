package structure.collection;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author wsj
 * @description
 * @date 2023年12月31日 19:36
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        int size = list.size();
        System.out.println(size);
        list.add("ss");
        System.out.println(list.size());

        ArrayList<String> list2 = new ArrayList<>(20);
        System.out.println(list2.size());

        int[] array = {1,2,3,5,4};
        Arrays.sort(array);
        char[] array_char = {'1','2','3','5','4'};
        System.out.println(Arrays.toString(array));


    }
}

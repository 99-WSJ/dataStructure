package test.basis;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author wsj
 * @description
 * @solutions 解法一:
 * 解法二：
 * 解法三：
 * @date 2024年05月23日 16:41
 */
public class CollectionsDemo {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        new CopyOnWriteArrayList<>();
        new Vector<>();
        Stack<Object> st = new Stack<>();
        st.push(nums);
        new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> queue2 = new ArrayDeque<>();
        st.isEmpty();
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        Collections.sort(list);
        Collections.synchronizedList(list);
        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new CopyOnWriteArrayList<>();
        List<Integer> list3 = new Vector<>();
        List<Integer> list4 = new CopyOnWriteArrayList<>();

        TreeSet<Object> hashSet = new TreeSet<>();
        HashSet<Object> set = new HashSet<>();
        LinkedHashSet<Object> linkedHashSet = new LinkedHashSet<>();


        TreeMap<Object, Object> treeMap = new TreeMap<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<Integer, Integer>();
    }
}

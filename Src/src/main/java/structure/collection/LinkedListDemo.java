package structure.collection;

import java.lang.String;

import java.util.*;

/**
 * @author wsj
 * @description
 * @date 2023年12月31日 19:24
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        String str = new String("11");
//        Comparable<String> stringComparable = new Comparable<>();
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder stringBuilder = new StringBuilder();
        HashSet hashSet = new HashSet();
        for (int i = 0; i <12 ; i++) {
            hashSet.add(new A(i));
        }
        System.out.println("-----"+hashSet);
    }
}
class Solution {
    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}


class A{
 private int i;

    public A(int i) {
        this.i = i;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        A a = (A) o;
        return i == a.i;
    }

    @Override
    public String toString() {
        return "A{" +
                "i=" + i +
                '}';
    }

    @Override
    public int hashCode() {
        return 100;
    }
}

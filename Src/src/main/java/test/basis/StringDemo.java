package test.basis;

import com.sun.org.apache.xml.internal.utils.StringBufferPool;

import java.util.HashMap;
import java.util.LinkedList;

public class StringDemo {
    public static void main(String[] args) {
        String str = "123";
        StringBuilder  s1 = new StringBuilder("123");
        String intern = str.intern();
        System.out.println(str);


    }
}


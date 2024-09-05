package examfinal.kedaxunfei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @program: Src
 * @description: 第一题
 * @author: wsj
 * @create: 2024-09-04 16:03
 **/

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        String s = scanner.next();

        int count = 0;
        for(char c : s.toCharArray()) {
            if(c == '0') {
                count++;
            }
        }
        if(count <= k) {
            System.out.println(n * n);
            return;
        }

        List<Integer> segments = new ArrayList<>();
        int count1 = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                count1++;
            } else {
                if (count1 > 0) {
                    segments.add(count1);
                    count1 = 0;
                }
            }
        }
        if (count1 > 0) {
            segments.add(count1);
        }

        Collections.sort(segments);
        int size = segments.size() - 1;
        segments.set(size, segments.get(size) + k);
        int res = 0;
        for(int i : segments) {
            res += i * i;
        }

        System.out.println(Math.min(res, n * n));



    }
}

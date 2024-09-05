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

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }
        Collections.sort(list);


        int size = list.size();
        int mid;
        if (size % 2 == 1) {
            mid = list.get(size / 2);
        } else {
            int x = list.get(size / 2 - 1);
            int y = list.get(size / 2);
            mid = Math.min(x, y);
        }
        System.out.print(mid + " ");
        list.remove(Integer.valueOf(mid));

    }
}

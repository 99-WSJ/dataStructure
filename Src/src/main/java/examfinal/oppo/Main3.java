package examfinal.oppo;

import java.util.Scanner;

/**
 * @program: Src
 * @description:
 * @author: wsj
 * @create: 2024-09-04 16:03
 **/

public class Main3 {
    public static void main(String[] args) {
        //byte b = 1;
        //int i = 10;
        //b = b + b;
        //i = b + i;

        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        int max = Math.max(a, Math.max(b, c));
        int temp = 0;
        if(max == a) {
            temp = Math.max(b, c);
        } else if(max == b) {
            temp = Math.max(a, c);
        } else {
            temp = Math.max(a, b);
        }

        int x = scanner.nextInt();
        int k = scanner.nextInt();
        System.out.println(max > (temp + x - k) ? "YES" : "NO");
    }
}


class a {
    a() {
        System.out.println("A");
    }

    String me() {
        return "a";
    }
}

class b extends a {
    b() {
        System.out.println("B");
    }

    @Override
    String me() {
        return "b";
    }
}
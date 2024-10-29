package testInterview;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @program: Src
 * @description: 测试
 * @author: wsj
 * @create: 2024-09-03 17:00
 **/

public class TryCatchFinal {
    public static String test() {
        String s = null;
        try {
            System.out.println("我是try里面的语句");
            System.out.println(s.length());
            return "我是try里的return语句";
        } catch (NullPointerException e) {
            System.out.println("我是catch语句里面语句1");
            return "我是catch语句里面的return语句1";
        } catch (Exception e) {
            System.out.println("我是catch语句里面语句2");
            return "我是catch语句里面的return语句2";
        } finally {
            System.out.println("我是finally里面的执行语句");
            return "我是finally里面的return语句";
        }
    }

    public static void main(String[] args) {
        System.out.println(test());
        // 不会走异常里面的return
        /**
         * 我是try里面的语句
         * 我是catch语句里面语句1
         * 我是finally里面的执行语句
         * 我是finally里面的return语句
         */
        int[][] map = {{1,3},{2,1},{5,2},{3,1},{4,3}};
        Arrays.sort(map, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int res = 0;
        for (int i = 0; i < map.length; i++) {
            int count = 0;
            for (int j = i; (j < map.length) && map[j][0] <= map[i][0] + 2; j++) {
                count += map[j][1];
            }
            res = Math.max(res,count);
        }
        System.out.println(res);

        //2. lambda表达式
        //Arrays.sort(map, (o1, o2) -> o1[0] - o2[0]);
        //3.
        //Arrays.sort(map, Comparator.comparingInt(o -> o[1]));
    }
}

package test;

import static sun.misc.Version.print;

public class Queue8 {
    int max = 8;
    int[] arr = new int[8];
    static int count = 0;
    static int judgeCount = 0;

    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.printf("一共%d个解法",count);
        System.out.printf("一共判断冲突的次数%d",judgeCount);


    }

    private void check(int n) {
        if(n == max) {
            print();
            return;
        }
        for (int i = 0; i < max; i++) {
            arr[n] = i;
            if(judge(n)) {   //不冲突
                check(n+1);
            }


        }
    }

    private boolean judge(int n) {
        judgeCount++;
        for (int i = 0; i < n; i++) {
            // arr[i] == arr[n]是否同一列，arr[i] - arr[n]是否同一斜对
            if(arr[i] == arr[n] || Math.abs(n-i) == Math.abs(arr[i] - arr[n]))   {
                return false;
            }

        }
        return true;

    }

    private void print() {
        count++;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

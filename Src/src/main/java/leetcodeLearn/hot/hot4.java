package leetcodeLearn.hot;

/**
 * @author wsj
 * @description  283 移动零
 * @date 2024年04月21日 13:04
 */
public class hot4 {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        fuc(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
       Integer m= Integer.valueOf(10) ;
       Integer n= Integer.valueOf(20);

        System.out.println(m == n);
        System.out.println(m.equals(n));

        Integer c = n;
        c = c - 10;
        Integer d = m +  10;
        System.out.println(m==c);//现在两个指向同一个地址，是true的
        System.out.println(n==d);//现在两个指向同一个地址，是true的


    }

    private static void fuc(int[] nums) {
        int l = 0;
        for(int i = 0; i<nums.length; i++) {
            if(nums[i] != 0) {
                int temp = nums[l];
                nums[l] = nums[i];
                nums[i] = temp;
                l++;
            }
        }
    }
}

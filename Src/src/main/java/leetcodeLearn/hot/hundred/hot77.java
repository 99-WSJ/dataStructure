package leetcodeLearn.hot.hundred;

/**
 * @author wsj
 * @description 121. 买卖股票的最佳时机
 * @date 2024年05月09日 15:35
 */
public class hot77 {
    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
        System.out.println(maxProfit(nums));
    }
    public static int maxProfit(int[] prices) {
        int min = 100000;
        int max = 0;
        for(int i : prices) {
            max = Math.max(max, i - min);
            min = Math.min(min, i);
        }
        return max;
    }
}

package leetcodeLearn.interview150;

/**
 * @author wsj
 * @description: TODO
 * @date 2024年08月09日 22:54
 */
public class Solution122 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int res = maxProfit(prices);
        System.out.println(res);
    }
    public static int maxProfit(int[] prices) {
        int sum = 0;
        for(int i = 1; i < prices.length; i++) {
            sum += Math.max(0, prices[i] - prices[i-1]);
        }
        return sum;
    }
}

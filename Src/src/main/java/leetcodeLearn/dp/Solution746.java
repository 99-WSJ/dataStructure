package leetcodeLearn.dp;

/**
 * @author wsj
 * @description 746 使用最小花费爬电梯
 * @date 2024年05月09日 9:05
 */
public class Solution746 {
    public static void main(String[] args) {
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        int res = minCostClimbingStairs(cost);

    }


    private static int minCostClimbingStairs(int[] cost) {
        int dp0 = 0;
        int dp1 = 0;
        for(int i = 2; i<=cost.length; i++) {
            int dp = Math.min(dp1 + cost[i-1], dp0 + cost[i-2]);
            dp0 = dp1;
            dp1 = dp;
            System.out.println(dp);
        }
        return dp1;
    }
}

package cn.weihuachao.leetcode;

public class BestTimeToBuyAndSellStockII {
    class Solution {
        public int maxProfit(int[] prices) {
            int ans = 0;
            int len = prices.length;
            for (int i = 1; i < len; ++i) {
                if (prices[i] > prices[i - 1]) {
                    ans += prices[i] - prices[i - 1];
                }
            }
            return ans;
        }
    }
}

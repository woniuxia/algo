package cn.weihuachao.leetcode;

public class ContainerWithMostWater {
    class Solution {
        public int maxArea(int[] height) {
            int i = 0;
            int j = height.length - 1;
            int ans = 0;
            while (i < j) {
                int tmp = Math.min(height[i], height[j]) * (j - i);
                ans = Math.max(ans, tmp);
                if (height[j] > height[i]) {
                    i++;
                } else {
                    j--;
                }
            }
            return ans;
        }
    }
}

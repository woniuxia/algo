package cn.weihuachao.leetcode;

public class TrappingRainWater {
    class Solution {
        public int trap(int[] height) {
            int ans = 0;
            if (height.length > 2) {
                int len = height.length;
                int[] left_max = new int[len];
                int[] right_max = new int[len];
                left_max[0] = height[0];
                right_max[len - 1] = height[len - 1];
                for (int i = 1; i < len; ++i) {
                    left_max[i] = Math.max(left_max[i - 1], height[i]);
                    right_max[len - 1 - i] = Math.max(right_max[len - i], height[len - 1 - i]);
                }
                for (int i = 1; i < len - 1; ++i) {
                    int tmp = Math.min(left_max[i], right_max[i]);
                    if (tmp > height[i]) {
                        ans += tmp - height[i];
                    }
                }
            }
            return ans;
        }
    }
}

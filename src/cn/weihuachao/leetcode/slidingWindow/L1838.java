package cn.weihuachao.leetcode.slidingWindow;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/frequency-of-the-most-frequent-element/
 */

public class L1838 {
    public int maxFrequency(int[] nums, int k) {
        if (nums.length == 1) {
            return 1;
        }
        Arrays.sort(nums);
        int l = 0;
        int total = 0;
        int res = 1;
        for (int r = 1; r < nums.length; r++) {
            total += (nums[r] - nums[r - 1]) * (r - l);
            while (total > k) {
                total -= (nums[r] - nums[l]);
                ++l;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}

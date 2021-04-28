package cn.weihuachao.leetcode;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length - 1 && i <= max; i++) {
            max = Math.max(max, i + nums[i]);
            if (max >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}

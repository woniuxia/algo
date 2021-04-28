package cn.weihuachao.leetcode;

class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        max[0] = nums[0];
        min[0] = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max[i] = Math.max(max[i - 1] * nums[i], min[i - 1] * nums[i]);
            max[i] = Math.max(max[i], nums[i]);
            ans = Math.max(ans, max[i]);
            min[i] = Math.min(min[i - 1] * nums[i], max[i - 1] * nums[i]);
            min[i] = Math.min(min[i], nums[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProduct(new int[]{2, -1, -2}));
    }
}
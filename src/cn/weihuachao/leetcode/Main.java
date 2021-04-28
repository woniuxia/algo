package cn.weihuachao.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    List<Boolean> hasApple;
    List<List<Integer>> v;

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        this.hasApple = hasApple;
        v = new ArrayList<>(hasApple.size());
        for (int i = 0; i < hasApple.size(); i++) {
            v.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            v.get(edge[0]).add(edge[1]);
        }
        int ans = dfs(0);
        if (ans > 0) {
            ans--;
        }
        return ans * 2;
    }

    public int dfs(int node) {
        if (v.get(node).size() > 0) {
            int tmp = 0;
            for (Integer integer : v.get(node)) {
                tmp += dfs(integer);
            }
            if (tmp > 0) {
                return tmp + 1;
            }
        }
        return hasApple.get(node) ? 1 : 0;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new LinkedList<>();
        if (nums == null || nums.length < 3)
            return ans;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; ++i) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i - 1 && nums[j] == nums[j - 1])
                    continue;
                int l = j + 1;
                int r = nums.length - 1;
                while (l < r) {
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1])
                            ++l;
                        while (l < r && nums[r] == nums[r - 1])
                            --r;
                        ++l;
                        --r;
                    } else if (sum > target) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }
        }

        return ans;
    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int res = 1;
        int[] ans = new int[nums.length];
        Arrays.fill(ans, 1);
        for (int i = 0; i < nums.length; i++) {
            int va = nums[i];
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < va) {
                    max = Math.max(max, ans[j]);
                }
            }
            ans[i] += max;
            res = Math.max(res, ans[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = new int[]{1, 2, 3, 5};
        int target = 11;
        System.out.println(main.lengthOfLIS(nums));
    }
}

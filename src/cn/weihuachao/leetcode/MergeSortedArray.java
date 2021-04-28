package cn.weihuachao.leetcode;

public class MergeSortedArray {
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int len = m + n - 1;
            int a = m - 1;
            int b = n - 1;
            while (a >= 0 || b >= 0) {
                if (a >= 0 && b >= 0) {
                    if (nums1[a] < nums2[b]) {
                        nums1[len--] = nums2[b--];
                    } else {
                        nums1[len--] = nums1[a--];
                    }
                } else if (b >= 0) {
                    nums1[len--] = nums2[b--];
                } else {
                    break;
                }
            }
        }
    }
}

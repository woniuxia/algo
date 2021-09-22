package cn.weihuachao.leetcode;

import java.util.Arrays;

public class HIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int max = Math.min(citations.length, citations[citations.length - 1]);
        int index = 0;
        int ans = 0;
        for (int i = 0; i <= max; i++) {
            while (citations[index] < i && index < citations.length - 1) {
                ++index;
            }
            if (index == citations.length - 1) {
                if (citations[index] >= i) {
                    if (1 >= i) {
                        return 1;
                    }
                } else {
                    return ans;
                }
            }
        }
        return 0;
    }
}

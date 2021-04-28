package cn.weihuachao.leetcode;

import java.util.HashSet;
import java.util.Set;

public class StringToIntegerAtoi {
    static class Solution {
        public int myAtoi(String str) {
            Set<Character> c = new HashSet<>();
            for (int i = 0; i < 10; ++i) {
                c.add((char) (48 + i));
            }
            boolean flag = false;
            int start = -1;
            int end = -1;
            for (int i = 0; i < str.length(); i++) {
                char c1 = str.charAt(i);
                if (c1 == ' ') {
                    continue;
                } else if (c1 == '-' || c1 == '+') {
                    if (c1 == '-') {
                        flag = true;
                    }
                    start = i + 1;
                    for (int j = start; j < str.length(); j++) {
                        if (c.contains(str.charAt(j))) {
                            end = j;
                        } else {
                            break;
                        }
                    }
                    break;
                } else if (c.contains(c1)) {
                    start = i;
                    for (int j = start; j < str.length(); j++) {
                        if (c.contains(str.charAt(j))) {
                            end = j;
                        } else {
                            break;
                        }
                    }
                    break;
                } else {
                    return 0;
                }
            }
            if (end < 0) {
                return 0;
            }
            long tmp = 0;
            for (int i = start; i <= end; ++i) {
                char t = str.charAt(i);
                tmp *= 10;
                tmp += t - 48;
                if (!flag && tmp > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                } else if (flag && -tmp < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            }
            if (flag) {
                tmp = -tmp;
            }
            return (int) tmp;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.myAtoi(" -42");
    }
}

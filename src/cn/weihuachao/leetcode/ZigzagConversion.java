package cn.weihuachao.leetcode;

public class ZigzagConversion {
    class Solution {
        public String convert(String s, int numRows) {
            if (numRows == 1){
                return s;
            }
            int tmp = numRows * 2 - 2;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < numRows; ++i) {
                if (i == 0 || i == numRows - 1) {
                    int count = 0;
                    while (count + i < s.length()) {
                        sb.append(s.charAt(count + i));
                        count += tmp;
                    }
                } else {
                    int j = tmp - i;
                    int count = 0;
                    while (count + i < s.length()) {
                        sb.append(s.charAt(count + i));
                        if (count + j < s.length()) {
                            sb.append(s.charAt(count + j));
                        }
                        count += tmp;
                    }
                }
            }
            return sb.toString();
        }
    }
}

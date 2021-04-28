package cn.weihuachao.leetcode;

public class LongestPalindromicSubstring {
    static class Solution {
        public String longestPalindrome(String s) {
            StringBuilder sb = new StringBuilder();
            sb.append("#");
            for (int i = 0; i < s.length(); i++) {
                char tmp = s.charAt(i);
                sb.append(tmp).append("#");
            }
            String ans = "";
            int count = 0;
            for (int i = 1; i < sb.length() - 1; ++i) {
                for (int j = 1; j <= sb.length() / 2; ++j) {
                    if (i - j >= 0 && i + j < sb.length() && sb.charAt(i - j) == sb.charAt(i + j)) {
                        if (j > count) {
                            count = j;
                            ans = sb.substring(i - j, i + j + 1);
                        }
                    } else {
                        break;
                    }
                }
            }
            return ans.replaceAll("#", "");
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("a"));
    }
}

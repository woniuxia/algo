package cn.weihuachao.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> ans = new ArrayList<>();
            aa(ans, 0, 0, n, "");
            return ans;
        }

        public void aa(List<String> ans, int l, int r, int n, String tmp) {
            if (l == r && l == n) {
                ans.add(tmp);
                return;
            }
            if (l < n) {
                aa(ans, l + 1, r, n, tmp + "(");
            }
            if (r < l) {
                aa(ans, l, r + 1, n, tmp + ")");
            }
        }

    }
}

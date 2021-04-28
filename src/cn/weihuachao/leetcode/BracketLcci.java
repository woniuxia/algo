package cn.weihuachao.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BracketLcci {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(n, 0, 0, "", res);
        return res;
    }

    public void dfs(int n, int left, int right, String tmp, List<String> res) {
        if (right == n) {
            res.add(tmp);
        } else if (left == n) {
            dfs(n, left, right + 1, tmp + ")", res);
        } else if (right == left) {
            dfs(n, left + 1, right, tmp + "(", res);
        } else if (left > right) {
            dfs(n, left + 1, right, tmp + "(", res);
            dfs(n, left, right + 1, tmp + ")", res);
        }
    }

    public static void main(String[] args) {
        BracketLcci bracketLcci = new BracketLcci();
        System.out.println(bracketLcci.generateParenthesis(3));
    }

}
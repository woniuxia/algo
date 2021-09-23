package cn.weihuachao.leetcode;

import cn.weihuachao.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        List<Integer> ss = new ArrayList<>();
        bfs(ss, s);
        List<Integer> tt = new ArrayList<>();
        bfs(tt, t);

        for (int i = 0; i < ss.size() - tt.size() + 1; i++) {
            for (int j = 0; j < tt.size(); j++) {
                if (!ss.get(i + j).equals(tt.get(j))) {
                    break;
                }
                if (j == tt.size() - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public void bfs(List<Integer> res, TreeNode s) {
        if (s == null) {
            res.add(-1);
            return;
        }
        res.add(s.val);
        bfs(res, s.left);
        bfs(res, s.right);
    }

    public static void main(String[] args) {

    }
}

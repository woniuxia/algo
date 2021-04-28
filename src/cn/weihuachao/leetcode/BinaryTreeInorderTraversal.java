package cn.weihuachao.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> ans = new LinkedList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode curr = root;
            while (curr != null || !stack.isEmpty()) {
                while (curr != null) {
                    stack.add(curr);
                    curr = curr.left;
                }
                curr = stack.pop();
                ans.add(curr.val);
                curr = curr.right;
            }
            return ans;
        }
    }
}

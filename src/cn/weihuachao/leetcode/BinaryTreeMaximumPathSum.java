package cn.weihuachao.leetcode;

import cn.weihuachao.leetcode.common.TreeNode;

public class BinaryTreeMaximumPathSum {

    int maxValue = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getSum(root);
        return maxValue;
    }

    public int getSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = getSum(node.left);
        left = Math.max(left, 0);
        int right = getSum(node.right);
        right = Math.max(right, 0);

        maxValue = Math.max(maxValue, left + right + node.val);
        int sum = 0;
        sum = Math.max(sum, node.val + left);
        sum = Math.max(sum, node.val + right);
        return sum;
    }
}

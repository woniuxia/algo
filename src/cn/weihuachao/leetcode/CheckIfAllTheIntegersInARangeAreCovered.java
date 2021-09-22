package cn.weihuachao.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckIfAllTheIntegersInARangeAreCovered {

    class Node implements Comparable<Node> {
        int left;
        int right;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Node o) {
            if (left == o.left) {
                return Integer.compare(right, o.right);
            }
            return Integer.compare(left, o.left);
        }
    }

    public boolean isCovered(int[][] ranges, int left, int right) {
        Node[] nodeArray = new Node[ranges.length];
        for (int i = 0; i < ranges.length; i++) {
            nodeArray[i] = new Node(ranges[i][0], ranges[i][1]);
        }
        Arrays.sort(nodeArray);
        int pos = 0;
        while (left <= right) {
            while (pos < ranges.length && nodeArray[pos].right< left) {
                pos++;
            }
            if (pos >= ranges.length) {
                return false;
            }
            if (nodeArray[pos].left > left) {
                return false;
            }
            left++;
        }
        return true;
    }
}

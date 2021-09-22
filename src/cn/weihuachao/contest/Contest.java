package cn.weihuachao.contest;

import cn.weihuachao.util.GenerateUtil;

import java.util.*;
import java.util.stream.Collectors;

public class Contest {

    static class Solution {
        public long maxPoints(int[][] points) {
            int row = points.length;
            int col = points[0].length;
            int[][] ans = new int[row][col];

            return 1L;
        }
    }

    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int[] adjacentPair : adjacentPairs) {
            map.putIfAbsent(adjacentPair[0], new ArrayList<Integer>());
            map.putIfAbsent(adjacentPair[1], new ArrayList<Integer>());
            map.get(adjacentPair[0]).add(adjacentPair[1]);
            map.get(adjacentPair[1]).add(adjacentPair[0]);
        }

        int n = adjacentPairs.length + 1;
        int[] ret = new int[n];
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int e = entry.getKey();
            List<Integer> adj = entry.getValue();
            if (adj.size() == 1) {
                ret[0] = e;
                break;
            }
        }

        ret[1] = map.get(ret[0]).get(0);
        for (int i = 2; i < n; i++) {
            List<Integer> adj = map.get(ret[i - 1]);
            ret[i] = ret[i - 2] == adj.get(0) ? adj.get(1) : adj.get(0);
        }
        return ret;
    }

    List<List<Integer>> quanpailie = new ArrayList<>();
    int[][] sum = null;

    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        sum = new int[students.length][students.length];
        for (int i = 0; i < students.length; i++) {
            for (int j = 0; j < mentors.length; j++) {
                sum[i][j] = calc(students[i], mentors[j]);
            }
        }
        int[] tmp = new int[students.length];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = i;
        }
        int ans = 0;
        for (int i = 0; i < quanpailie.size(); i++) {
            int tmpSum = 0;
            for (int j = 0; j < quanpailie.get(i).size(); j++) {
                tmpSum += sum[j][quanpailie.get(i).get(j)];
            }
            ans = Math.max(ans, tmpSum);
        }
        return ans;
    }

    public int calc(int[] a, int[] b) {
        int ans = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == b[i]) {
                ++ans;
            }
        }
        return ans;
    }

    public int compareVersion(String version1, String version2) {
        return 0;
    }

    public static void main(String[] args) {
        System.out.println("..".split("\\.").length);
    }
}

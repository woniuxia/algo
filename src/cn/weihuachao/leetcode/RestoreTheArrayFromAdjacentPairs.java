package cn.weihuachao.leetcode;

import cn.weihuachao.util.GenerateUtil;
import cn.weihuachao.util.PrintUtil;

import java.util.*;

public class RestoreTheArrayFromAdjacentPairs {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] adjacentPair : adjacentPairs) {
            int a = adjacentPair[0];
            int b = adjacentPair[1];
            map.putIfAbsent(a, new ArrayList<>());
            map.putIfAbsent(b, new ArrayList<>());
            map.get(a).add(b);
            map.get(b).add(a);
            count.merge(a, 1, Integer::sum);
            count.merge(b, 1, Integer::sum);
        }
        int cur = count.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .findFirst()
                .map(Map.Entry::getKey)
                .get();

        int[] ans = new int[adjacentPairs.length + 1];
        Set<Integer> has = new HashSet<>();
        has.add(cur);
        int pos = 0;
        ans[pos++] = cur;
        while (pos <= adjacentPairs.length) {
            List<Integer> l = map.get(cur);
            for (Integer integer : l) {
                if (!has.contains(integer)) {
                    ans[pos++] = integer;
                    has.add(integer);
                    cur = integer;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        RestoreTheArrayFromAdjacentPairs s = new RestoreTheArrayFromAdjacentPairs();
        int[][] input = GenerateUtil.getTwoArray("[[2,1],[3,4],[3,2]]");
        PrintUtil.print(s.restoreArray(input));
    }
}

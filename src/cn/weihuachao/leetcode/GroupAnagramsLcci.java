package cn.weihuachao.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagramsLcci {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> group = new HashMap<>();
        for (String str : strs) {
            char[] tmp = str.toCharArray();
            Arrays.sort(tmp);
            String newStr = String.valueOf(tmp);
            group.putIfAbsent(newStr, new ArrayList<>());
            group.get(newStr).add(str);
        }
        return group.values()
                .stream().collect(Collectors.toList());
    }
}

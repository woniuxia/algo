package cn.weihuachao.util;

import java.util.Arrays;
import java.util.stream.Collectors;

public class GenerateUtil {
    public static int[][] getTwoArray(String string) {
        string = string.replaceAll("],\\[", "|");
        string = string.replaceAll("\\[", "");
        string = string.replaceAll("]", "");
        String[] strings = string.split("\\|");
        int xx = strings[0].split(",").length;
        int[][] array = new int[strings.length][xx];
        for (int i = 0; i < strings.length; i++) {
            String strings1 = strings[i];
            String[] ss = strings1.split(",");
            Integer[] integers = new Integer[ss.length];
            integers = Arrays.stream(ss).map(Integer::valueOf).collect(Collectors.toList()).toArray(integers);
            for (int i1 = 0; i1 < integers.length; i1++) {
                array[i][i1] = integers[i1];
            }
        }
        return array;
    }
}

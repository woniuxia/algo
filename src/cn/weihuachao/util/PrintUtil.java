package cn.weihuachao.util;

public class PrintUtil {
    public static void print(int[] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            System.out.println(i + "\t" + arrays[i]);
        }
    }
    public static void print(int[][] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                System.out.print("\t" + arrays[i][j]);
            }
            System.out.println();
        }
    }
}

package cn.weihuachao.leetcode;

import cn.weihuachao.util.PrintUtil;

public class DecodeXoredPermutation {
    public int[] decode(int[] encoded) {
        int[] result = new int[encoded.length + 1];
        int total = 0;
        for (int i = 1; i <= encoded.length + 1; i++) {
            total ^= i;
        }
        for (int i = 0; i < encoded.length; i += 2) {
            total = total ^ encoded[i];
        }
        result[result.length - 1] = total;
        for (int i = result.length - 2; i >= 0; i--) {
            result[i] = encoded[i] ^ result[i + 1];
        }
        return result;
    }

    public static void main(String[] args) {
        DecodeXoredPermutation decodeXoredPermutation = new DecodeXoredPermutation();
        PrintUtil.print(decodeXoredPermutation.decode(new int[]{6, 5, 4, 6}));
    }
}

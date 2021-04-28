package cn.weihuachao.sort;

import java.util.Arrays;

public class MergeSort {

    public int[] sort(int[] sourceArray) {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        if (arr.length < 2) {
            return arr;
        }
        int middle = arr.length >> 1;
        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);
        return merge(sort(left), sort(right));
    }

    private int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0;
        int pl = 0;
        int pr = 0;
        while (pl < left.length && pr < right.length) {
            if (left[pl] <= right[pr]) {
                result[i++] = left[pl++];
            } else {
                result[i++] = right[pr++];
            }
        }
        while (pl < left.length) {
            result[i++] = left[pl++];
        }
        while (pr < right.length) {
            result[i++] = right[pr++];
        }
        return result;
    }

}
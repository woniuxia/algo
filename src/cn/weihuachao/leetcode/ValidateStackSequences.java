package cn.weihuachao.leetcode;

import java.util.Stack;

public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0;
        int j = 0;
        Stack<Integer> stack = new Stack<>();
        while (i < pushed.length && j < popped.length) {
            if (pushed[i] == popped[j]) {
                i++;
                j++;
            } else if (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            } else if (i < pushed.length) {
                stack.push(pushed[i++]);
            }
        }

        if (i == pushed.length && j == popped.length) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}

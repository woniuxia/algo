package cn.weihuachao.leetcode;

import java.util.Stack;

public class MinStack {

    Stack<Integer> sa = new Stack<>();
    Stack<Integer> sb = new Stack<>();

    public MinStack() {

    }

    public void push(int x) {
        sa.push(x);
        if (sb.isEmpty() || sb.peek() >= x) {
            sb.push(x);
        }
    }

    public void pop() {
        if (!sa.isEmpty()) {
            int tmp = sa.pop();
            if (sb.peek() == tmp) {
                sb.pop();
            }
        }
    }

    public int top() {
        return sa.peek();
    }

    public int getMin() {
        return sb.peek();
    }
}

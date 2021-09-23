package cn.weihuachao.leetcode.common;

public class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node(){}

    public Node(int val) {
        this.val = val;
    }
}
package cn.weihuachao.leetcode.linkedlist;

import cn.weihuachao.leetcode.common.Node;

public class FlattenAMultilevelDoublyLinkedList {

    Node curHead;

    public Node flatten(Node head) {
        Node newHead = new Node();
        newHead.next = head;
        curHead = newHead;
        dfs(head);
        newHead = newHead.next;
        if (newHead != null) {
            newHead.prev = null;
        }
        return newHead;
    }

    public void dfs(Node head) {
        if(head == null) {
            return;
        }
        while(head != null) {
            curHead.next = head;
            head.prev = curHead;
            curHead = head;
            if(head.child != null) {
                Node tmp = head.next;
                dfs(head.child);
                head.child = null;
                head = tmp;
            } else {
                head = head.next;
            }
        }
    }
}

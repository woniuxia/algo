package cn.weihuachao.leetcode;

public class ReverseLinkedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode tail = null;
            while (head != null) {
                ListNode tmp = head.next;
                head.next = tail;
                tail = head;
                head = tmp;
            }
            return tail;
        }
    }
}

package cn.weihuachao.leetcode;

import cn.weihuachao.leetcode.common.ListNode;

public class RemoveNthNodeFromEndOfList {
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode hou = head;
            while (n-- > 0) {
                hou = hou.next;
            }
            if (hou == null) {
                return head.next;
            }
            ListNode qian = head;
            while (hou.next != null) {
                hou = hou.next;
                qian = qian.next;
            }
            qian.next = qian.next.next;
            return head;
        }
    }
}

package cn.weihuachao.leetcode.linkedlist;

import cn.weihuachao.leetcode.common.ListNode;

public class SplitLinkedListToParts {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        if (head == null) {
            return ans;
        }
        int len = 0;
        ListNode tmp = head;
        while (tmp != null) {
            len++;
            tmp = tmp.next;
        }
        int count = len / k;
        int yu = len % k;
        for (int i = 0; i < k; i++) {
            ans[i] = head;
            for (int j = 0; j < k; j++) {
                head = head.next;
            }
            if (i< yu) {
                head =head.next;
            }
            tmp = head.next;
            head.next = null;
            head = tmp;
        }
        System.out.println();
        return ans;
    }
}

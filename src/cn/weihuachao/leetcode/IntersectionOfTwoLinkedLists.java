package cn.weihuachao.leetcode;

// https://leetcode-cn.com/problems/intersection-of-two-linked-lists/

public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tmpA = new ListNode();
        tmpA.next = headA;
        int lenA = 0;
        while (tmpA.next != null) {
            lenA++;
            tmpA = tmpA.next;
        }

        ListNode tmpB = new ListNode();
        tmpB.next = headB;
        int lenB = 0;
        while (tmpB.next != null) {
            lenB++;
            tmpB = tmpB.next;
        }
        if (tmpA == tmpB) {
            while (lenA > lenB) {
                --lenA;
                headA = headA.next;
            }
            while (lenA < lenB) {
                --lenB;
                headB = headB.next;
            }
            while (headA != headB) {
                headA = headA.next;
                headB = headB.next;
            }
            return headA;
        }
        return null;
    }
}

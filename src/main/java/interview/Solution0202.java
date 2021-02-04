package interview;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

/* leetcode 面试题02.02-返回倒数第k个节点 */

public class Solution0202 {
    public int kthToLast(ListNode head, int k) {
        ListNode first = head;
        ListNode second = head;
        // 第一个指针先走k步
        while (k-- > 0) {
            first = first.next;
        }
        // 然后两个指针在同时前进
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        return second.val;
    }
}

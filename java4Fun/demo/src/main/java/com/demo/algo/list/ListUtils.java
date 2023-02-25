package com.demo.algo.list;

import com.demo.entity.ListNode;

public class ListUtils {
    public static int getListLength(ListNode root) {
        if(root == null) {
            return 0;
        }
        int length = 0;
        ListNode cursor = root;

        while(cursor != null) {
            cursor = cursor.getNext();
            length++;
        }
        return length;
    }

    // 寻找链表的中间节点
    public static ListNode middleNode(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        int length = getListLength(head);
        int step = length % 2 == 0 ? length / 2 : (length - 1) / 2;
        ListNode cursor = head;
        for(int i = 0; i <step; i++) {
            cursor = cursor.next;
        }
        return cursor;
    }

    // https://leetcode.cn/problems/remove-nth-node-from-end-of-list
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) {
            return head;
        }
        if(head.next == null) {
            return null;
        }
        int length = getListLength(head);
        int step = length - 1;
        if(step == 0) {
            return head.next;
        }
        else {
            step--;
            ListNode cursor = head;
            for(int i = 0; i < step; i++) {
                cursor = cursor.next;
            }
            cursor.next = cursor.next.next;
            return head;
        }
    }
    // https://leetcode.cn/problems/reverse-linked-list
    // 反转链表
    public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode node1 = head;
        ListNode node2 = node1.next;
        ListNode node3 = node2.next;

        head.next = null;

        while(node3 != null) {
            node2.next = node1;
            node1 = node2;
            node2 = node3;
            node3 = node3.next;
        }
        node2.next = node1;
        return node2;
    }

    // https://leetcode.cn/problems/merge-two-sorted-lists
    // 合并两个有序链表
    public static ListNode mergeTwoLists(final ListNode list1, final ListNode list2) {
        if(list1 == null) {
            return list2;
        }

        if(list2 == null) {
            return list1;
        }

        ListNode cursor1 = list1;
        ListNode cursor2 = list2;

        ListNode cursor = new ListNode(0);

        while(cursor1 != null && cursor2 != null) {
            if(cursor1.val >= cursor2.val) {
                cursor.next = cursor2;
                cursor2 = cursor2.next;
            }
            else {
                cursor.next = cursor1;
                cursor1 = cursor1.next;
            }
            cursor = cursor.next;
        }

        while(cursor1 != null) {
            cursor.next = cursor1;
            cursor1 = cursor1.next;
            cursor = cursor.next;
        }

        while(cursor2 != null) {
            cursor.next = cursor2;
            cursor2 = cursor2.next;
            cursor = cursor.next;
        }

        return list1.val >= list2.val ? list2 : list1;
    }

    //https://leetcode.cn/problems/convert-binary-number-in-a-linked-list-to-intege
    public static int getDecimalValue(ListNode head) {
        int length = getListLength(head);
        int res = 0;
        while(head != null) {
            if(head.val == 1) {
                res += (head.val << (length - 1));
            }
            length--;
            head = head.next;
        }
        return res;
    }
}

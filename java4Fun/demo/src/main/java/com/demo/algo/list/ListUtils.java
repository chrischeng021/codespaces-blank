package com.demo.algo.list;

import com.demo.algo.entity.ListNode;

import java.util.List;

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
}

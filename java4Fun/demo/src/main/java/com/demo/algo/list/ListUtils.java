package com.demo.algo.list;

import com.demo.algo.entity.ListNode;

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

    public static ListNode middleNode(ListNode head) {
        if(head == null || head.getNext() == null) {
            return head;
        }

        int length = getListLength(head);
        int step = length % 2 == 0 ? length / 2 : (length - 1) / 2;
        ListNode cursor = head;
        for(int i = 0; i <step; i++) {
            cursor = cursor.getNext();
        }
        return cursor;
    }
}

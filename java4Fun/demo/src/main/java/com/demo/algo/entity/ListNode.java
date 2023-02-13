package com.demo.algo.entity;

import lombok.Data;

@Data
public class ListNode {
    private int val;
    private ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

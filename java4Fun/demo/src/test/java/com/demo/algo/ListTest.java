package com.demo.algo;

import com.demo.entity.ListNode;
import com.demo.algo.list.ListUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class ListTest {
    @Test
    public void testGetDecimalValue() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);
        assertEquals(5, ListUtils.getDecimalValue(head));
    }
}

package com.felix.general.code.daily.practice.common.data.struct;

import java.util.Collection;
import java.util.Iterator;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2024-01-03
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {

    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode buildListNode(Collection<Integer> nodes) {
        Iterator<Integer> iterator = nodes.iterator();
        if (iterator.hasNext()) {
            Integer firstNode = iterator.next();
            ListNode head = new ListNode(firstNode);
            ListNode op = head;
            while (iterator.hasNext()) {
                Integer nextVal = iterator.next();
                op.next = new ListNode(nextVal);
                op = op.next;
            }
            return head;
        }
        return null;
    }
}

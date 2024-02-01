package com.felix.general.code.daily.practice.leetcode.one;

import java.util.List;

import com.felix.general.code.daily.practice.common.data.struct.ListNode;
import com.google.common.collect.ImmutableList;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2024-01-03
 */
public class RemoveNodeFromList {
    public static ListNode removeNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 逆序链表
        ListNode reversed = reverseNode(head);
        ListNode op = reversed, ptr = op.next;
        // 递增序列
        while(ptr != null) {
            if (ptr.val >= op.val) {
                op.next = ptr;
                op = op.next;
            }
            ptr = ptr.next;
        }
        op.next = null;
        // 再逆序，得到正序
        return reverseNode(reversed);
    }

    public static ListNode reverseNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode op = head;
        ListNode ptr = head.next;
        head.next = null;
        while(ptr != null) {
            ListNode temp = ptr.next;
            ptr.next = op;
            op = ptr;
            ptr = temp;
        }
        return op;
    }

    public static ListNode insertReverse(ListNode head) {
        ListNode temp = new ListNode();
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = temp.next;
            temp.next = head;
            head = nextNode;
        }
        return temp.next;
    }

    public static void main(String[] args) {
        List<Integer> list = ImmutableList.of(1, 1, 1, 1);
        ListNode head = ListNode.buildListNode(list);
        ListNode newHead = removeNodes(head);
        System.out.println(newHead);
    }

}

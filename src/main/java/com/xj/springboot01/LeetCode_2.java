package com.xj.springboot01;

import com.xj.springboot01.relativeClass.ListNode;

/*
    题目：
        给出两个非空的链表用来表示两个非负的整数。
        其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。
        如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
        您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
    实例：
        输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
        输出：7 -> 0 -> 8
        原因：342 + 465 = 807
    解答：
        我们使用变量来跟踪进位，并从包含最低有效位的表头开始模拟逐位相加的过程。
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class LeetCode_2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode currNewNode = head;// 记录新链表的 当前新节点 ，开始是头节点
        ListNode p = l1, q = l2;
        int carry = 0;
        while(p!=null || q!=null){

            int x = p != null? p.val : 0;
            int y = q != null? q.val : 0;
            int sum = x + y + carry;
            carry = sum/10;
            currNewNode.next = new ListNode(sum%10);
            currNewNode = currNewNode.next;

            if (p!=null) { p = p.next; }
            if (q!=null) { q = q.next; }
        }
        if(carry > 0){ currNewNode.next = new ListNode(1); }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode L1 = new ListNode(2);
        L1.next = new ListNode(4);
        L1.next.next = new ListNode(5);

        ListNode L2 = new ListNode(9);
        L2.next = new ListNode(1);
        L2.next.next = new ListNode(8);

        ListNode sumL = addTwoNumbers(L1,L2);
        while(sumL != null){
            System.out.printf(sumL.val + " ");
            sumL = sumL.next;
        }
    }
}

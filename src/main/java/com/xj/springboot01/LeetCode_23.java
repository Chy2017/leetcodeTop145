package com.xj.springboot01;

import com.xj.springboot01.relativeClass.ListNode;
/*
    题目：------ 合并K个排序链表 ------
        合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
    示例：
        输入:
        [
          1->4->5,
          1->3->4,
          2->6
        ]
        输出: 1->1->2->3->4->4->5->6
    解答：
        二路归并，每次选两个链表合并新链表，再继续二路归并
        目前还未通过：129/131个通过用例
 */
public class LeetCode_23 {
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0){
            return null;
        }
        for (int i = 0; i < Math.log(lists.length-1) + 1; i++) {
            for (int j = 0; j < lists.length-1; j++) {
                if(j%(int)Math.pow(2,i+1) == 0 && j + (int)Math.pow(2,i) < lists.length){
                    lists[j] = mergeTwoLists(lists[j],lists[j + (int)Math.pow(2,i)]);
                }
            }
        }
        return lists[0];
    }
    public static ListNode mergeTwoLists(ListNode l1,ListNode l2){
        if(l1 == null || l2 == null){
            if(l1 == null && l2 == null)
                return null;
            else
                return l1 != null? l1 : l2;
        }
        if(l1.val <= l2.val){//l1的头元素 若小于等于 l2的头元素，l2往l1中插入
            ListNode p = l1, q = l2;
            while(q != null){
                while (p.next != null && p.next.val <= q.val){//寻找插入的位置
                    p = p.next;
                }
                if(p.next == null){
                    p.next = q;//p结束了，q还有，全部接在p的后面
                    break;
                }
                ListNode tmp = null;//记录，防止丢失
                if(q.next!=null){
                    tmp = q.next;
                }
                q.next = p.next;//插入节点操作
                p.next = q;
                q = tmp;//得到新的q
            }
        }else{//否则对调l1和l2
            l1 = mergeTwoLists(l2,l1);
        }
        return l1;
    }

    public static void main(String[] args) {
        ListNode l0 = new ListNode(-9);
        l0.next = new ListNode(-2);
        l0.next.next = new ListNode(3);

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode l5 = new ListNode(7);
        l5.next = new ListNode(14);

        ListNode l6 = new ListNode(15);
        l6.next = new ListNode(12);

        ListNode l7 = new ListNode(-8);
        l7.next = new ListNode(21);

        ListNode l8 = new ListNode(-3);
        l8.next = new ListNode(13);

        ListNode[] lists = {l0, l1, l2, l3, null, l5, l6, l7, l8};
        ListNode res = mergeKLists(lists);
        System.out.println("mergeKLists: ");
        while(res != null){
            System.out.printf(res.val + "  ");
            res = res.next;
        }

    }
}

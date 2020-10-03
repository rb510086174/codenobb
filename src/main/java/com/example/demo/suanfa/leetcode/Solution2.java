package com.example.demo.suanfa.leetcode;

/**
 * Created By RenBin6 on 2020/9/29 .
 */
public class Solution2 {
    public static void main(String[] args) {
        ListNode listNode2 = new ListNode(2);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        listNode2.next=  listNode3;
        listNode3.next=  listNode4;
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode44 = new ListNode(4);
        listNode5.next=  listNode6;
        listNode6.next=  listNode44;

        ListNode listNode = calcTwoListNodeAdd(listNode2, listNode5);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    static ListNode calcTwoListNodeAdd(ListNode ln1, ListNode ln2) {
        ListNode rootNode = new ListNode(-1), pre = rootNode;
       int t =0;
       while (ln1 != null || ln2 != null || t!=0){
           if (ln1 != null){
               t+=ln1.val;
               ln1 = ln1.next;
           }

           if (ln2 != null){
               t+=ln2.val;
               ln2 = ln2.next;
           }
           ListNode tmp = new ListNode(t % 10);
           pre.next = tmp;
           pre = tmp;
           t = t/10;
       }
        return rootNode.next;
    }
}

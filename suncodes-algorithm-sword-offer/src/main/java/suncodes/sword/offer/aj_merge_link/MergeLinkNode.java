package suncodes.sword.offer.aj_merge_link;

import suncodes.sword.offer.a0.ListNode;

public class MergeLinkNode {

    public static void main(String[] args) {

        ListNode listNode = new ListNode();
        listNode.data = 1;
        ListNode listNode1 = new ListNode();
        listNode.next = listNode1;

        listNode1.data = 2;
        ListNode listNode2 = new ListNode();
        listNode1.next = listNode2;

        listNode2.data = 4;

        ListNode l = new ListNode();
        l.data = 1;
        ListNode l1 = new ListNode();
        l.next = l1;

        l1.data = 3;
        ListNode l2 = new ListNode();
        l1.next = l2;

        l2.data = 4;

        ListNode listNode3 = new MergeLinkNode().mergeTwoLists(listNode, l);
        listNode3.print();
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 一开始设置一个虚拟节点，它的值为 -1，它的值可以设置为任何的数，因为我们根本不需要使用它的值
        ListNode dummy = new ListNode(-1);

        // 设置一个指针，指向虚拟节点
        ListNode pre = dummy;

        // 通过一个循环，不断的比较 l1 和 l2 中当前节点值的大小，直到 l1 或者 l2 遍历完毕为止
        while (l1 != null && l2 != null) {
            // 如果 l1 当前节点的值小于等于了 l2 当前节点的值
            if (l1.data <= l2.data) {
                // 让 pre 指向节点的 next 指针指向这个更小值的节点
                // 即指向 l1
                pre.next = l1;
                // 让 l1 向后移动
                l1 = l1.next;
            } else {
                // 让 pre 指向节点的 next 指针指向这个更小值的节点
                // 即指向 l2
                pre.next = l2;
                // 让 l2 向后移动
                l2 = l2.next;

            }
            // 让 pre 向后移动
            pre = pre.next;
        }

        // 跳出循环后，l1 或者 l2 中可能有剩余的节点没有被观察过
        // 直接把剩下的节点加入到 pre 的 next 指针位置

        // 如果 l1 中还有节点
        if (l1 != null) {
            // 把 l1 中剩下的节点全部加入到 pre 的 next 指针位置
            pre.next = l1;
        }

        // 如果 l2 中还有节点
        if (l2 != null) {
            // 把 l2 中剩下的节点全部加入到 pre 的 next 指针位置
            pre.next = l2;
        }

        // 最后返回虚拟节点的 next 指针
        return dummy.next;
    }
}

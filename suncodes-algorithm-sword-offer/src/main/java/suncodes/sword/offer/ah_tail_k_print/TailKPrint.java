package suncodes.sword.offer.ah_tail_k_print;

import suncodes.sword.offer.a0.ListNode;

public class TailKPrint {

    public ListNode getKthFromEnd(ListNode head, int k) {
        //初始化两个指针 former 和 latter，一开始都指向链表的头节点

        // 指针 former 指向链表的头节点
        ListNode former = head;

        // 指针 latter 指向链表的头节点
        ListNode latter = head;

        // 让 former 指针先向前走 k 步
        for (int i = 0; i < k; i++) {
            // former 指针向后移动
            former = former.next;
        }

        // 接下来，让这两个指针 former 和 latter 同时向前移动，直到前指针 former 指向 NULL
        while (former != null) {
            // former 指针向后移动
            former = former.next;
            // latter 指针向后移动
            latter = latter.next;
        }

        // 此时，由于 former 和 latter 之间的距离为 k
        // 所以 latter 指向的节点即是倒数第 k 个节点
        return latter;

    }
}

package suncodes.sword.offer.ai_reverse_link;

import suncodes.sword.offer.a0.ListNode;

public class ReverseLinkNode {
    public static void main(String[] args) {

        ListNode listNode = new ListNode();
        listNode.data = 1;
        ListNode listNode1 = new ListNode();
        listNode.next = listNode1;

        listNode1.data = 2;
        ListNode listNode2 = new ListNode();
        listNode1.next = listNode2;

        listNode2.data = 3;
        ListNode listNode3 = new ListNode();
        listNode2.next = listNode3;

        listNode3.data = 4;
        ListNode listNode4 = new ListNode();
        listNode3.next = listNode4;

        listNode4.data = 5;
        listNode4.next = null;

        printNode(listNode);
        ListNode reverse = reverse(listNode);
        printNode(reverse);
    }

    public static ListNode reverse(ListNode listNode) {
        ListNode prevNode = null;
        ListNode nextNode = null;
        while (listNode.next != null) {
            nextNode = copy(listNode.next);
            listNode.next = prevNode;
            prevNode = copy(listNode);
            listNode = nextNode;
        }
        listNode.next = prevNode;
        return listNode;
    }

    private static ListNode copy(ListNode listNode) {
        ListNode listNode1 = new ListNode();
        listNode1.data = listNode.data;
        listNode1.next = listNode.next;
        return listNode1;
    }

    private static void printNode(ListNode listNode) {
        if (listNode == null) {
            return;
        }
        while (listNode.next != null) {
            System.out.print(listNode.data + "--->");
            listNode = listNode.next;
        }
        System.out.print(listNode.data);
        System.out.println();
    }
}

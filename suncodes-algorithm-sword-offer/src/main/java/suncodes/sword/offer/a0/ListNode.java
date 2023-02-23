package suncodes.sword.offer.a0;

public class ListNode {
    public Integer data;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(Integer data) {
        this.data = data;
    }

    public void print() {
        ListNode listNode = this;
        while (listNode.next != null) {
            System.out.print(listNode.data + "--->");
            listNode = listNode.next;
        }
        System.out.print(listNode.data);
        System.out.println();
    }
}

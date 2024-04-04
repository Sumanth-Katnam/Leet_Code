package leetCode.LinkedLists;

public class ReverseLinkedList_206 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return null;

        ListNode prev = null, temp = head;

        while(temp != null){
            ListNode nxt = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nxt;
        }

        return prev;
    }
}

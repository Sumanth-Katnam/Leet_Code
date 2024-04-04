package leetCode.LinkedLists;

import helpers.ListNodeMain;
import helpers.ListNodeMain.ListNode;

public class SwapNodesInPairs_24 {
    public static ListNode swapPairs(ListNode head) {
        ListNode temp = new ListNode(999999999);
        temp.next = head;
        ListNode curr = temp;
        while(curr.next != null && curr.next.next != null){
            ListNode a = curr.next;
            ListNode b = curr.next.next;
            a.next = b.next;
            curr.next = b;
            curr.next.next = a;
            curr = curr.next.next;
        }
        return temp.next;
    }

    public static void main(String[] args) {
        int[] nodes = new int[] {1, 2, 3, 4, 5};
        ListNode head = ListNodeMain.populateListNode(nodes);
        head = swapPairs(head);
        ListNodeMain.displayNodes(head);
    }
}

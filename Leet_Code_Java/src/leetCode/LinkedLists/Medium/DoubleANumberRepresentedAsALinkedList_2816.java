package leetCode.LinkedLists.Medium;
import helpers.ListNodeMain.ListNode;

public class DoubleANumberRepresentedAsALinkedList_2816 {
    public ListNode doubleIt(ListNode head) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode prev = temp;
        ListNode curr = head;
        while (curr != null){
            prev.val += (curr.val * 2) / 10;
            curr.val = (curr.val * 2) % 10;
            prev = curr;
            curr = curr.next;
        }
        return temp.val == 0? temp.next: temp;
    }
}

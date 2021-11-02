package leetCode;

import helpers.ListNodeMain;
import helpers.ListNodeMain.ListNode;
public class RemoveDuplicatesFromSortedList_83 {
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return null;
        else{
            ListNode current = head;
            while(current.next != null){
                if(current.val == current.next.val){
                    current.next = current.next.next;
                    continue;
                }
                current = current.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] nodes = new int[]{1, 1, 2,2,2,2,2,2, 3, 3,4,4,4,4,4,5,6,7};
        ListNode head = ListNodeMain.populateListNode(nodes);
        head = deleteDuplicates(head);
        ListNodeMain.displayNodes(head);
    }
}

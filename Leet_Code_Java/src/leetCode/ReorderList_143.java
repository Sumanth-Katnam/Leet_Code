package leetCode;

public class ReorderList_143 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public void reorderList(ListNode head) {
//         make two lists
        ListNode l1 = head;
        ListNode l2 = head.next;
        while(l2 != null && l2.next != null){
            l1 = l1.next;
            l2 = l2.next.next;
        }



//         Reverse the second half
        ListNode currHead = l1.next;
        l1.next = null;
        ListNode prev = null;

        while(currHead != null){
            ListNode temp = currHead.next;
            currHead.next = prev;
            prev = currHead;
            currHead = temp;
        }


//         Merge one after the other
        ListNode first = head, second = prev;
        while(second != null){
            ListNode tmp1 = first.next, tmp2 = second.next;
            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second =  tmp2;
        }

    }
}

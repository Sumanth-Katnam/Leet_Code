package leetCode.LinkedLists.Easy;

import helpers.ListNodeMain;

public class LinkedListCycle_141 {
    public static boolean hasCycle(ListNodeMain.ListNode head) {
        ListNodeMain.ListNode a = head;
        ListNodeMain.ListNode b = head;
        do{
            if(b == null || b.next == null){
                return false;
            }
            a = a.next;
            b = b.next.next;
        } while(a != b);
        return true;
    }

    public static void main(String[] args) {

    }
}

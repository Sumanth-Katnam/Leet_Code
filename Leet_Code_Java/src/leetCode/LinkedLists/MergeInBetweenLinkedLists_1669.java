package leetCode.LinkedLists;

public class MergeInBetweenLinkedLists_1669 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int pos = 0;
        ListNode res = new ListNode(-1);
        ListNode dummy = res;
        while(list1 != null){
            if(pos == a){
                while (list2 != null){
                    dummy.next = list2;
                    dummy = dummy.next;
                    list2 = list2.next;
                }
            }

            if(pos - 1 == b){
                dummy.next = list1;
                return res.next;
            }

            if(pos < a) {
                dummy.next = list1;
                dummy = dummy.next;
            }

            pos++;
            list1 = list1.next;
        }

        return null;
    }
}

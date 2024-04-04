package leetCode.LinkedLists;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoveZeroSumConsecutiveNodesFromLinkedList_1171 {
    /**
     * Definition for singly-linked list.*/
     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public ListNode removeZeroSumSublists(ListNode head) {
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//        int pre_sum = 0;
//        Map<Integer, ListNode> pre_sums = new HashMap<>();
//        pre_sums.put(0, dummy);
//        ListNode temp = head;
//
//        while(temp != null){
//            pre_sum += temp.val;
//            if(pre_sums.containsKey(pre_sum)){
//                ListNode to_delete = pre_sums.get(pre_sum).next;
//                int temp_sum = pre_sum + to_delete.val;
//
//                while(to_delete != temp){
//                    pre_sums.remove(temp_sum);
//                    to_delete = to_delete.next;
//                    temp_sum += to_delete.val;
//                }
//
//                pre_sums.get(pre_sum).next = temp.next;
//            } else {
//                pre_sums.put(pre_sum, temp);
//            }
//
//            temp = temp.next;
//        }
//
//        return dummy.next;
        if(head == null)
            return head;
        ListNode prev = null;
        ListNode cur = head;
        int  running_sum = 0;
        while(cur != null)
        {
            running_sum += cur.val;
            if(running_sum == 0)
            {
                if(prev == null)
                    head = cur.next;
                else
                    prev.next = cur.next;
                return removeZeroSumSublists(head);
            }
            cur = cur.next;
        }
        head.next = removeZeroSumSublists(head.next);
        return head;
    }
}

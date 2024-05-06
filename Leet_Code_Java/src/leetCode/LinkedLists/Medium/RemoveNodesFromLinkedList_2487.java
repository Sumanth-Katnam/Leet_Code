package leetCode.LinkedLists.Medium;


import helpers.ListNodeMain.ListNode;

import java.util.Stack;

public class RemoveNodesFromLinkedList_2487 {
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> stk = new Stack<>();
        ListNode curr = head;

        while(curr != null){
            while(!stk.isEmpty() && stk.peek().val < curr.val){
                stk.pop();
            }
            stk.add(curr);
            curr = curr.next;
        }

        ListNode next = null;
        while(!stk.isEmpty()){
            curr = stk.pop();
            curr.next = next;
            next = curr;
        }
        return curr;
    }
}

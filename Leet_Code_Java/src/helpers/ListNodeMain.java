package helpers;

public class ListNodeMain {
    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode() {}
        public ListNode(int val) { this.val = val; }
        public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode populateListNode(int[] nodes){
        ListNode head = null;
        ListNode curr = null;
        ListNode temp;
        for (int i : nodes) {
            temp = new ListNode(i);
            temp.next = null;
            if(head == null){
                head = temp;
                curr = temp;
                continue;
            }
            curr.next = temp;
            curr = curr.next;
        }
        return head;
    }

    public static void displayNodes(ListNode head) {
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}

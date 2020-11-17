public class Q203RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return head;
        }
        ListNode now = head;
        while (now.next != null){
            if(now.next.val == val){
                now.next = now.next.next;
            } else {
                now = now.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Q203RemoveLinkedListElements A = new Q203RemoveLinkedListElements();
        ListNode c1 = new ListNode(1);
        ListNode c2 = new ListNode(2);
        ListNode c3 = new ListNode(3);
        ListNode c4 = new ListNode(2);
        ListNode c5 = new ListNode(1);
        c1.next = c2;
        c2.next = c3;
        c3.next = c4;
        c4.next = c5;
        System.out.println(A.removeElements(c1, 1).val);
    }
}


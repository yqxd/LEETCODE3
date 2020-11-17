import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Q206ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        List<ListNode> A = new ArrayList<ListNode>();
        A.add(null);
        while (head != null) {
            A.add(head);
            head = head.next;
        }
        for(int i = A.size() - 1; i > 0; i--){
            A.get(i).next = A.get(i-1);
        }
        return A.get(A.size() - 1);
    }
    public static void main(String[] args){
        System.out.println("123");
    }
}

package janurary;

import utils.ListNode;
import java.util.*;

public class Solution143 {
    public void reorderList(ListNode head) {
        update(head);
    }

    private void update(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode next = head.next; // 2
        if(next.next == null) return;
        head.next = dps(head); // 4
        head.next.next = next;
        update(next);
    }

    ListNode temp;

    private ListNode dps(ListNode head) {
        if(head.next.next != null) return dps(head.next);
        temp = head.next;
        head.next = null;
        return temp;
    }
}

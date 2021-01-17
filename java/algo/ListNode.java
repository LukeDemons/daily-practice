package algo;

/**
 * @author yanchuang
 * @date 2020/7/4
 */
public class ListNode {

    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "\t");
            head = head.next;
        }
    }

    public static ListNode init(int... arr) {
        ListNode head = new ListNode(0);
        ListNode dummy = head;
        for (int i : arr) {
            head.next = new ListNode(i);
            head = head.next;
        }

        return dummy.next;
    }
}

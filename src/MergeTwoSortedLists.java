package src;

public class MergeTwoSortedLists {

    public class ListNode {
        // instance variables
        int val;
        ListNode next;

        // Constructors
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next;}
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 != null) {
            return new ListNode(list2.val, list2.next);
        } else if (list1 != null && list2 == null) {
            return new ListNode(list1.val, list1.next);
        } else if (list1 == null && list2 == null) {
            return list1;
        }

        if (list1.val < list2.val) {
            return new ListNode(list1.val, mergeTwoLists(list1.next, list2));
        }
        return new ListNode(list2.val, mergeTwoLists(list1, list2.next));
    }

    public static void main(String[] args) {}
}

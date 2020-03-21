
class MergeTwoLists {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // keep track of head with pointer to same address
        ListNode headOrg = new ListNode(0);
        ListNode head = headOrg;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                head.next = l2;
                l2 = l2.next;
            } else {
                head.next = l1;
                l1 = l1.next;
            } 
            head = head.next;
        }
        if (l1 != null && l2 == null) {
            head.next = l1;
        }
        if (l1 == null && l2 != null) {
            head.next = l2;
        }
        return headOrg.next;
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode newHead = new ListNode(head.val);
        ListNode currI = newHead;
        ListNode currJ = head;
        int currVal = head.val;
        int iter = 0;
        while (currJ != null) {
            if (iter == 0) {
                currVal = currI.val;
                currJ = currJ.next;
                iter++;
                continue;
            }
            if (currJ.val != currVal) {
                currI.next = new ListNode(currJ.val); //i++
                currI = currI.next;
                currVal = currJ.val;
            }
            currJ = currJ.next;
        }
        return newHead; 
    }

    public static void main(String[] args) {
        ListNode a = new MergeTwoLists.ListNode(1);
        ListNode b = new MergeTwoLists.ListNode(1);
        a.next = new MergeTwoLists.ListNode(2);
        a.next.next = new MergeTwoLists.ListNode(4);
        b.next = new MergeTwoLists.ListNode(3);
        b.next.next = new MergeTwoLists.ListNode(4);
        ListNode c = new MergeTwoLists.ListNode(0);
        c.next = new MergeTwoLists.ListNode(0);
        c.next.next = new MergeTwoLists.ListNode(1);
        c.next.next.next = new MergeTwoLists.ListNode(1);
        c.next.next.next.next = new MergeTwoLists.ListNode(2);
        c.next.next.next.next.next = new MergeTwoLists.ListNode(2);
        ListNode ret = deleteDuplicates(c);
        mergeTwoLists(a, b);
    }
}
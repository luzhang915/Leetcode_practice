/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution1 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while (l1!=null || l2!=null){
            if (l1==null){
                curr.next = new ListNode(l2.val);
                l2 = l2.next;
                curr = curr.next;
                System.out.print(1);
            }
            else if (l2==null){
                curr.next = new ListNode(l1.val);
                l1 = l1.next;
                curr = curr.next;
                System.out.print(2);

            }
            else if (l1.val<=l2.val){
                curr.next = new ListNode(l1.val);
                l1 = l1.next;
                curr = curr.next;
                System.out.print(3);
            }
            else if (l1.val>l2.val){
                curr.next = new ListNode(l2.val);
                l2 = l2.next;
                curr = curr.next;
                System.out.print(4);

            }
        }
        return head.next;
    }
}

class Solution2 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null) return l2;
        else if (l2==null) return l1;
        else if (l1.val<=l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // solution1: scan thru the linked list and put them into an arraylist, find the last nth item and  remove
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ArrayList<ListNode> temp = new ArrayList<>();
        ListNode sol = head;
        while (head!=null) {
            temp.add(head);
            head = head.next;
        }
        if (temp.size()<=1) return null;
        if (temp.size() - n >= 1) {
            if (n!=1) {
                temp.get(temp.size()-n-1).next = temp.get(temp.size()-n+1);
            }
            else {
                temp.get(temp.size()-n-1).next = null;
            }
        }
        else {
            sol = temp.get(1);
        }
        return sol;
    }
    
    // solution2: use 2 pointers, which have a gap size of n
    public ListNode removeNthFromEnd(ListNode head,int n) {
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode first = start;
        ListNode last = start;
        
        for (int i=0; i<=n; i++) {
            last = last.next;
        }
        
        while (last!=null) {
            last = last.next;
            first = first.next;
        }
        ListNode temp = first.next.next;
        first.next = temp;
        return start.next;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode List1, ListNode List2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while(List1!= null && List2!= null){
            if(List1.val >= List2.val){
                tail.next = List2;
                List2 = List2.next;
            } else{ 
                tail.next = List1;
                List1 = List1.next;
            }
            tail=tail.next;
        }

        if(List1!=null) tail.next = List1;
        if(List2!=null) tail.next = List2;

        return dummy.next;
    }
}

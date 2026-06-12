class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;

        ListNode slow=head;
        ListNode fast=head;

        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode secondHalfHead = reverseList(slow.next);

        ListNode firstHalfHead = head;
        ListNode p2 = secondHalfHead;
        boolean isPalin = true;

        while(p2!=null){
            if(firstHalfHead.val!=p2.val){
                isPalin = false;
                return false;
            }
            firstHalfHead=firstHalfHead.next;
            p2=p2.next;
        }
        slow.next = reverseList(secondHalfHead);
        return isPalin;
    }

    private ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;

        while(curr!=null){
            ListNode nextNode = curr.next;
            curr.next=prev;
            prev = curr;
            curr=nextNode;
        }
        return prev;
    }
}

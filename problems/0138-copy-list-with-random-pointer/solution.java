/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        
        Node curr = head;
        while (curr != null){
            Node nextNode = curr.next;
            Node cloneNode = new Node(curr.val);
            curr.next = cloneNode;
            cloneNode.next = nextNode;
            curr = nextNode;
        }
        
        curr = head;
        while (curr != null){
            if (curr.random != null){
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        
        curr = head;
        Node dummy = new Node(0);
        Node copy = dummy;
        
        while (curr != null){
            Node nextNode = curr.next.next;
            
            copy.next = curr.next;
            copy = copy.next;           
            curr.next = nextNode;
            curr = nextNode;
        }
        
        return dummy.next;
    }
}


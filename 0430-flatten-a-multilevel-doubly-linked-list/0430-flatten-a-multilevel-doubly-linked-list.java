class Solution {
    public Node flatten(Node head) {
        if (head == null)
            return null;

        Node curr = head;

        while (curr != null) {

            if (curr.child != null) {

                Node next = curr.next;

                // Flatten child list
                Node childHead = flatten(curr.child);

                curr.next = childHead;
                childHead.prev = curr;
                curr.child = null;

                // Find tail of child list
                Node tail = childHead;
                while (tail.next != null) {
                    tail = tail.next;
                }

                // Connect back to original next
                tail.next = next;
                if (next != null) {
                    next.prev = tail;
                }
            }

            curr = curr.next;
        }

        return head;
    }
}
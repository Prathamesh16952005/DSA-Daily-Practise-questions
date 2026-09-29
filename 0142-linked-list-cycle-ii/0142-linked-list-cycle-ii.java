/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode s = head;
        ListNode f = head;
        boolean  c = false;
             while(f!=null&&f.next!=null){
            s = s.next;
            f = f.next.next;
            if(s==f){
               c= true;
               break;
            }
        }
             if(!c){
                return null;
             }
            

           s=head;
        while(s!=f){
            s=s.next;
            f=f.next;
        }
        return s;    
    }
}
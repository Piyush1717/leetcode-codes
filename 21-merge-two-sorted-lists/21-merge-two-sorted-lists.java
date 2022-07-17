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
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        
         ListNode temp=new ListNode(0);
     ListNode res=temp;
     
     while(head1!=null && head2!=null)
     {
         if(head1.val<head2.val)
         {
             temp.next=head1;
             temp=temp.next;
             head1=head1.next;
         }
         else
         {
             
             temp.next=head2;
             temp=temp.next;
             head2=head2.next;
         }
     }
     
     while(head1!=null)
     {
             temp.next=head1;
             temp=temp.next;
             head1=head1.next;
     }
     
     
     while(head2!=null)
     {
             temp.next=head2;
             temp=temp.next;
             head2=head2.next;
     }
     
     return res.next;
     
        
    }
}
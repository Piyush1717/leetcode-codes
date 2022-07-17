/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        
         ListNode curr1=head1;
         int count1=1;
         
         while(curr1.next!=null)
         {
             curr1=curr1.next;
             count1++;
         }
         
         
         
         
         ListNode curr2=head2;
         int count2=1;
         
         while(curr2.next!=null)
         {
             curr2=curr2.next;
             count2++;
         }
         
         int d=Math.abs(count1-count2);
         
         if(count1<count2)
         {
             for(int i=0;i<d;i++)
             {
                 head2=head2.next;
             }
         }
         else
         {
             for(int i=0;i<d;i++)
             {
                 head1=head1.next;
             }
         }
         
         while(head1!=head2)
         {
             head1=head1.next;
             head2=head2.next;
         }
         
         return head1;
        
        
    }
}
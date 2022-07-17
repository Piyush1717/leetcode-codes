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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        int count=0;
    	ListNode curr=head;
    	while(curr!=null)
    	{
    	    curr=curr.next;
    	    count++;
    	}
        
        if(count==n)
        {
            head=head.next;
            return head;
        }
        
     
    
    	int N=count-n;
    	ListNode ans=head;
    	for(int i=0;i<N-1;i++)
    	{
    	    ans=ans.next;
    	}
    	
        ans.next=ans.next.next;
        
        return head;
    	
    	
    	
        
        
    }
}
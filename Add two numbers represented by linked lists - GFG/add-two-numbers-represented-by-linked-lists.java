//{ Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(first, second);
            printList(res);
        }
    }
}

// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    //Function to add two numbers represented by linked list.
    static Node addTwoLists(Node first, Node second){
        // code here
        // return head of sum list
        
        first=reverse(first);
        second=reverse(second);
        
        Node dummy=new Node(0);
        Node temp=dummy;
        
        int carry=0;
        
        while(first!=null || second!=null || carry!=0)
        {
            int sum=0;
            
            if(first!=null)
            {
                sum+=first.data;
                first=first.next;
            }
            
            
            if(second!=null)
            {
                sum+=second.data;
                second=second.next;
            }
            
            
            sum+=carry;
            carry=sum/10;
            
            Node node=new Node(sum%10);
            temp.next=node;
            temp=temp.next;
        }
        //return dummy.next;
        Node ans=reverse(dummy.next);
        return ans;
        
    }
    
    public static Node reverse(Node head)
    {
        Node curr=head;
        Node prev=null;
        
        while(curr!=null)
        {
            Node nex=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nex;
        }
        
        return prev;
        
        
        
    }
    
    
}
//{ Driver Code Starts
import java.io.*;
import java.util.*;
class Node
{
    int data;
    Node next;
    
    Node(int x)
    {
        data = x;
        next = null;
    }
}
class GfG
{
    public static void printList(Node node) 
    { 
        while (node != null)
        { 
            System.out.print(node.data);
            node = node.next; 
        }  
        System.out.println();
    } 
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Node head = new Node( s.charAt(0) - '0' );
                    Node tail = head;
                    for(int i=1; i<s.length(); i++)
                    {
                        tail.next = new Node( s.charAt(i) - '0' );
                        tail = tail.next;
                    }
                    Solution obj = new Solution();
                    head = obj.addOne(head);
                    printList(head); 
                }
        }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
} 
*/

class Solution
{
    public static Node addOne(Node head) 
    { 
        //code here.
        
        head=reverse(head);
        
        Node temp=head;
        
        while(temp!=null)
        {
            if(temp.data!=9)
            {
                temp.data++;
                break;
            }
            else if(temp.data==9 && temp.next!=null)
            {
                temp.data=0;
                temp=temp.next;
            }
            else
            {
          temp.data=0;
          Node extra=new Node(1);
          temp.next=extra;
            break;
            }
            
        }
        
        return reverse(head);
        
    }
    
    public static Node reverse(Node head)
    {
        Node prev=null;
        Node curr=head;
        Node nex=null;
        
        if(head==null || head.next==null )
        {
            return head;
        }
        
        while(curr!=null)
        {
            nex=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nex;
        }
        
        return prev;
    }
    
    
    
}

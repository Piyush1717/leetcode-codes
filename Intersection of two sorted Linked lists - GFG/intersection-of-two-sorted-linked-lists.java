//{ Driver Code Starts
import java.io.*;
import java.util.*;
class Node 
{
    int data;
    Node next;
    
    Node(int a)
        {
            data = a;
            next = null;
        }
}
class GfG
{
    static Scanner sc = new Scanner(System.in);
    public static Node inputList(int size)
    {
        Node head, tail;
        int val;
        
        val = sc.nextInt();
        
        head = tail = new Node(val);
        
        size--;
        
        while(size-->0)
        {
            val = sc.nextInt();
            tail.next = new Node(val);
            tail = tail.next;
        }
        
        return head;
    }
    
    public static void printList(Node n)
    {
        while(n!=null)
        {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }
    
    public static void main(String args[])
        {
            
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n , m;
                    
                    n = sc.nextInt();
                    m = sc.nextInt();
                    
                    Node head1 = inputList(n);
                    Node head2 = inputList(m);
                    
                    Sol obj = new Sol();
                    
                    Node result = obj.findIntersection(head1, head2);
	    
	                printList(result);
	                System.out.println();
                }
        }
}
// } Driver Code Ends


/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/

class Sol
{
   public static Node findIntersection(Node head1, Node head2)
    {
        // code here.
        
        HashMap<Integer, Integer> map=new HashMap<>();
        
        Node curr=head1;
        
        while(curr!=null)
        {
            int val=curr.data;
            map.put(val, map.getOrDefault(val,0)+1);
            curr=curr.next;
            
        }
        
        Node dummy=new Node(0);
        Node temp=dummy;
        
        curr=head2;
        
        while(curr!=null)
        {
            int val=curr.data;
            if(map.containsKey(val))
            {
                Node node=new Node(val);
                temp.next=node;
                temp=temp.next;
                
                int freq=map.get(val);
                
                if(freq==1)
                {
                    map.remove(val);
                }
                else
                {
                    map.put(val, freq-1);
                }
            }
            
            curr=curr.next;
            
        }
        
        return dummy.next;
        
        
    }
}
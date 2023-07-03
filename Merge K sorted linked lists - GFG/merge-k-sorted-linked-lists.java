//{ Driver Code Starts
import java.util.*;

class Node
{
    int data;
    Node next;
    
    Node(int key)
    {
        data = key;
        next = null;
    }
}


class GfG
{
    public static void printList(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while(t-- > 0)
        {   
            int N = sc.nextInt();
            
            Node []a = new Node[N];
            
            for(int i = 0; i < N; i++)
            {
                int n = sc.nextInt();
                
                Node head = new Node(sc.nextInt());
                Node tail = head;
                
                for(int j=0; j<n-1; j++)
                {
                    tail.next = new Node(sc.nextInt());
                    tail = tail.next;
                }
                
                a[i] = head;
            }
            
            Solution g = new Solution();
             
            Node res = g.mergeKList(a,N);
            if(res!=null)
                printList(res);
            System.out.println();
        }
    }
}
// } Driver Code Ends


/*class Node
{
    int data;
    Node next;
    
    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

// a is an array of Nodes of the heads of linked lists
// and N is size of array a


class Solution
{
     public static class pair implements Comparable<pair>{
        int value;
        Node node;
        
        pair(int value, Node node)
        {
            this.value=value;
            this.node=node;
        }
        
        public int compareTo(pair n)
        {
            // if(this.value<=n.value)
            // {
            //     return -1;
            // }
            // else
            // {
            //     return 1;
            // }
            
            return this.value-n.value;
        }
    }
    
    
    
    //Function to merge K sorted linked list.
    Node mergeKList(Node[]arr,int k)
    {
        //Add your code here.
        
          PriorityQueue<pair> pq=new PriorityQueue<>();
        
        for(int i=0;i<k;i++)
        {
            pq.add(new pair(arr[i].data,arr[i]));
        }
        
        Node dummy=new Node(0);
        Node temp=dummy;
        
        
        while(pq.isEmpty()==false)
        {
            pair p=pq.poll();
            
          if(p.node.next!=null)
          {
              pq.add(new pair(p.node.next.data, p.node.next));
          }
          
            Node n=new Node(p.value);
          
            temp.next=n;
            temp=n;
            
            
          
            
            
            
        }
        
      return dummy.next;  
        
    }
}

// { Driver Code Starts
//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
        	    Solution ob=new Solution();
                ob.flatten(root);
                printInorder(root);
                System.out.println();
                    t--;
            
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static class pair{
        Node head;
        Node tail;
        
        pair(){
        }
        
        pair(Node head, Node tail)
        {
            this.head=head;
            this.tail=tail;
        }
        
    }
    
    public static void flatten(Node root)
    {
        if(root==null)
        {
            return ;
        }
        helper(root);
    }
    
    public static pair helper(Node root)
    {
        if(root.left!=null && root.right!=null)
        {
            pair lp=helper(root.left);
            pair rp=helper(root.right);
            
            pair mp=new pair();
            mp.head=root;
            mp.head.left=null;
            mp.head.right=lp.head;
            lp.tail.right=rp.head;
            mp.tail=rp.tail;
            
            return mp;
        }
        else if(root.left!=null)
        {
            pair lp=helper(root.left);
            
            pair mp=new pair();
            mp.head=root;
            mp.head.left=null;
            mp.head.right=lp.head;
            mp.tail=lp.tail;
            
            return mp;
            
        }
        else if(root.right!=null)
        {
            
            pair rp=helper(root.right);
            
            pair mp=new pair();
            mp.head=root;
            mp.head.left=null;
            mp.head.right=rp.head;
            mp.tail=rp.tail;
            
            return mp;
            
            
            
        }
        else
        {
            pair mp=new pair(root,root);
            return mp;
        }
        
        
        
    }
    
    
    
}
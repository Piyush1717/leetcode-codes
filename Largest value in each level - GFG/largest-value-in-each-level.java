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

class Tree {
    
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
    	    	
                Solution g = new Solution();
               ArrayList<Integer> ans = g.largestValues(root);
               
                for(int i=0;i<ans.size();i++)
                    System.out.print(ans.get(i)+" ");
                    
                System.out.println();
        	
                t--;
            
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int max(ArrayList<Integer>arr)
    {
        int max=Integer.MIN_VALUE;;
        for(int i=0;i<arr.size();i++)
        {
            if(arr.get(i)>max)
            {
                max=arr.get(i);
            }
        }
        return max;
        
        
    }
    
    public ArrayList<Integer> largestValues(Node root)
    {
        ArrayList<Integer> res=new ArrayList<>();
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        
        while(q.size()>0)
        {
            int size=q.size();
            ArrayList<Integer> ans=new ArrayList<>();
            while(size-->0)
            {
                Node temp=q.poll();
                
                ans.add(temp.data);
                
                if(temp.left!=null)
                {
                    q.add(temp.left);
                }
                
                
                if(temp.right!=null)
                {
                    q.add(temp.right);
                }
            }
            int m=max(ans);
            res.add(m);

        }
        return res;
        
    }
}
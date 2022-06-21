// { Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.io.*;

class Node { 
	int data; 
	Node left, right; 
	Node(int d) { 
		data = d; 
		left = right = null; 
	} 
} 


class GFG {
	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    String[] inputline = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputline[0]);
            inputline = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputline[i]);
            }
            
            Node res = post_order(arr, n);
            printPostorder(res);
            System.out.println();
        }
    }
    
    
    
    
 // } Driver Code Ends
//User function Template for Java


//Function that constructs BST from its preorder traversal.
public static Node post_order(int pre[], int size) 
{
    Node ans=helper(pre, 0, size-1);
    return ans;
} 

public static Node helper(int pre[], int l, int r)
{
    if(l>r)
    {
        return null;
    }
    
    Node root=new Node(0);
    
    int g=nextGreat(pre,l,r);
    
    root.left=helper(pre,l+1,g-1);
    
        root.right=helper(pre,g,r);
    
    root.data=pre[l];
    
    return root;
}

public static int nextGreat(int pre[] , int l, int r)
{int i;
    
    for(i=l;i<=r;i++)
    {
        if(pre[i]>pre[l])
        {
            return i;
        }
        
    }
    return i;
    
    
}




// { Driver Code Starts.


public static 	void printInorder(Node node) { 
		if (node == null) { 
			return; 
		} 
		printInorder(node.left); 
		System.out.print(node.data + " "); 
		printInorder(node.right); 
	} 
	
public static 	void printPostorder(Node node) { 
		if (node == null) { 
			return; 
		} 
		printPostorder(node.left); 
		printPostorder(node.right);
		System.out.print(node.data + " "); 
	} 
	
public static 	void printPreorder(Node node) { 
		if (node == null) { 
			return; 
		} 
		System.out.print(node.data + " "); 
		printPreorder(node.left); 
		printPreorder(node.right);
	} 

}  // } Driver Code Ends
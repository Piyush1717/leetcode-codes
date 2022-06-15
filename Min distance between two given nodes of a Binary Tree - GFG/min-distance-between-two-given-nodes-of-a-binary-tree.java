// { Driver Code Starts
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Main {
    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
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
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String s = br.readLine().trim();
            Node root = buildTree(s);
            String[] ab = br.readLine().trim().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);

            GfG g = new GfG();
            System.out.println(g.findDist(root, a, b));
        }
    }
}
// } Driver Code Ends


// FUNCTION CODE
/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */

/* Should return minimum distance between a and b
   in a tree with given root*/
class GfG {

    int findDist(Node root, int a, int b) {
        // Your code here
    ArrayList<Node>A=NodeToRoot(root,a);
    ArrayList<Node>B=NodeToRoot(root,b);
    Node common=lca(root,a,b);
    int counta=0;
    int countb=0;
    int i=0;
    int j=0;
    while(A.get(i)!=common)
    {
        counta++;
        i++;
    }
    
        while(B.get(j)!=common)
    {
        countb++;
        j++;
    }
    
       return counta+countb; 
        
    }
    
       public ArrayList<Node> NodeToRoot(Node root, int key)
    {
        if(root==null)
        {
            return new ArrayList<>();
        }
        
        if(root.data==key)
        {
            ArrayList<Node> base=new ArrayList<>();
            base.add(root);
            return base;
        }
        
        ArrayList<Node>left=NodeToRoot( root.left,key);
        if(left.size()>0){
            left.add(root);
            return left;
        }
        
         ArrayList<Node>right=NodeToRoot( root.right,key);
        if(right.size()>0){
         right.add(root);
         return right;
        }
        
        return new ArrayList<>();
    }
    
    Node lca(Node root, int n1,int n2)
	{
	    
	    ArrayList<Node> N1=NodeToRoot(root,n1);
	     ArrayList<Node> N2=NodeToRoot(root,n2);
	     
	     int i=N1.size()-1;
	     int j=N2.size()-1;
	     Node ans=null;
	     
	     while(i>=0 && j>=0)
	     {
	         if(N1.get(i).data != N2.get(j).data)
	         break;
	         
	         ans=  N1.get(i);
	         i--;
	         j--;
	       
	     }
	    return ans;
    
    
    
    
}

}
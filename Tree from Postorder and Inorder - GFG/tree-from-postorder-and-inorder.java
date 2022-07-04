// { Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

class InorderPostorderToTree {
    public void preOrder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);

        preOrder(root.right);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        InorderPostorderToTree ip = new InorderPostorderToTree();
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int inorder[] = new int[n];
            int postorder[] = new int[n];
            for (int i = 0; i < n; i++) inorder[i] = sc.nextInt();
            for (int i = 0; i < n; i++) postorder[i] = sc.nextInt();
            GfG g = new GfG();
            Node root = g.buildTree(inorder, postorder, n);
            ip.preOrder(root);
            System.out.println();

            T--;
        }
    }
}
// } Driver Code Ends


/* Tree node structure
class Node
{
    int data;
    Node left;
    Node right;

        Node(int value)
    {
        data = value;
        left = null;
        right = null;
    }
}*/


class GfG
{
    //Function to return a tree created from postorder and inoreder traversals.
    Node buildTree(int in[], int post[], int n) {
        HashMap< Integer, Integer> hm=new HashMap<>();
        
        for(int i=0;i<n;i++)
        {
            int val=in[i];
            hm.put(val,i);
        }
        
    Node root= helper(in, post, 0, in.length-1, 0 , post.length-1,hm);
        return root;
    }
    
    public Node helper(int in[] , int post[] , int inlo, int inhi , int postlo, int posthi,HashMap<Integer, Integer> hm)
    {
        if(inlo>inhi || postlo>posthi)
        {
            return null;
        }
        Node root=new Node(post[posthi]);
        
        int idx=hm.get(post[posthi]);
        int rhs=inhi-idx;
        
        
        root.left=helper(in, post, inlo, idx-1, postlo , posthi-rhs-1,hm);
        
        root.right=helper(in, post, idx+1, inhi,posthi-rhs  , posthi-1,hm);
        
        return root;
        
        
        
        
        
    }
    
    
    
}

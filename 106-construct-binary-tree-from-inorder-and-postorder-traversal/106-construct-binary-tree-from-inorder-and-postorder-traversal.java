/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
          HashMap<Integer,Integer> hm = new HashMap<>() ;
        
        for(int i = 0 ; i < inorder.length ; i++)
        {
            hm.put(inorder[i],i) ;
        }
        return Construct(0,postorder.length-1,0,inorder.length-1,postorder,hm ) ; 
    }

    private TreeNode Construct(int plo,int phi , int inlo , int inhi ,int [] postorder,HashMap<Integer,Integer> hm  )
    {
        if(plo>phi  ||  inlo > inhi)
        {
            return null ;
        }
        TreeNode node = new TreeNode() ;
        node.val=postorder[phi];

        int idx = hm.get(postorder[phi] ) ;

        int rhs =  inhi-idx ;
         
        node.left = Construct(plo ,phi-rhs-1 , inlo,idx-1,postorder,hm ) ;
        node.right = Construct( phi-rhs, phi-1, idx+1,inhi,postorder,hm ) ;

        return node ;
    }

    }
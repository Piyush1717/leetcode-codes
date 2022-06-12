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
     public TreeNode buildTree(int[] preorder, int[] inorder) {
     HashMap<Integer, Integer> hm=new HashMap<>();
         for(int i=0;i<inorder.length;i++)
         {
             int val=inorder[i];
             hm.put(val,i);
         }
          TreeNode ans= construct(0,preorder.length-1,0,inorder.length-1,preorder,hm);
return ans;
         
    }
    
    public TreeNode construct(int prelo,int prehi, int inlo, int inhi, int [] preorder,HashMap<Integer, Integer> hm)
    {
        if(prelo>prehi || inlo>inhi)
        {
            return null;
        }
        
        TreeNode root=new TreeNode();
        root.val=preorder[prelo];
        
        int index=hm.get(preorder[prelo]);
        int lhs=index-inlo;
        
        root.left=construct(prelo+1,prelo+lhs,inlo,index-1,preorder,hm);
        
         root.right=construct(prelo+lhs+1,prehi,index+1,inhi,preorder,hm);

        return root;
        
    }
}
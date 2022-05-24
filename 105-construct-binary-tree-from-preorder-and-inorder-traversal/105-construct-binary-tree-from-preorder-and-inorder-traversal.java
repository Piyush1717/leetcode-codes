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
            int value=inorder[i];
            hm.put(value,i);
        }
        
        TreeNode node=construct(0,preorder.length-1,0,inorder.length-1,preorder,hm);
        return node;
    }
    
    public TreeNode construct(int prelo,int prehi, int inlo, int inhi, int [] preorder,HashMap<Integer, Integer> hm)
    {
        if(prelo>prehi || inlo>inhi)
        {
            return null;
        }
        
        TreeNode node=new TreeNode();
        int idx=hm.get(preorder[prelo]);
        
        node.val=preorder[prelo];
        
        int lhs=idx-inlo;
        
        
        node.left=construct(prelo+1,prelo+lhs,inlo,idx-1,preorder,hm);
            
            node.right=construct(prelo+lhs+1,prehi,idx+1,inhi,preorder,hm);
        
        return node;
        
        
        
    }
    
    
}


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
    
    int len;
    
    public int longestUnivaluePath(TreeNode root) {
        
        len=0;
        helper(root,-1);
        
        if(len>0)
        {
            len=len-1;
        }
        
        return len;
        
    }
    
    public int helper(TreeNode root, int val)
    {
        if(root==null)
        {
            return 0;
        }
        
        int left=helper(root.left,root.val);
         int right=helper(root.right,root.val);
        
        if(left+right+1>len)
        {
            len=left+right+1;
        }
        
        
        
        if(val==root.val)
        {
            return Math.max(left,right)+1;
        }
        else
        {
            return 0;
        }
        
    }
    
    
    
}
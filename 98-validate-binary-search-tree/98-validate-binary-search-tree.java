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
    long prev=Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root==null)
            return true;
        
        boolean la=isValidBST(root.left);
        if(la==false)
            return false;
        
        if(prev>= root.val)
            return false;
        
        prev=root.val;
        
        
        
        
        boolean ra=isValidBST(root.right);
        if(ra==false)
            return false;
        
        return true;
        
    }
}
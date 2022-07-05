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
    int count=0;
    int camera=1;
    int monitored=2;
    int unmonitored=3;
    
    public int minCameraCover(TreeNode root) {
        int ans=helper(root);
        if(ans==unmonitored)
        {
            count++;
        }
        return count;
    }
    
    public int helper(TreeNode root)
    {
        if(root==null)
        {
           return monitored;
        }
        
       int left= helper(root.left);
       int right=   helper(root.right);
        
        if(left==unmonitored || right==unmonitored)
        {
            count++;
            return camera; 
        }
        else if(left ==camera || right==camera)
        {
            return monitored;
        }
        else
        {
            return unmonitored;
        }
        
        
        
        
        
        
        
        
    }
    
    
    
}
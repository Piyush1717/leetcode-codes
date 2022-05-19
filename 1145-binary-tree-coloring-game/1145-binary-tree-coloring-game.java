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
    int xkaleft;
    int xkaright;
    
    public int size(TreeNode root, int x)
    {
        if(root==null)
        {
            return 0;
        }
        
        int ls=size(root.left,x);
         int rs=size(root.right,x);
        
        if(root.val==x)
        {
            xkaleft=ls;
            xkaright=rs;
        }
        
        int ts=ls+rs+1;
        return ts;
        
    }
    
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
    
     n=size(root,x);
        
        int otherSide=n-(xkaleft+xkaright+1);
        
        int max=Math.max(otherSide,Math.max(xkaleft,xkaright));
        
        int rest=n-max;
        
        if(max>rest)
        {
            return true;
        }
        else
        {
            return false;
        }
        
        
        
    }
}
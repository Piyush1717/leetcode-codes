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
    
    public static int max(TreeNode root)
    {
        TreeNode curr=root;
        
        while(curr.right!=null)
        {
            curr=curr.right;
        }
        return curr.val;
    }
    
    public TreeNode deleteNode(TreeNode root, int key) {
  
        if(root==null)
            return null;
        
        if(root.val<key)
        {
            root.right=deleteNode(root.right,key);
        }
        else if(root.val>key)
        {
            root.left=deleteNode(root.left,key);
        }
        else
        {
        
        if(root.left==null || root.right==null)
        {
            return root.left!=null?root.left:root.right;
        }
        
        int maxEle=max(root.left);
        root.val=maxEle;
        root.left=deleteNode(root.left,maxEle);
        }
        return root;
        
    }
}
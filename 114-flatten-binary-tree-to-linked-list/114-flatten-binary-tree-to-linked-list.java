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
    
    public class pair{
        
        TreeNode head;
        TreeNode tail;
    
        pair(){
            
        }
        
        pair(TreeNode head, TreeNode tail)
        {
            this.head=head;
            this.tail=tail;
        }
    }
    
    
    
    public void flatten(TreeNode root) {
        if(root!=null)
        {
            helper(root);
        }
        
    }
    
    public pair helper(TreeNode root)
    {
        if(root.left!=null && root.right!=null)
        {
            pair lp=helper(root.left);
               pair rp=helper(root.right);

            pair mp=new pair();
            mp.head=root;
            mp.head.left=null;
             mp.head.right=lp.head;
            lp.tail.right=rp.head;
            mp.tail=rp.tail;
            
            return mp;
            
        }
 else if(root.left!=null)
 {
           pair lp=helper(root.left);
     
     pair mp=new pair();
     mp.head=root;
     mp.head.left=null;
     mp.head.right=lp.head;
     mp.tail=lp.tail;
     
     return mp;
 }
        else if(root.right!=null)
        {
               pair rp=helper(root.right);
         
            pair mp=new pair();
            mp.head=root;
            mp.head.left=null;
            mp.head.right=rp.head;
            mp.tail=rp.tail;
            
            return mp;
        }
        else
        {
        pair mp=new pair(root,root);
            return mp;
            
            
        }
        
        
        
    }
    
    
}
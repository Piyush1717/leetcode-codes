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
    
    public int pathSum(TreeNode root, int targetSum) {
    
        if(root==null)
        {
            return 0;
        }
        HashMap<Integer, Integer> hm=new HashMap<>();
        hm.put(0,1);
        
        helper(root,root.val,targetSum,hm);
        
        return count;
    }
    
    public void helper(TreeNode root, int psum, int tar , HashMap<Integer, Integer>hm )
    {
        if(hm.containsKey(psum-tar)==true)
        {
            count+=hm.get(psum-tar);
        }
        
        if(hm.containsKey(psum)==false)
        {
            hm.put(psum,1);
        }
        else
        {
            hm.put(psum,hm.get(psum)+1);
        }
        
        if(root.left!=null)
        {
            helper(root.left,psum+root.left.val,tar,hm);
            
        }
        
        if(root.right!=null)
        {
             helper(root.right,psum+root.right.val,tar,hm);
        }
        
        if(hm.get(psum)==1)
        {
            hm.remove(psum);
        }
        else
        {
            hm.put(psum,hm.get(psum)-1);
        }
        
        
        
    }
    
    
}
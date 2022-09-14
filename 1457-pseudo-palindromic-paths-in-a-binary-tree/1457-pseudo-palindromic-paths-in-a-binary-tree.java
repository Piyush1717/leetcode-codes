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
    
    int num=0;
    
    public int pseudoPalindromicPaths (TreeNode root) {
     
        int [] arr=new int [10];
        
        if(root.left==null && root.right==null)
        {
            return 1;
        }
        
        
        
         solve(root,arr);
        return num;
        
        
    }
    
    public void solve(TreeNode root,int [] arr)
    {
        if(root==null)
        {
            return;
        }
        
        arr[root.val]++;
        
        solve(root.left,arr);
          solve(root.right,arr);
        
        if(root.left==null && root.right==null)
        {
            int count=0;
            
            for(int i=1;i<=9;i++)
            {
                if(arr[i]%2==1)
                {
                    count++;
                } 
            }
            
            if(count<=1)
            {
                num++;
            }          
        }
        
        arr[root.val]--;
        
    }
    
    
    
}
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
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null)
        {
            return new ArrayList<List<Integer>>();
        }
List<List<Integer>> res = new ArrayList<List<Integer>>();
    
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        
        while(q.size()>0)
        {
            int size=q.size();
         ArrayList<Integer> ans=new ArrayList<>();
            while(size-->0)
            {
                TreeNode temp=q.poll();
                ans.add(temp.val);
               
                
                if(temp.left!=null)
                {
                    q.add(temp.left);
                }
                
                if(temp.right!=null)
                {
                    q.add(temp.right);
                }
            }
            res.add(ans);
        }
        return res;
        
    }
}
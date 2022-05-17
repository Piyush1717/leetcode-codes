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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        Queue<TreeNode> q=new LinkedList<>();
        Stack<List<Integer>> st=new Stack<>();
        List<Integer> l1=new ArrayList<>();
       
        
                q.add(root);
        q.add(null);
        
         List<List<Integer>> b2 = new ArrayList();
        
        if(root==null)
        {
            return b2;
        }
        
        

        
        while(q.size()>0)
        {
           TreeNode temp= q.remove();
            
            if(temp!=null)
            {
                l1.add(temp.val);
                
                if(temp.left!=null)
                {
                    q.add(temp.left);
                }
                
                
                if(temp.right!=null)
                {
                    q.add(temp.right);
                }
            }
            else
            {
                if(q.size()>0)
                {
                    q.add(temp);
                }
                
                st.push(l1);
                l1=new ArrayList<>();
            }
            
        }
        
            List<List<Integer>> b1=new ArrayList();
            
            while(st.size()>0)
            {
                b1.add(st.pop());
                
            }
            
            
        return b1;
        
        
    }
}
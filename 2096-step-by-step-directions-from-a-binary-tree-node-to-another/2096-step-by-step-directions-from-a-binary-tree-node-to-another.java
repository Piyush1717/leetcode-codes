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
    
       public ArrayList<TreeNode> NodeToRoot(TreeNode root, int key)
    {
        if(root==null)
        {
            return new ArrayList<>();
        }
        
        if(root.val==key)
        {
            ArrayList<TreeNode> base=new ArrayList<>();
            base.add(root);
            return base;
        }
        
        ArrayList<TreeNode>left=NodeToRoot( root.left,key);
        if(left.size()>0){
            left.add(root);
            return left;
        }
        
         ArrayList<TreeNode>right=NodeToRoot( root.right,key);
        if(right.size()>0){
         right.add(root);
         return right;
        }
        
        return new ArrayList<>();
    }
    
    
    
    
    
    
    public String getDirections(TreeNode root, int startValue, int destValue) {
         
	    ArrayList<TreeNode> N1=NodeToRoot(root,startValue);
	     ArrayList<TreeNode> N2=NodeToRoot(root,destValue);
	     
	     int i=N1.size()-1;
	     int j=N2.size()-1;
	     
	     while(i>=0 && j>=0)
	     {
	         if(N1.get(i) != N2.get(j))
	         break;
	    
	         i--;
	         j--;
	     }
        i=i+1;
        j=j+1;
        
        StringBuilder ans=new StringBuilder();
        
        for(int ii=0;ii<i;ii++)
        {
            ans.append("U");
        }
        
        for(int jj=j;jj>0;jj--)
        {
            if(N2.get(jj-1)==N2.get(jj).left){
                
                ans.append("L");
            }
            else
            {
                ans.append("R");
            }
        }
        return ans.toString();
        
        
        
        
        
        
        
        
    }
}
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
    
    class Pair implements Comparable <Pair> {
        TreeNode node;
        int h;
        int v;
        
        Pair(TreeNode node, int h, int v)
        {
            this.node=node;
            this.h=h;
            this.v=v;
        }
    
    public int compareTo(Pair other)
    {
        if(this.v==other.v)
        {
            return this.node.val-other.node.val;
        }
        else
        {
            return this.v-other.v;
        }
        
        
    }
    }
    
    
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,0,1));
        
        int lh=0;
        int rh=0;
        
        HashMap<Integer, ArrayList<Pair>> hm=new HashMap<>();
        
        
        
        while(q.size()>0)
        {
         Pair p=q.poll();
            
            if(p.h<lh)
            {
                lh=p.h;
            }
            
            
            if(p.h>rh)
            {
                rh=p.h;
            }
            
            if(hm.containsKey(p.h)==false)
            {
                hm.put(p.h,new ArrayList<>());
                hm.get(p.h).add(p);
            }
            else
            {
                hm.get(p.h).add(p);
            }
            
            if(p.node.left!=null)
            {
                q.add(new Pair(p.node.left,p.h-1,p.v+1));
            }
            
            
            if(p.node.right!=null)
            {
                q.add(new Pair(p.node.right,p.h+1,p.v+1));
            }
        }
        
        List<List<Integer>> res=new ArrayList<>();
        
        for(int i=lh;i<=rh;i++)
        {
            ArrayList<Integer> l1=new ArrayList<>();
            ArrayList<Pair> unsortedList=hm.get(i);
            Collections.sort(unsortedList);
            
            for(Pair temp: unsortedList)
            {
                l1.add(temp.node.val);
            }
            
            res.add(l1);
            
        }
        
        return res;
        
    }
}
class Solution {
    public int[][] diagonalSort(int[][] mat) {
     
        HashMap<Integer, PriorityQueue<Integer>> hm=new HashMap<>();
        
        int n=mat.length;
        int m=mat[0].length;
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                int gap=i-j;
                
                if(hm.containsKey(gap)==false)
                {
                    hm.put(gap,new PriorityQueue<>());
                }
                
                hm.get(gap).add(mat[i][j]);
            }
        }
        
        
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                int gap=i-j;
                
                mat[i][j]=hm.get(gap).remove();
                
            }
        }
        
        return mat;
        
        
        
    }
}
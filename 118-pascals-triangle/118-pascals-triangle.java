class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> row;
        List<Integer>prev=null;
        
        for(int i=0;i<numRows;i++)
        {
            row=new ArrayList<>();
            
            for(int j=0;j<=i;j++)
            {
                if(j==0 || j==i)
                {
                    row.add(1);
                }
                else
                {
                    row.add(prev.get(j)+prev.get(j-1));
                }
            }
            
            prev=row;
            res.add(row);
        }
        
        return res;
        
    }
}
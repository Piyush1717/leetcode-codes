class Solution {
    public int minimumCost(int[] cost) {
        
        Arrays.sort(cost);
        
        int n=cost.length;
        int ans=0;
        int k=n-1;
        
        while(true)
        {
            
            while(k>=2)
            {
                int i=0;
                while(i<2)
                {
                    ans+=cost[k-i];
                    i++;
                }
                k-=3;
            }
            
            if(k<2)
            {
                break;
            }
            
            
        }
        
        
        while(k>=0)
        {
            
            ans+=cost[k];
            k--;
        }
        
        
        
        
        return ans;
        
    }
}
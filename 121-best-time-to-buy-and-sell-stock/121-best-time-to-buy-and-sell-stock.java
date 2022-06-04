class Solution {
    public int maxProfit(int[] prices) {
    int minSoFar=prices[0];
        int max=0;
        
        for(int i=0;i<prices.length;i++)
        {
            
            if(minSoFar>prices[i])
            {
                minSoFar=prices[i];
            }
            else
            {
                int temp=prices[i]-minSoFar;
                
                    if(temp>max)
                    {
                        max=temp;
                    }
                    
                    
            }
            
            
            
            
        }
        return max;
        
    }
}
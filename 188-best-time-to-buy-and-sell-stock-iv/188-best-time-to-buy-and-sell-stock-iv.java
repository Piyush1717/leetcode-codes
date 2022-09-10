class Solution {
    public int maxProfit(int k, int[] prices) {
        
        if(k==0 ||prices.length==0)
        {
            return 0;
        }
        
        int [][] dp=new int[k+1][prices.length];
        
        for(int i=1;i<=k;i++)
        {
            for(int j=1;j<prices.length;j++)
            {
                
                int maxp=0;
                
                for(int jj=0;jj<=j-1;jj++)
                {
                    maxp=Math.max(maxp,  dp[i-1][jj] +  (prices[j] - prices[jj]) );
                    
                }
                
                dp[i][j]=Math.max(maxp, dp[i][j-1]);
                
            }
            
            
            
        }
        
        return dp[k][dp[0].length-1];
    }
}
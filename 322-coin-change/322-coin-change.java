class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int [][]dp=new int [coins.length+1][amount+1];
        
        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<dp[0].length;j++)
            {
                if(j==0)
                {
                    dp[i][j]=0;
                }
                else if(i==0)
                {
                    dp[i][j]= 100000;
                }
                else
                {
                    
                    int noCall=dp[i-1][j];
                    
                    int yesCall= 100000;
                    if(j-coins[i-1]>=0)
                    {
                        yesCall=1+dp[i][j-coins[i-1]];
                    }
                    
                    dp[i][j]=Math.min(yesCall,noCall);
                }
            }
        }
            
           return (dp[dp.length-1][dp[0].length-1]>10000) ? -1 : dp[dp.length-1][dp[0].length-1];
        
    }
}
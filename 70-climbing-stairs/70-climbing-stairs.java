class Solution {
    public int climbStairs(int n) {
        int [] dp=new int [n+1];
        Arrays.fill(dp,-1);
        return helper(n,dp);
    }
    
    public int helper(int n , int [] dp)
    {
        if(n==0)
        {
            return dp[n]=1;
        }
        
        if(dp[n]!=-1)
        {
            return dp[n];
        }
       
        int count=0;
        
        
        
        if(n-1>=0)
        {
            count+=helper(n-1,dp);
        }
        
        
        if(n-2>=0)
        {
            count+=helper(n-2,dp);
        }
        
        return dp[n]=count;
        
        
        
    }
    
}
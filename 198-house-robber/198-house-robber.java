class Solution {
    public int rob(int[] nums) {
        
        
        int []dp=new int [nums.length];
        Arrays.fill(dp,-1);
        
        return solve(nums.length-1,nums,dp);
    }
    
    public int solve(int idx, int [] nums, int [] dp)
    {
        if(idx==0)
        {
            return nums[0];
        }
        
        if(idx<0)
        {
            return 0;
        }
        
        if(dp[idx]!=-1)
        {
            return dp[idx];
        }
        
        
        int pick=nums[idx]+ solve(idx-2,nums,dp);
        
        int notPick=0+ solve(idx-1,nums,dp);
            
            
            return dp[idx]=Math.max(pick,notPick);
        
        
        
    }
    
    
    
}
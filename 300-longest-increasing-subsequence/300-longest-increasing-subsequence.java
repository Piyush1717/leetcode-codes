class Solution {
    public int lengthOfLIS(int[] A) {
        int N=A.length;
        
        int [] dp=new int [A.length+1];
        
        Arrays.fill(dp,1);
        
        
        for(int i=1;i<N;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(A[i]>A[j])
                {
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
                
                
            }
            
        }
        
        int ans=0;
        
        for(int i=0;i<N;i++)
        {
            ans=Math.max(ans,dp[i]);
        }
        
        return ans;
        
    }
}
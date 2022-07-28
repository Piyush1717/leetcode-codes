class Solution {
    public int nthUglyNumber(int n) {
        
        int [] dp=new int[n+1];
        
        dp[1]=1;
        
        int p2=1;
        int p3=1;
        int p5=1;
        
        for(int i=2;i<=n;i++)
        {
            int f1=2*dp[p2];
            int f2=3*dp[p3];
            int f3=5*dp[p5];
            
            int min=Math.min(f1,Math.min(f2,f3));
            
            dp[i]=min;
            
            if(f1==min)
            {
                p2++;
            }
            
            
            if(f2==min)
            {
                p3++;
            }
            
            
            if(f3==min)
            {
                p5++;
            }
        }    
            return dp[n];
            
            
            
            
        
        
    }
}
// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.numberOfWays(N));
        }
    }
}// } Driver Code Ends


class Solution {
    static Long numberOfWays(int N) {
      int [] dp=new int[N+1];
      int ans=helper(N,dp);
      ans=ans%1000000007;
      long res=Long.valueOf(ans);
        return res;
    }
    
    public static int helper(int n, int [] dp)
    {
        if(n<=2)
        {
            return dp[n]=n;
        }
        
        if(dp[n]!=0)
        {
            return dp[n];
        }
        
        int ans1=helper(n-1,dp);
        int ans2=helper(n-2,dp);
        
        return dp[n]=(ans1+ans2)%1000000007;
        
        
    }
    
    
    
};
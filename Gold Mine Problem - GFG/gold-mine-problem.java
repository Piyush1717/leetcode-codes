// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String inline[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(inline[0]);
            int m = Integer.parseInt(inline[1]);
            String inline1[] = in.readLine().trim().split("\\s+");
            int M[][] = new int[n][m];
            for(int i = 0;i < n*m;i++){
                M[i/m][i%m] = Integer.parseInt(inline1[i]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.maxGold(n, m, M));
        }
    }
} // } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxGold(int n, int m, int M[][])
    {
        int [][] dp=new int[n][m];
        int ans=0;
        for(int i=0;i<n;i++)
        {
            int tempAns=greedy(i,0,M,dp);
            if(tempAns>ans)
            {
                ans=tempAns;
            }
        }
        return ans;
    }
    
    public static int greedy(int n, int m, int M[][],int [][] dp)
    {
        if(n>=M.length || n<0 || m>=M[0].length || m<0)
        {
            return 0;
        }
        
        if(dp[n][m]!=0)
        {
            return dp[n][m];
        }
        
        int op1=greedy(n-1,m+1,M,dp);
        int op2=greedy(n,m+1,M,dp);
        int op3=greedy(n+1,m+1,M,dp);
        
        int max=Math.max(op1,Math.max(op2,op3));
        
        dp[n][m]=max+M[n][m];
        
        return dp[n][m];
        
        
    }
    
    
}
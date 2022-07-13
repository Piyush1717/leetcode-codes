// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.nthPoint(n);
            System.out.println(ans);            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int nthPoint(int n)
    {
        // Code here
                int [] dp=new int [n+1];
        Arrays.fill(dp,-1);
       int ans=helper(n,dp);
       return ans%1000000007;
    }
    
    public int helper(int n , int [] dp)
    {
        if(n==0)
        {
            return dp[n]=1;
        }
        
        if(dp[n]!=-1)
        {
            return dp[n]%1000000007;
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
        
        return dp[n]=count%1000000007 ;
        
        
    }
}
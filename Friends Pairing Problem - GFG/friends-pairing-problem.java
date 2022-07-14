// { Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.countFriendsPairings(n));
                }
        }
}    // } Driver Code Ends


//User function Template for Java

class Solution
{
    public long countFriendsPairings(int n) 
    { 
           //code here
       long[] dp = new long[n+1];
       dp[0] = 1;
       long mod = 1000000007;
       
       for(int i=1;i<n+1;i++){
           if(i==1) dp[i] = 1;
           else{
               dp[i] = (dp[i-1] + ((i-1)*dp[i-2])%mod)%mod;
           }
       }
       
       return dp[n]%mod;
    }
    
    
    
}    
 
// { Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.firstElement(n));
        }
    }
}// } Driver Code Ends


//User function Template for Java
class Solution {
    static int firstElement(int n) {
     int [] dp=new int [n+1];
     Arrays.fill(dp,-1);
    int ans= helper(n,dp);
    ans=ans%1000000007;
    return ans;

    }
    
    public static int helper(int n , int [] dp)
    {
         if(n<=1)
      {
          return dp[n]=n%1000000007;
      }
      
      if(dp[n]!=-1)
      {
          return dp[n];
      }
      
      
      int nm1=helper(n-1,dp);
       int nm2=helper(n-2,dp);
      
      return dp[n]=(nm1+nm2)%1000000007;
      
        
        
    }
    
}
//{ Driver Code Starts
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

            System.out.println(ob.nthFibonacci(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution {
    static int nthFibonacci(int n){
        // code here
        
        int [] dp=new int[n+1];
        
        dp[0]=0;
        dp[1]=1;
        
        for(int i=2;i<=n;i++)
        {
            int a=dp[i-1];
            int b=dp[i-2];
            
            dp[i]=(a%1000000007+b%1000000007)%1000000007;
        }
        
        return dp[n];
        
    }
}
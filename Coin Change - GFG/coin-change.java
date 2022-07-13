// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int Arr[] = new int[m];
            for (int i = 0; i < m; i++) Arr[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(Arr, m, n));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    public long count(int S[], int m, int n) {
        long [] dp=new long [n+1];
        dp[0]=1;
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<dp.length;j++)
            {
                if(j-S[i]>=0)
                {
                    dp[j]+=dp[j-S[i]];
                }
            }
        }
        
        return dp[n];
    }
}
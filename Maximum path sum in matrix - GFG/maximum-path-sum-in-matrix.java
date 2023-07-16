//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int Matrix[][] = new int[N][N];
            for(int i = 0; i < N*N; i++)
                Matrix[(i/N)][i%N] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.maximumPath(N, Matrix));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maximumPath(int n, int grid[][])
    {
        // code here
        
        int [][] dp=new int[n][n];
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==0)
                {
                    dp[i][j]=grid[i][j];
                }
                else if(j==0)
                {
                    int s=grid[i][j]+ dp[i-1][j];
                    int rd=grid[i][j]+ dp[i-1][j+1];
                    
                    dp[i][j]=Math.max(s,rd);
                }
                else if(j==n-1)
                {
                    int s=grid[i][j]+ dp[i-1][j];
                    int ld=grid[i][j]+ dp[i-1][j-1];
                    
                    dp[i][j]=Math.max(s,ld);
                }
                else
                {
                    
                    int s=grid[i][j]+ dp[i-1][j];
                    int ld=grid[i][j]+ dp[i-1][j-1];
                    int rd=grid[i][j]+ dp[i-1][j+1];
                    
                    dp[i][j]=Math.max(s,Math.max(rd,ld));
                }
            }
        }
        
        int maxi=dp[n-1][0];
        for(int i=1;i<n;i++)
        {
            maxi=Math.max(maxi, dp[n-1][i]);
        }
        
        return maxi;
        
        
        
    }
}
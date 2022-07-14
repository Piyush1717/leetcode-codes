// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}



// } Driver Code Ends


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         int [][] dp=new int [wt.length+1][W+1];
         
         for(int i=0;i<dp.length;i++)
         {
             for(int j=0;j<dp[0].length;j++)
             {
                 if(j==0)
                 {
                     dp[i][j]=0;
                 }
                else if(i==0)
                 {
                     dp[i][j]=0;
                 }
                 else
                 {
                 int noCall=dp[i-1][j];
                 
                 int yesCall=-1;
                 if(j-wt[i-1]>=0)
                 {
                     yesCall=dp[i-1][j-wt[i-1]]+val[i-1];
                 }
                 
                 dp[i][j]=Math.max(yesCall,noCall);
                 
                 }
             }
             
         }
         
         return dp[wt.length][W];
         
         
    } 
}



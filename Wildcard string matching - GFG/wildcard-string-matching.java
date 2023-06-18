//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0)
        {
            String wild = in.readLine();
            String pattern = in.readLine();
            
            Solution ob = new Solution();
            boolean flag = ob.match(wild, pattern);
            if(flag)
            System.out.println("Yes");
            else
            System.out.println("No");
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static boolean match(String p, String s)
    {
        // code here
          boolean [][] dp=new boolean[p.length()+1][s.length()+1];

        for(int i=dp.length-1;i>=0;i--)
        {
            for(int j=dp[0].length-1;j>=0;j--)
            {
                if(i==dp.length-1 && j==dp[0].length-1)
                {
                    dp[i][j]=true;
                }
                else if(i==dp.length-1)
                {
                    dp[i][j]=false;
                }
                else if(j==dp[0].length-1)
                {
                   if(p.charAt(i)=='*')
                   {
                       dp[i][j]=dp[i+1][j];
                   }
                   else
                   {
                       dp[i][j]=false;
                   } 
                }
                else
                {
                    if(p.charAt(i)=='*')
                    {
                        dp[i][j]=(dp[i+1][j] || dp[i][j+1]);

                    }
                    else if(p.charAt(i)=='?')
                    {
                        dp[i][j]=dp[i+1][j+1];

                    }
                    else if(p.charAt(i)==s.charAt(j))
                    {
                        dp[i][j]=dp[i+1][j+1];


                    }
                    else
                    {
                        dp[i][j]=false;

                    }
                }    



            }


        }
return dp[0][0];
        
        
        
        
        
    }
}
// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static Boolean isSubsetSum(int N, int arr[], int sum){
        boolean [][] dp=new boolean[arr.length+1][sum+1];
        
        boolean ans=helper(arr,dp);
        return ans;
    }
    
    public static boolean helper(int [] arr, boolean [][] dp)
    {
        int n=dp.length;
        int m=dp[0].length;
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(j==0)
                {
                    dp[i][j]=true;
                }
                else if(i==0)
                {
                    dp[i][j]=false;
                }
                else
                {
                    boolean noCall=dp[i-1][j];
                    
                    boolean yesCall=false;
                    if(j-arr[i-1]>=0)
                    {
                        yesCall=dp[i-1][j-arr[i-1]];
                    }
                    dp[i][j]=noCall||yesCall;
                }
            }
        }
        
        return dp[n-1][m-1];
        
        
        
    }
    
}
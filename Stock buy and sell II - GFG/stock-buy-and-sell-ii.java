//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] prices = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.stockBuyAndSell(n, prices);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int stockBuyAndSell(int n, int[] prices) {
        // code here
        
        int [][] dp=new int[n+1][2];
        
    dp[n][0]=dp[n][1]=0;
    
    for(int i=n-1;i>=0;i--)
    {
        for(int j=1;j>=0;j--)
        {
            int profit=0;
            if(j==1)
            {
                profit=Math.max(-prices[i] + dp[i+1][0] , 0+ dp[i+1][1]);
            }
            else
            {
                
                profit=Math.max(prices[i]+ dp[i+1][1] , 0+dp[i+1][0]);
            }
            
            dp[i][j]=profit;
            
        }
        
    }
        
       return dp[0][1];
        
    }
}
        

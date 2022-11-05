//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args)
	 {
	  
	  //taking input using Scanner class
	  Scanner sc = new Scanner(System.in);
	  
	  //taking count of testcases
	  int t = sc.nextInt();
	  while(t-- > 0){
	      
	      //taking count of houses
	      int n = sc.nextInt();
	      int arr[] = new int[n];
	      
	      //inserting money present in 
	      //each house in the array
	      for(int i = 0; i<n; ++i)
	           arr[i] = sc.nextInt();
  	      
  	      //calling method FindMaxSum() of class solve
  	      System.out.println(new Solution().FindMaxSum(arr, n));
	 }
   }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n)
    {
    int [] dp=new int[n];
    Arrays.fill(dp,-1);
    int ans=helper(n-1,arr,dp);
    return ans;
    }
    
    public int helper(int idx, int [] arr, int [] dp)
    {
        if(idx==0)
        {
            return arr[idx];
        }
        if(idx<0)
        {
            return 0;
        }
        if(dp[idx]!=-1)
        {
            return dp[idx];
        }
        
        int pick=arr[idx]+ helper(idx-2, arr,dp);
        int notPick=0+ helper(idx-1,arr,dp);
        
        return dp[idx]=Math.max(pick, notPick);
    }
    
    
}
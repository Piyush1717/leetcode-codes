//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
        	int[] array = new int[n];
        	for (int i=0; i<n ; i++ ) {
        		array[i] = sc.nextInt();
        	}
            Solution ob = new Solution();
            long[] ans = new long[n];
            ans = ob.productExceptSelf(array, n); 

           	for (int i = 0; i < n; i++) { 
				System.out.print(ans[i]+" ");
			} 
            System.out.println();
            t--;
        }
    } 
} 
  


// } Driver Code Ends


//User function Template for Java


class Solution 
{ 
	public static long[] productExceptSelf(int arr[], int n) 
	{ 
        // code here
        
        if(n==1)
        {
            return new long []{1};
        }
        
        
        
        long [] left=new long[n];
            long [] right=new long[n];
        
        left[0]=arr[0];
        
        long csum=arr[0];
        
        for(int i=1;i<n;i++)
        {
            csum*=arr[i];
            left[i]=csum;
        }
        
        
        
        right[n-1]=arr[n-1];
        
        long rsum=arr[n-1];
        
        for(int i=n-2;i>=0;i--)
        {
            rsum*=arr[i];
            right[i]=rsum;
        }
        
        long [] res=new long[n];
        
        res[0]=right[1];
        res[n-1]=left[n-2];
        
        for(int i=1;i<=n-2;i++)
        {
            res[i]=left[i-1]*right[i+1];
        }
        
        return res;
        
        
        
        
        
        
        
	} 
} 

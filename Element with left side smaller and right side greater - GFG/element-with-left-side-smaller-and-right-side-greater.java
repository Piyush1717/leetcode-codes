//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-- > 0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] a = new int[n];
            String[] inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Compute obj = new Compute();
            System.out.println(obj.findElement(a, n));
            
        }
	}
}
// } Driver Code Ends


//User function Template for Java

class Compute {
    public int findElement(int arr[], int n){
        
        int [] leftMax=new int[n];
        
        int [] rightMin=new int[n];
        
        for(int i=0;i<n;i++)
        {
            if(i==0)
            {
                leftMax[i]=arr[i];
            }
            else
            {
                leftMax[i]=Math.max(arr[i], leftMax[i-1]);
            }
        }
        
        
        for(int i=n-1;i>=0;i--)
        {
            if(i==n-1)
            {
                rightMin[i]=arr[i];
            }
            else
            {
                rightMin[i]=Math.min(arr[i], rightMin[i+1]);
            }
        }
        
        int ans=-1;
        
        for(int i=1;i<n-1;i++)
        {
            if(arr[i]>=leftMax[i-1] && arr[i]<=rightMin[i+1])
            {
                ans=arr[i];
                break;
            }
        }
        
        
        
        
        return ans;
        
    }
}
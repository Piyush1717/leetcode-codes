//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		sc.nextLine();
		while(t-->0)
		{
		    int n;
		    n=sc.nextInt();
		    
		    long arr[]=new long[n];
	
		    
		    for(int i=0;i<n;i++)
		    {
		        arr[i]=sc.nextLong();
		    }
            Solution ob = new Solution();
		    System.out.println(ob.findSubarray(arr,n));
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    //Function to count subarrays with sum equal to 0.
    public static long findSubarray(long[] arr ,int n) 
    {
        //Your code here
        
        long count=0;
        
        long [] preSum=new long[n];
        
        HashMap<Long, Long> map=new HashMap<>();
        
        long csum=arr[0];
        
        preSum[0]=arr[0];
        
        int extra=0;
        
        if(preSum[0]==0)
        {
            extra++;
        }
        
        map.put(arr[0],1L);
        
        for(int i=1;i<n;i++)
        {
            csum+=arr[i];
            
            preSum[i]=csum;
            
            if(preSum[i]==0)
            {
                extra++;
            }
            
            map.put(csum, map.getOrDefault(csum,0L)+1);
        }
        
        
        count+=extra;
        
        for(long ele: map.keySet())
        {
            long val=map.get(ele);
            
            count+=(val*(val-1))/2;
        }
        
        
        return count;
    }
}
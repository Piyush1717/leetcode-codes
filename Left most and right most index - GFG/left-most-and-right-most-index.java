//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class pair  {  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            long k = Long.parseLong(br.readLine().trim());
            
            Solution obj = new Solution();
            pair ans = obj.indexes(a, k);
            if (ans.first == -1 && ans.second == -1)
                System.out.println(-1);
            else
                System.out.println(ans.first+" "+ans.second);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java

/*
class pair  {  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}
*/

class Solution {
    
    public pair indexes(long arr[], long x)
    {
        // Your code goes here
        
        int low=0;
        int hi=arr.length-1;
        
        while(low<=hi)
        {
            int mid=low+(hi-low)/2;
            
            if(arr[mid]>=x)
            {
                hi=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        
        long f=0;
        
        if(low<arr.length && arr[low]==x)
        {
            f=low;
        }
        else
        {
            f=-1;
        }
        
        low=0;
        hi=arr.length-1;
        
        while(low<=hi)
        {
            int mid=low+(hi-low)/2;
            
            if(arr[mid]<=x)
            {
                low=mid+1;
            }
            else
            {
                hi=mid-1;
            }
        }
        
        long s=0;
        
        if(hi>=0 && arr[hi]==x)
        {
            s=hi;
        }
        else
        {
            s=-1;
        }
        
        return new pair(f,s);
        
        
        
        
        
        
    }
}
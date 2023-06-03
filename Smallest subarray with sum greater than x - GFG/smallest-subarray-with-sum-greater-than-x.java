//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(stt.nextToken());
            int m = Integer.parseInt(stt.nextToken());
            // int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.smallestSubWithSum(a, n, m));
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution {

    public static int smallestSubWithSum(int arr[], int n, int x) {
        // Your code goes here 
        
        int csum=arr[0];
        int len=Integer.MAX_VALUE;
        
        int i=0;
        int j=0;
        
        while(i<n)
        {
            if(j>i)
            {
                return 1;
            }
            
            if(csum>x)
            {
                len=Math.min(len, i-j+1);
                
            }
            
            if(csum<=x)
            {
                if(i+1<n)
                {
                csum+=arr[i+1];        
                }
                i++;
            }
            else if(csum>x)
            {
                csum-=arr[j];
                j++;
            }
        }
        return len;
        
        
    }
}


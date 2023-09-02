//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
        	int target = sc.nextInt();
        	int[] array = new int[n];
        	for(int i=0; i<n; i++)
        		array[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.threeSumClosest(array,target));
            t--;
        }
    } 
} 

// } Driver Code Ends


//User function Template for Java

class Solution 
{ 
    static int threeSumClosest(int[] arr, int target)  
	{ 
        // code here
        
        Arrays.sort(arr);
        
        int n=arr.length;
        int diff=Integer.MAX_VALUE;
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            int j=i+1;
            int k=arr.length-1;
            
            while(j<k)
            {
            int sum=arr[i]+arr[j]+arr[k];
            
            int d=Math.abs(sum-target);
            
            if(d<diff)
            {
                diff=d;
                ans=sum;
            }
            else if(d==diff)
            {
                ans=Math.max(sum,ans);
            }
            
            if(sum>=target)
            {
                k--;
            }
            else
            {
                j++;
            }
            
            
            }
            
        }
        
        return ans;
        
        
        
	} 
} 

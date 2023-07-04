//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

public class DriverClass
{
	public static void main(String args[]) 
	{
	   Scanner sc = new Scanner(System.in);
	   int t = sc.nextInt();
	   int range[];
	   while(t-- >0)
	   {
	     int n = sc.nextInt();
	     int k = sc.nextInt();
	     int arr[][] = new int[k][n];
	       for(int i = 0; i < k; i++)
	       {
	        for(int j = 0; j < n; j++)
	               arr[i][j] = sc.nextInt();
	       }
	       range = new Solution().findSmallestRange(arr, n, k);
	       System.out.println(range[0] + " " + range[1]);
	   }
	}
}

// } Driver Code Ends


class Solution
{
	static int[] findSmallestRange(int[][] arr,int n,int k)
	{
	    //add your code here
	    
	    int [] res={-100000,100000};
	    int max=Integer.MIN_VALUE;
	    
	    PriorityQueue<int []> pq=new PriorityQueue<>(
	        (a,b)->a[0]-b[0]);
	        
	        for(int i=0;i<k;i++)
	        {
	            int mol=arr[i][0];
	            int [] temp={mol,0,i};
	            max=Math.max(mol,max);
	            pq.add(temp);
	        }
	        
	        while(true)
	        {
	            int [] temp=pq.remove();
	            if(res[1]-res[0]> max-temp[0])
	            {
	                res[1]=max;
	                res[0]=temp[0];
	            }
	            temp[1]++;
	            
	            if(temp[1]==n)
	            {
	                break;
	            }
	            else
	            {
	                temp[0]=arr[temp[2]][temp[1]];
	                max=Math.max(max, temp[0]);
	                pq.add(temp);
	            }
	            
	            
	            
	        }
	        
	    
	    
	    return res;
	}
}
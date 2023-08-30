//{ Driver Code Starts
import java.util.Scanner;
import java.util.*;
import java.io.*;

class ThirdLargestElement
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n =sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();
			Solution g = new Solution();
			System.out.println(g.thirdLargest(arr,n));
		t--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    int thirdLargest(int a[], int n)
    {
	    // Your code here
	    
	    int first=Integer.MIN_VALUE;
	    int second=Integer.MIN_VALUE;
	    int third=Integer.MIN_VALUE;
	    
	    for(int i=0;i<n;i++)
	    {
	        if(a[i]>first)
	        {
	            third=second;
	            second=first;
	            first=a[i];
	        }
	        else if(a[i]>second)
	        {
	            third=second;
	            second=a[i];
	        }
	        else if(a[i]>third)
	        {
	            third=a[i];
	        }
	    }
	    
	    if(n<3)
	    {
	        return -1;
	    }
	    
	    return third;
	    
	    
    }
}

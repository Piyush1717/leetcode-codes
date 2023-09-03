//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim()); // size of array
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]); // input elements of array
		    }
		    
		    Solution ob = new Solution();
		    
		    System.out.println(ob.maxIndexDiff(arr, n)); // print the result
		}
	}
}
// } Driver Code Ends


class Solution{
    
    // A[]: input array
    // N: size of array
    // Function to find the maximum index difference.
    static int maxIndexDiff(int arr[], int n) { 
        
        // Your code here
        
        int [] leftMin=new int[n];
            int [] rightMax=new int[n];
        
        leftMin[0]=arr[0];
        
        for(int i=1;i<n;i++)
        {
            leftMin[i]=Math.min(arr[i], leftMin[i-1]);
        }
        
        rightMax[n-1]=arr[n-1];
        
        for(int i=n-2;i>=0;i--)
        {
            rightMax[i]=Math.max(arr[i],rightMax[i+1]);
        }
        
        int ans=0;
        
        for(int i=0,j=0;i<n && j<n;i++)
        {
            while(j<n && leftMin[i]<=rightMax[j])
            {
             ans=Math.max(ans, j-i);
             j++;
            }
        }
        
        return ans;
        
    }
}



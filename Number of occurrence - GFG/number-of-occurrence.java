//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    int count(int[] arr, int n, int x) {
        // code here
        
        int low=0;
        int hi=n-1;
        
        int start=0;
        int end=0;
        
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
        start=low;
        
        
    
    int l=0;
    int h=n-1;
    
    
        while(l<=h)
        {
            int mid=l+(h-l)/2;
            
            if(arr[mid]<=x)
            {
                l=mid+1;
            }
            else
            {
                h=mid-1;
            }
        }
        
        end=h;
        
        
        return end-start+1;
        
        
    }
    
    
    
}
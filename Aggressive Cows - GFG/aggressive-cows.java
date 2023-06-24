//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int solve(int n, int k, int[] stalls) {
        
        Arrays.sort(stalls);
        
        int low=1;
        int hi=stalls[n-1]-stalls[0];
        
        while(low<=hi)
        {
            int mid=low+(hi-low)/2;
            
            if(helper(mid,k,stalls))
            {
                low=mid+1;
                
            }
            else
            {
                hi=mid-1;
            }
        }
        
        
        return hi;
        
    }
    
    public static boolean helper(int mid, int cows, int [] stalls)
    {
        int prev=stalls[0];
        int count=1;
        
        for(int i=1;i<stalls.length;i++)
        {
            if(stalls[i]-prev>=mid)
            {
                count++;
                prev=stalls[i];
            }
            
            if(count==cows)
            {
                return true;
            }
        }
        
        return false;
    }
    
    
    
}
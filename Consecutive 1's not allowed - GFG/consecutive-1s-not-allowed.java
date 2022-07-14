// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            long ans = new Solution().countStrings(n);

            System.out.println(ans);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    long countStrings(int n) {
        
        long oldCountZero=1;
        long oldCountOne=1;
        
        for(int i=2;i<=n;i++)
        {
            long newCountZero=(oldCountOne+oldCountZero)%1000000007;
            long newCountOne=oldCountZero;
            
        
        oldCountZero=(newCountZero)%1000000007;
       oldCountOne=newCountOne;
            
            
        }
        
        return (oldCountOne+oldCountZero)%1000000007;
        
    }
}
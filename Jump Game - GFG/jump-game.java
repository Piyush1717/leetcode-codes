//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S1[] = read.readLine().split(" ");
            
            int[] A = new int[N];
            
            for(int i=0; i<N; i++)
                A[i] = Integer.parseInt(S1[i]);

            Solution ob = new Solution();
            System.out.println(ob.canReach(A,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int canReach(int[] A, int N) {
        // code here
        
        
    boolean ans= helper(0,A,N);
        
        if(ans==true)
        {
            return 1;
        }
        
        return 0;
        
    }
    
    public static boolean helper(int idx,int [] A, int n)
    {
        if(idx==n-1)
        {
            return true;
        }
        
        for(int jump=1;jump+idx<n && jump<=A[idx];jump++)
        {
            boolean ans= helper(idx+jump,A,n);
            if(ans==true)
            {
                return true;
            }
        }
        
        return false;
        
        
    }
    
};
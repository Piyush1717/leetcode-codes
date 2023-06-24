//{ Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        while (t-- > 0)
        {
            int n = sc.nextInt();
            
            System.out.println(new Solution().findNum(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int findNum(int n)
    {
        // Complete this function
        
        if(n==1)
        {
            return 5;
        }
        
        int low=0;
        int hi=5*n;
        
        while(low<=hi)
        {
            int mid=low+(hi-low)/2;
            
            if(helper(mid,n)==true)
            {
                hi=mid-1;
            }
            else
            {
                low=mid+1;
            }
            
        }
        
        return low;
        
        
    }
    
    public boolean helper(int val, int n)
    {
        
        int count=0;
        
        while(val>=5)
        {
            count+=val/5;
            val=val/5;
        }
        
        if(count>=n)
        {
            return true;
        }
        
        return false;
        
    }
    
    
    
    
}
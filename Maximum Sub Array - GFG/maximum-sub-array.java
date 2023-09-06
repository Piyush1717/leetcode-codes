//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            ArrayList<Integer> ans = new Solution().findSubarray(a, n);
            for(int i:ans){
                out.print(i+" ");
            }out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    ArrayList<Integer> findSubarray(int a[], int n) {
        // code here
        
        ArrayList<Integer> ans=new ArrayList<>();
        ArrayList<Integer> pot=new ArrayList<>();
        
        int csum=0;
        
        int sum=0;
        
        for(int i=0;i<n;i++)
        {
            if(a[i]<0)
            {
                if(csum>sum)
                {
                    ans=pot;
                    sum=csum;
                }
                else if(csum==sum)
                {
                    if(pot.size()>ans.size())
                    {
                    ans=pot;
                    }
                }
                    pot=new ArrayList<>();
                    csum=0;
                    continue;
            }
            
            pot.add(a[i]);
            csum+=a[i];
        }
        
          if(csum>sum)
                {
                    ans=pot;
                    sum=csum;
                }
                else if(csum==sum)
                {
                    if(pot.size()>ans.size())
                    {
                    ans=pot;
                    }
                }
        
        
        
        if(ans.size()==0)
        {
            ans.add(-1);
            return ans;
        }
        
        return ans;
        
    }
}
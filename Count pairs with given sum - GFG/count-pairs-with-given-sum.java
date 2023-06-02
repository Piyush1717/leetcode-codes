//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int k = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int ans = new Solution().getPairsCount(arr, n, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int getPairsCount(int[] arr, int n, int k) {
        // code here
        
        int ans=0;
        HashMap<Integer, Integer> map=new HashMap<>();
        
        for(int ele: arr)
        {
            map.put(ele, map.getOrDefault(ele,0)+1);
        }
        
        for(int i=0;i<n;i++)
        {
            int diff=k-arr[i];
            
            if(map.containsKey(diff)==true)
            {
                if(diff==arr[i])
                {
                    ans+=map.get(diff)-1;
                }
                else
                {
                    ans+=map.get(diff);
                }
            }
            
            int val=map.get(arr[i]);
            val=val-1;
            if(val==0)
            {
                map.remove(arr[i]);
            }
            else
            {
                map.put(arr[i],val);
            }
        }
        
        return ans;
        
    }
}

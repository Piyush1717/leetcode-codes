//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s = in.readLine();
            int k = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.minValue(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int minValue(String s, int k){
        // code here
        
        PriorityQueue<Integer> pq=new PriorityQueue<>(
            (a,b)->b-a);
        
        HashMap<Character,Integer> hm=new HashMap<>();
        
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        
        for(int ele: hm.values())
        {
            pq.add(ele);
        }
        
        for(int i=0;i<k;i++)
        {
            int val=pq.remove();
            val=val-1;
            pq.add(val);
        }
        
        int ans=0;
        while(pq.size()>0)
        {
            int val=pq.poll();
            ans+=val*val;
        }
        
        return ans;
        
        
    }
}
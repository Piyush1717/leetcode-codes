//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String arr[] = new String[n];
            for(int i = 0;i<n;i++)
                arr[i] = sc.next();
            
            Solution ob = new Solution();
            
            System.out.println(ob.secFrequent(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    String secFrequent(String arr[], int N)
    {
        // your code here
        
        HashMap<String , Integer> hm=new HashMap<>();
        
        for(String ele: arr)
        {
            hm.put(ele, hm.getOrDefault(ele,0)+1);
        }
        
        String best="";
        String secbest="";
        
        int first=0;
        int second=0;
        
        for(String ele : hm.keySet())
        {
            if(hm.get(ele)>first)
            {
                second=first;
                secbest=best;
                
                best=ele;
                first=hm.get(ele);
            }
            else if(hm.get(ele)>second)
            {
                second=hm.get(ele);
                secbest=ele;
            }
        }
        
        return secbest;
        
    }
}
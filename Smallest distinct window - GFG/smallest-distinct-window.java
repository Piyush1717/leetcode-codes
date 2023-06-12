//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String str = br.readLine();
            
            Solution obj = new Solution();
            System.out.println(obj.findSubString(str));
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    public int findSubString( String s) {
        // Your code goes here
        
        HashSet<Character> set=new HashSet<>();
        
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            
            set.add(ch);
        }
        
        int size=set.size();
        
        int i=0;
        int j=0;
        int len=s.length();
        HashMap<Character, Integer> map=new HashMap<>();
        
        while(j<s.length())
        {
            while(j<s.length() && map.size()<size)
            {
                char c=s.charAt(j);
                map.put(c, map.getOrDefault(c,0)+1);
                j++;
            }
            
            len=Math.min(len ,j-i);
            
            while(i<=j && map.size()==size)
            {
                   char cc=s.charAt(i);
            int val=map.get(cc);
            val=val-1;
            if(val==0)
            {
                map.remove(cc);
            }
            else
            {
                map.put(cc,val);
            }
            
            if(map.size()==size)
            {
                len=Math.min(len, j-i-1);
            }
            
            i++;
                
                
                
                
                
            }
            
         
        }
        
        return len;
        
    }
}
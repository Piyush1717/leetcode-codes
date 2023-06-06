//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestPalin(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static String longestPalin(String S){
        // code here
        
        String s=helper(S);
        
        return s;
        
    }
    
    public static String helper(String s)
    {
        
      int start=0;
      int end=1;
      
      for(int i=1;i<s.length();i++)
      {
          int low=i-1;
          int high=i;
          
          while(low>=0 && high<s.length() && s.charAt(low)==s.charAt(high))
          {
              if(high-low+1> end)
              {
                  start=low;
                  end=high-low+1;
              }
              low--;
              high++;
          }
          
          low=i-1;
          high=i+1;
          while(low>=0 && high<s.length() && s.charAt(low)==s.charAt(high))
          {
              if(high-low+1> end)
              {
                  start=low;
                  end=high-low+1;
              }
              low--;
              high++;
          }
          
      }
      
     String str="";
     
     for(int i=start;i<start+end;i++)
     {
         
         str=str+s.charAt(i);
     }
        
        return str;
        
    }
    
      
            

        }
    
        
        
        
     
     
     
     


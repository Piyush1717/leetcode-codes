//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution ob = new Solution();
            
            System.out.println(ob.minFlips(S));
                        
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution {
    public int minFlips(String S) {
        // Code here

        // 101010
        //or
        //010101
        
        int count1=0;
        int count2=0;
        
        char [] arr=S.toCharArray();
        
        for(int i=0;i<S.length();i++)
        {
            if(i%2==0 && arr[i]=='0')
            {
                count1++;
            }
            
            if(i%2==1 && arr[i]=='1')
            {
                count1++;
            }
            
            if(i%2==0 && arr[i]=='1')
            {
                count2++;
            }
            
            if(i%2==1 && arr[i]=='0')
            {
                count2++;
            }
            
        }

        return Math.min(count1, count2);
    }
}
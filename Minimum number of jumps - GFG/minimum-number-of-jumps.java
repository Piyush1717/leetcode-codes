//{ Driver Code Starts
import java.lang.*;
import java.io.*;
import java.util.*;
class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int t = Integer.parseInt(br.readLine()); 

        while(t-- > 0){
            int size = Integer.parseInt(br.readLine());
            String[] arrStr = ((String)br.readLine()).split("\\s+");
            int[] arr= new int[size];
            for(int i = 0;i<size;i++){
                arr[i] = Integer.parseInt(arrStr[i]);
            }
            System.out.println(new Solution().minJumps(arr));
        }
	 }
	 
}

// } Driver Code Ends


class Solution{
    static int minJumps(int[] arr){
        // your code here
        
        if(arr.length==1)
        {
            return -1;
        }
        
        if(arr[0]==0)
        {
            return -1;
        }
        
        int jumps=1;
        int steps=arr[0];
        int maxR=arr[0];
        
        for(int i=1;i<arr.length;i++)
        {
            if(i==arr.length-1)
            {
                return jumps;
            }
            
            maxR=Math.max(maxR, i+arr[i]);
            steps--;
            
            if(steps==0)
            {
                jumps++;
                
                if(maxR<=i)
                {
                    return -1;
                }
                steps=maxR-i;
            }
            
        }
        
        return jumps;
        
        
        
    }
}
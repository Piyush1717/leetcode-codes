//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine().trim());
        while(t-- > 0){
            
            int n; 
            n = Integer.parseInt(br.readLine().trim());
            
            
            int[] price = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.maxProfit(n, price);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int maxProfit(int n, int[] price) {
        
        int [] dpl=new int[n];
        int leastVal=price[0];
        int maxput=0;
        
        for(int i=1;i<n;i++)
        {
            if(price[i]<leastVal)
            {
                leastVal=price[i];
            }
            
            maxput=price[i]-leastVal;
            
            if(maxput>dpl[i-1])
            {
                dpl[i]=maxput;
            }
            else
            {
                dpl[i]=dpl[i-1];
            }
        }
        
        
        int maxVal=price[n-1];
        int [] dpr=new int[n];
        int maxpr=0;
        
        for(int i=n-2;i>=0;i--)
        {
            if(price[i]>maxVal)
            {
                maxVal=price[i];
            }
            
            maxpr=maxVal-price[i];
            
            if(maxpr>dpr[i+1])
            {
                dpr[i]=maxpr;
            }
            else
            {
                dpr[i]=dpr[i+1];
            }
        }
        
        
        int os=0;
        
        for(int i=0;i<n;i++)
        {
            
            os=Math.max(os, dpl[i]+dpr[i]);
            
        }
        
        return os;
    }
}
        

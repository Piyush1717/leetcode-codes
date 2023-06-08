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
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.nextPermutation(N, arr);
            StringBuilder out = new StringBuilder();
            for(int i = 0;i < N;i++)
                out.append(ans.get(i) + " ");
            System.out.println(out);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static List<Integer> nextPermutation(int N, int arr[]){
        // code here
        
        List<Integer> res=new ArrayList<>();
        int i=N-1;
        
        while(i>0)
        {
            if(arr[i-1]>=arr[i])
            {
                i--;
            }
            else
            {
                break;
            }
        }
        
        if(i==0)
        {
            Arrays.sort(arr);
            for(int ele: arr)
            {
                res.add(ele);
            }
            return res;
        }
        
        i=i-1;
        
        int j=N-1;
        
        while(j>i)
        {
            if(arr[j]>arr[i])
            {
                break;
            }
            else
            {
                j--;
            }
        }
        
        int temp=arr[j];
        arr[j]=arr[i];
        arr[i]=temp;
        
        Arrays.sort(arr,i+1,N);
        
        for(int ele: arr)
        {
            res.add(ele);
        }
        
        return res;
        
        
    }
}
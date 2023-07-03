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
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N; 
            N = Integer.parseInt(br.readLine());
            
            
            int K; 
            K = Integer.parseInt(br.readLine());
            
            
            int[] Arr = IntArray.input(br, N);
            
            Solution obj = new Solution();
            int res = obj.kthLargest(N, K, Arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int kthLargest(int N, int k, int[] arr) {
        // code here
        
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        
        int [] pre=new int[N+1];
        
        pre[0]=0;
        pre[1]=arr[0];
        
        for(int i=2;i<=N;i++)
        {
            pre[i]=pre[i-1]+arr[i-1];
        }
        
        for(int i=1;i<=N;i++)
        {
            for(int j=i;j<=N;j++)
            {
                int sum=pre[j]-pre[i-1];
                
                if(pq.size()<k)
                {
                    pq.add(sum);
                }
                else 
                {
                    if(pq.peek()<sum)
                    {
                        pq.remove();
                        pq.add(sum);
                    }
                    
                }
                
                
                
            }
            
        }
        
        return pq.peek();
        
        
        
    }
}
        

// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] edges = new int[m][3];
            for(int i = 0; i < m; i++){
                String S2[] = br.readLine().trim().split(" ");
                for(int j = 0; j < 3; j++)
                    edges[i][j] = Integer.parseInt(S2[j]);
            }
            Solution obj = new Solution();
            int ans = obj.isNegativeWeightCycle(n, edges);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int isNegativeWeightCycle(int n, int[][] edges)
    {
        int [] res=new int[n];
        Arrays.fill(res,100000000);
        res[0]=0;
        
        for(int i=1;i<=n-1;i++)
        {
            for(int [] edge:edges)
            {
                int u=edge[0];
                int v=edge[1];
                int wt=edge[2];
                
                if(res[u]==100000000)
                {
                    continue;
                }
                else if(res[v]==100000000)
                {
                    res[v]=res[u]+wt;
                }
                else
                {
                    res[v]=Math.min(res[v],res[u]+wt);
                }
            }
        }
        
        int [] original=new int [n];
        
         for(int i=0;i<n;i++)
            {
            original[i]=res[i];
            }
        
            for(int [] edge:edges)
            {
                int u=edge[0];
                int v=edge[1];
                int wt=edge[2];
                
                if(res[u]==100000000)
                {
                    continue;
                }
                else if(res[v]==100000000)
                {
                    res[v]=res[u]+wt;
                }
                else
                {
                    res[v]=Math.min(res[v],res[u]+wt);
                }
            }
            
            for(int i=0;i<n;i++)
            {
                if(res[i]!=original[i])
                {
                    return 1;
                }
            }
        
        return 0;
        
        
        
    }
}
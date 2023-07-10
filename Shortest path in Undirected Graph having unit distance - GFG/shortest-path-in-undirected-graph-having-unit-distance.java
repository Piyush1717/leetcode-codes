//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public int[] shortestPath(int[][] edge,int n,int m ,int src) {
        // Code here
        
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        
        for(int i=0;i<n;i++)
        {
            ArrayList<Integer> temp=new ArrayList<>();
            adj.add(temp);
        }
        
        for(int i=0;i<m;i++)
        {
            adj.get(edge[i][0]).add(edge[i][1]);
            adj.get(edge[i][1]).add(edge[i][0]);
        }
        
        int [] dist=new int[n];
        
        for(int i=0;i<n;i++)
        {
            dist[i]=Integer.MAX_VALUE;
        }
        dist[src]=0;
        
        Queue<Integer> q=new LinkedList<>();
        q.add(src);
        
        while(q.size()>0)
        {
            int val=q.poll();
            
            for(int ele: adj.get(val))
            {
                if(dist[ele]> dist[val]+1)
                {
                    dist[ele]=dist[val]+1;
                    q.add(ele);
                } 
            }
            
        }
        
        for(int i=0;i<dist.length;i++)
        {
            if(dist[i]==Integer.MAX_VALUE)
            {
                dist[i]=-1;
            }
        }
        
        return dist;
        
        
        
    }
}
//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to detect cycle in an undirected graph.
    
    public class pair{
        
        int x;
        int y;
        
        pair(int x, int y)
        {
            this.x=x;
            this.y=y;
        }
    }
    
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean [] vis=new boolean[V];
        
        for(int i=0;i<V;i++)
        {
            if(vis[i]==false)
            {
                boolean ans=bfs(i, V , adj, vis);
                if(ans==true)
                {
                    return true;
                }
            }
            
            
        }
        return false;
    }
    
    public boolean bfs(int i , int V,ArrayList<ArrayList<Integer>> adj, boolean [] vis )
    {
        vis[i]=true;
        ArrayDeque<pair> q=new ArrayDeque<>();
        pair node=new pair(i,-1);
        q.add(node);
        
        while(q.size()>0)
        {
            pair rem=q.poll();
            int n=rem.x;
            int parent=rem.y;
            
            for(int ele: adj.get(n))
            {
                if(vis[ele]==false)
                {
                    vis[ele]=true;
                    q.add(new pair(ele,n));
                }
                else if(parent!=ele)
                {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    
    
}
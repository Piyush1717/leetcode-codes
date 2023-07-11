//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    
   static class pair{
        int wt;
        int node;
        
        pair(int wt, int node)
        {
            this.wt=wt;
            this.node=node;
        }
        
    }
    
    
	static int spanningTree(int V, int E, int edge[][]){
	    // Code Here. 
	    
	    ArrayList<ArrayList<pair>> adj=new ArrayList<>();
	    
	    for(int i=0;i<V;i++)
	    {
	        ArrayList<pair> temp=new ArrayList<>();
	        adj.add(temp);
	    }
	    
	    for(int i=0;i<E;i++)
	    {
	        int node=edge[i][0];
	         int nbr=edge[i][1];
	          int wt=edge[i][2];
	        
	        adj.get(node).add(new pair(wt,nbr));
	        adj.get(nbr).add(new pair(wt,node));
	    }
	    
	    PriorityQueue<pair> pq=new PriorityQueue<pair>(
	        (a,b)-> a.wt-b.wt);
	    
	    pq.add(new pair(0,0));
	    
	    boolean [] vis=new boolean [V];
	    
	    int sum=0;
	    
	    while(pq.size()>0)
	    {
	        pair temp=pq.poll();
	        int val=temp.wt;
	        int node=temp.node;
	        
	        if(vis[node]==true)
	        {
	            continue;
	        }
	        
	        vis[node]=true;
	        sum+=val;
	     
	     
	            for(pair p: adj.get(node))
	            {
	                int nbr=p.node;
	                int wt=p.wt;
	                
	                if(vis[nbr]==false)
	                {
	                    pq.add(new pair(wt,nbr));
	                }
	    
	            }   
	    }
	    
	    return sum;
	    
	    
	}
}
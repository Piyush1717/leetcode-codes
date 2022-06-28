class Solution {
    
    public class edge{
        int src;
        int nbr;
        
        edge(int src,int nbr)
        {
            this.src=src;
            this.nbr=nbr;
        }
        
    }
    
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        //making graph
        ArrayList<edge> [] graph=new ArrayList[n];
        
        for(int i=0;i<n;i++)
        {
            graph[i]=new ArrayList<>();
        }
        
        
        for(int [] arr: edges)
        {
                 graph[arr[0]].add(new edge(arr[0],arr[1]));
        graph[arr[1]].add(new edge(arr[1],arr[0]));
        }
        
        boolean [] visited=new boolean[n];
        
       boolean ans= helper(graph,source,destination,visited);
        if(ans==true)
        {
            return true;
        }
        
        return false;
    }
    
    public boolean helper(ArrayList<edge> [] graph,int source, int destination, boolean [] visited)
    {
        if(source==destination)
        {
            return true;
        }
        
        visited[source]=true;
        
        for(edge e: graph[source])
        {
            int n=e.nbr;
            
            if(visited[n]==false)
            {
                boolean res=helper(graph,n,destination,visited);
                if(res==true)
                {
                    return true;
                }
            }
            
        }
        
        return false;
     
    }
    
    
    
}
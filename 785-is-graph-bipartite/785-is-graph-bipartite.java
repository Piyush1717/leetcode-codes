class Solution {
    
    public class pair{
        int vtx;
        int color;
        
        pair(int vtx,int color)
        {
            this.vtx=vtx;
            this.color=color;
        }
        
    }
    
    public boolean isBipartite(int[][] graph) {
        int [] visited=new int[graph.length];
        for(int i=0;i<graph.length;i++)
        {
            if(visited[i]==0)
            {
                boolean isBip=traverse(graph,visited,i);
                if(isBip==false)
                {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean traverse(int [][] graph,int [] visited, int v)
    {
        ArrayDeque<pair>q=new ArrayDeque<>();
        q.add(new pair(v,1));
        
        while(q.size()>0)
        {
            // r m w a
            pair rem=q.poll();
            
            if(visited[rem.vtx]!=0)
            {
                int oc=visited[rem.vtx];
                int nc=rem.color;
                
                if(oc==nc)
                {
                    continue;
                }
                else{
                    return false;
                }
            }
            
            visited[rem.vtx]=rem.color;
            
            for(int nbr: graph[rem.vtx])
            {
                if(visited[nbr]==0)
                {
                    q.add(new pair(nbr,rem.color*-1));
                }
            }
        }
        
       return true; 
    }
    
    
}
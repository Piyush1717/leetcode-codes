class Solution {
    
    public class pair{
        int i;
        int j;
        int level;
        
        pair(int i, int j, int level){
            this.i=i;
            this.j=j;
            this.level=level;
        }
        
    }
    
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        ArrayDeque<pair> q=new ArrayDeque<>();
        boolean [][] visited=new boolean[n][m];
        int [][] ans=new int [n][m];
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(mat[i][j]==0)
                {
                    q.add(new pair(i,j,0));
                }
            }
        }
        
        
        while(q.size()>0)
        {
            pair p=q.poll();
            
            if(visited[p.i][p.j]==true)
            {
                continue;
            }
            
            visited[p.i][p.j]=true;
            
            ans[p.i][p.j]=p.level;
            
            add(p.i+1,p.j, p.level+1,visited,q);
             add(p.i-1,p.j, p.level+1,visited,q);
             add(p.i,p.j+1, p.level+1,visited,q);
             add(p.i,p.j-1, p.level+1,visited,q);    
        }
        return ans;
    }
    
    public void add(int i, int j, int level,boolean [][] visited, ArrayDeque<pair> q){
        
        if(i<0 || j<0 || i>=visited.length || j>=visited[0].length || visited[i][j]==true)
        {
            return ;
        }
        q.add(new pair(i,j,level));
        
    }
    
}
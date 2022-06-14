class Solution {
    
    public class pair{
        int x;
        int y;
        int t;
        
        pair(int x,int y, int t)
        {
            this.x=x;
            this.y=y;
            this.t=t;
        }
        
    }
    
    int time;
    
    
    public int orangesRotting(int[][] grid) {
        ArrayDeque<pair> q=new ArrayDeque<>();
        int n=grid.length;
        int m=grid[0].length;
        int fresh=0;
        boolean [][] visited=new boolean[n][m];
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==2)
                {
                    q.add(new pair(i,j,0));
                }
                else if(grid[i][j]==1)
                {
                    fresh++;
                }
            }
        }
        
        
        while(q.size()>0)
        {
            pair rem=q.poll();
            
            if(visited[rem.x][rem.y]==true)
            {
                continue;
            }
            
                visited[rem.x][rem.y]=true;
            
            if(rem.t>time)
            {
                time=rem.t;
            }
            
            if(grid[rem.x][rem.y]==1)
            {
                fresh--;
            }
            
            add(rem.x-1,rem.y,grid,visited,q,rem.t+1);
               add(rem.x+1,rem.y,grid,visited,q,rem.t+1);
               add(rem.x,rem.y-1,grid,visited,q,rem.t+1);
               add(rem.x,rem.y+1,grid,visited,q,rem.t+1);
        }
        
        if(fresh==0)
        {
            return time;
        }
        else{
            return -1;
        }
      
    }
    
    public void add(int x,int y,int [][] grid, boolean [][] visited,ArrayDeque<pair> q,int time)
    {
        if(x<0 || x>=grid.length || y<0 || y>=grid[0].length )
        {
            return;
        }
        else if(visited[x][y]==true)
        {
            return;
        }
        else if(grid[x][y]==0)
        {
            return;
        }
        
        q.add(new pair(x,y,time));    
    }
    
}
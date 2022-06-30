class Solution {
    
    public class pair{
        int i;
        int j;
        int level;
        
        pair(int i, int j,int level)
        {
            this.i=i;
            this.j=j;
            this.level=level;
        }
    }
    
    public int shortestBridge(int[][] grid) {
        boolean [][] visited=new boolean[grid.length][grid[0].length];
        boolean flag=false;
        Queue<pair> q=new LinkedList<>();
        
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    dfs(grid,visited,q,i,j);
                    flag=true;
                    break;
                }
                
            }
            if(flag==true)
                break;
        }
        
        boolean [][] vis2=new boolean[grid.length][grid[0].length];
        
        while(q.size()>0)
        {
            pair rem=q.poll();
            
            if(vis2[rem.i][rem.j]==true)
            {
                continue;
            }
            
            vis2[rem.i][rem.j]=true;
            
            if(grid[rem.i][rem.j]==1)
            {
                return rem.level-1;
            }
            
            addN(vis2,q,grid,rem.i-1,rem.j,rem.level+1);
            addN(vis2,q,grid,rem.i+1,rem.j,rem.level+1);
            addN(vis2,q,grid,rem.i,rem.j-1,rem.level+1);
            addN(vis2,q,grid,rem.i,rem.j+1,rem.level+1);
        }
        
        return -1;
    }
    
    public void addN(boolean [][] visited,Queue<pair> q, int [][] grid, int i, int j,int level)
    {
         if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || visited[i][j]==true )
        {
            return;
        }
        else if(grid[i][j]==2)
        {
            return;
        }
        
        q.add(new pair(i,j,level));
        
        
        
    }
    
    public void dfs(int[][] grid,boolean [][] visited,Queue<pair> q,int i, int j)
    {
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || visited[i][j]==true || grid[i][j]==0)
        {
            return;
        }
        
        visited[i][j]=true;
        q.add(new pair(i,j,0));
        
        dfs(grid,visited,q,i-1,j);
        dfs(grid,visited,q,i+1,j);
        dfs(grid,visited,q,i,j-1);
        dfs(grid,visited,q,i,j+1);
        
        grid[i][j]=2;
    }
}
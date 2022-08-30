class Solution {
    int count;
    int [][] dir={{1,0},{0,-1},{0,1},{-1,0}};
    
    public int maxAreaOfIsland(int[][] grid) {
        
        int area=0;
        
        for(int i=0;i<grid.length;i++)
        {
            
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                     count=0;
                    dfs(grid,i,j);
                    
                    if(count>area)
                    {
                        area=count;
                    }
                    
                   
                }
            }
        }
    return area;    
    }
    
    
    public void dfs(int [][] grid, int i, int j)
    {
        grid[i][j]=0;
        
        count++;
        
        for(int [] d: dir)
        {
            int ii= i+ d[0];
            int jj=j + d[1];
         
            if(ii>=0 && ii<grid.length && jj>=0 && jj<grid[0].length && grid[ii][jj]==1 )
            {
              dfs(grid,ii,jj);
            }
        } 
    }
    
    
    
    
}
class Solution {
    
    public static int [][] dir={{1,0},{0,1},{-1,0},{0,-1}};
    
    public static void dfs(char [][] grid, int i, int j)
    {
        grid[i][j]='0';

for( int [] d: dir)
{
int r=i+d[0];
int c=j+d[1];

if(r>=0 && r<grid.length && c>=0 && c<grid[0].length && grid[r][c]=='1')
{
   dfs(grid,r,c);
}
}
      
    }
    
    public int numIslands(char[][] grid) {
            int ans=0;
int n=grid.length;
int m=grid[0].length;

for(int i=0;i<n;i++)
{
   for(int j=0;j<m;j++)
   {
if(grid[i][j]=='1')
{
ans+=1;
dfs(grid,i,j);
}
   }
}

return ans;

      }
}
        
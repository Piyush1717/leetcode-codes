class Solution {
    
    public class pair{
        int i;
        int j;
        boolean border;

            pair(int i,int j)
        {
            this.i=i;
            this.j=j;
        }
        
    }
    
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        ArrayDeque<pair> q=new ArrayDeque<>();
        boolean [][] visited=new boolean[grid.length][grid[0].length];
        int oc=grid[row][col];
        ArrayList<pair> res=new ArrayList<>();
        
        pair p=new pair(row,col);
        p.border=isBorder(grid,row,col);
        q.add(p);
        
        while(q.size()>0)
        {
            pair rem=q.poll();
            
            if(visited[rem.i][rem.j])
            {
                continue;
            }
            
            visited[rem.i][rem.j]=true;
            
            if(rem.border)
            {
                res.add(rem);
            }
            
            addN(q,grid,visited,oc,rem.i-1,rem.j);
            addN(q,grid,visited,oc,rem.i+1,rem.j);
            addN(q,grid,visited,oc,rem.i,rem.j-1);
            addN(q,grid,visited,oc,rem.i,rem.j+1);
        }
        
        for(pair pa:res)
        {
            grid[pa.i][pa.j]=color;
        }
        return grid;
    }
    
    public void addN(ArrayDeque<pair> q,int[][] grid,boolean [][] visited,int oc,int i,int j)
    {
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || visited[i][j]==true || grid[i][j]!=oc)
        {
            return ;
        }
        
        pair p=new pair(i,j);
        p.border=isBorder(grid,i,j);
        q.add(p);
        
    }
    
    public boolean isBorder(int [][] grid, int i, int j)
    {
        if(i==0)
        {
            return true;
        }
        else if(j==0)
        {
            return true;
        }
        else if(i==grid.length-1)
        {
            return true;
        }
        else if(j==grid[0].length-1)
        {
            return true;
        }
        else {
            int color=grid[i][j];
            if(grid[i-1][j]!=color)
            {
                return true;
            }
            else if(grid[i+1][j]!=color)
            {
                return true;
            }
            else if(grid[i][j-1]!=color)
            {
                return true;
            }
            else if(grid[i][j+1]!=color)
            {
                return true;
            }
            else
            {
                return false;
            }  
        } 
    }
    
    
}
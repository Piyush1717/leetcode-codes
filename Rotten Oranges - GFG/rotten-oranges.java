//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    class pair{
        int x;
        int y;
        int tesf;
        
        pair(int x,int y, int tesf)
        {
            this.x=x;
            this.y=y;
            this.tesf=tesf;
        }
    }
    
    
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        Queue<pair> q=new LinkedList<>();
        
        int time=0;
        boolean [][] vis=new boolean [grid.length][grid[0].length];
        int fresh=0;
        
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
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
        
        while(q.isEmpty()==false)
        {
            pair temp=q.poll();
            
            if(vis[temp.x][temp.y]==true)
            {
                continue;
            }
            
            vis[temp.x][temp.y]=true;
            
            if(temp.tesf>time)
            {
                time=temp.tesf;
            }
            
            if(grid[temp.x][temp.y]==1)
            {
                fresh--;
            }
            
            
            add(temp.x+1, temp.y,q, vis, grid, temp.tesf+1);
            add(temp.x-1, temp.y,q, vis, grid, temp.tesf+1);
            add(temp.x, temp.y+1,q, vis, grid, temp.tesf+1);
            add(temp.x, temp.y-1,q, vis, grid, temp.tesf+1);
        }
        
        if(fresh==0)
        {
            return time;
        }
        else
        {
            return -1;
        }
   
    }
    
    public void add(int i, int j, Queue<pair> q, boolean [][] vis , int [][] grid, int time)
    {
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || vis[i][j]==true || grid[i][j]==0 )
        {
            return;
        }
        
        q.add(new pair(i,j,time));
    }
    
    
    
    
    
}
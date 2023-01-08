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
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


class Solution
{
    
    public class pair{
        
        int i;
        int j;
        int d;
        
        pair(int i, int j, int d)
        {
            this.i=i;
            this.j=j;
            this.d=d;
        }
        
    }
    
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        boolean [][] vis=new boolean [grid.length][grid[0].length];
        
        int [][] ans=new int [grid.length][grid[0].length];
        
        ArrayDeque<pair> q=new ArrayDeque<>();
        
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    q.add(new pair(i,j,0));
                }
                
            }
        }
        
        while(q.size()>0)
        {
            pair rem=q.poll();
            
            if(vis[rem.i][rem.j]==true)
            {
                continue;
            }
            
            vis[rem.i][rem.j]=true;
            
            ans[rem.i][rem.j]=rem.d;
            
            
            add(rem.i+1, rem.j,rem.d+1, vis, grid,q);
            add(rem.i, rem.j+1,rem.d+1, vis, grid,q);
            add(rem.i-1, rem.j,rem.d+1, vis, grid,q);
            add(rem.i, rem.j-1,rem.d+1, vis, grid,q);
        }
        
        return ans;
        
    }
    
    public void add(int r, int c, int level, boolean [][] vis, int [][] grid, ArrayDeque<pair> q)
    {
        if(r<0 || r>= grid.length || c<0 || c>=grid[0].length || vis[r][c]==true)
        {
            return;
        }
        
        q.add(new pair(r,c,level));
        
        
    }
    
    
    
    
}
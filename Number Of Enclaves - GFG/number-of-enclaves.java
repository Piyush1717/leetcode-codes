//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.numberOfEnclaves(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int numberOfEnclaves(int[][] grid) {

        boolean [][] vis=new boolean [grid.length][grid[0].length];
        
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(i==0 || i==grid.length-1 || j==0 || j==grid[0].length-1)
                {
                    if(grid[i][j]==1)
                    {
                        dfs(i,j,vis,grid);
                    }
                    
                }
                
                
            }
            
        }
        
        int count=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    count++;
                }
                
            }
            
            
        }
        
        return count;
        
    }
    
    int [][] dir={{0,1},{1,0},{-1,0},{0,-1}};
    
    public void dfs(int i, int j, boolean [][] vis, int [][] grid)
    {
        grid[i][j]=0;
        vis[i][j]=true;
        
        for(int [] d: dir)
        {
            int r=i+d[0];
            int c=j+d[1];
            
            if(r>=0 && r<grid.length && c>=0 && c<grid[0].length && vis[r][c]==false && grid[r][c]==1)
            {
                dfs(r,c,vis,grid);
            }
            
        }
        
    }
    
    
    
}
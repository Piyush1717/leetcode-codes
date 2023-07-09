//{ Driver Code Starts
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
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        HashSet<String> set=new HashSet<>();
        
       StringBuilder sb=new StringBuilder();
        
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                 sb=new StringBuilder();
                sb.append("x");
                dfs(i,j,grid,sb);
                set.add(sb.toString());   
                }
            }
        }
        return set.size();
    }
    
    public void dfs(int i, int j, int [][] grid, StringBuilder asf)
    {
        grid[i][j]=0;
        
        if(i+1<grid.length && grid[i+1][j]==1)
        {
            asf.append("d");
            dfs(i+1,j,grid,asf);
        }
        
        
        if(i-1>=0 && grid[i-1][j]==1)
        {
            asf.append("u");
            dfs(i-1,j,grid,asf);
        }
        
        
        if(j+1<grid[0].length && grid[i][j+1]==1)
        {
            asf.append("r");
            dfs(i,j+1,grid,asf);
        }
        
        
        if(j-1>=0 && grid[i][j-1]==1)
        {
            asf.append("l");
            dfs(i,j-1,grid,asf);
        }
        
        asf.append("z");
        
        
        
    }
    
    
    
    
}

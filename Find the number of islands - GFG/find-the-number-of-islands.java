//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    
    int [][] dir={{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1}};
    
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // Code here
        
        int count=0;
        
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]=='1')
                {
                count++;
                dfs(i,j,grid);
                }
            }
        }
        
        return count;
    }
    
    public void dfs(int i , int j, char [][] grid)
    {
        grid[i][j]='0';
        
        for(int [] d : dir)
        {
            int r=i+d[0];
            int c=j+d[1];
            
            if(r>=0 && r< grid.length && c>=0 && c<grid[0].length && grid[r][c]=='1')
            {
                dfs(r,c,grid);
            }
        }
    }
    
    
}
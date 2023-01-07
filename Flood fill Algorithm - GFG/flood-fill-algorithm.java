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
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] image =  new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S2 = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    image[i][j] = Integer.parseInt(S2[j]);
            }
            String[] S3 = br.readLine().trim().split(" ");
            int sr = Integer.parseInt(S3[0]);
            int sc = Integer.parseInt(S3[1]);
            int newColor = Integer.parseInt(S3[2]);
            Solution obj = new Solution();
            int[][] ans = obj.floodFill(image, sr, sc, newColor);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++)
                    System.out.print(ans[i][j] + " ");
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


class Solution
{
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        int [][] copy=new int[image.length][image[0].length];
        
        boolean [][] vis=new boolean[image.length][image[0].length];
        
        for(int i=0;i<image.length;i++)
        {
            for(int j=0;j<image[0].length;j++)
            {
                copy[i][j]=image[i][j];
            }
        }
        
        int color= copy[sr][sc];
        
        copy[sr][sc]=newColor;
        
        dfs(sr, sc, color, copy , newColor, vis);
        
        return copy;
    }
    
    int [][] dir={{1,0}, {0,1},{-1,0},{0,-1}};
    
    public void dfs(int sr, int sc, int color,int [][] copy,int newColor, boolean [][] vis)
    {
        copy[sr][sc]=newColor;
        vis[sr][sc]=true;
        
        for(int [] d: dir)
        {
            int x=sr +d[0];
            int y=sc+ d[1];
            
            if(x>=0 && x< copy.length && y>=0 && y< copy[0].length && vis[x][y]==false && copy[x][y]==color)
            {
                dfs(x,y, color, copy, newColor, vis);
            }
        }
        
    }
    
    
    
}
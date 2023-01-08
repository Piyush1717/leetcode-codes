//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static char[][] fill(int n, int m, char a[][])
    {
        boolean [][] vis=new boolean[n][m];
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(i==0 || i==n-1 || j==0 || j==m-1)
                {
                    if(a[i][j]=='O' && vis[i][j]==false)
                    {
                    dfs(i,j,vis,a,n,m);    
                    }
                }
                
            }
        }
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(a[i][j]=='O' && vis[i][j]==false)
                {
                    a[i][j]='X';
                }
            }
        }
        
        return a;
    }
    
    static int [][] dir={{1,0},{0,1},{-1,0},{0,-1}};
    
    public static void dfs(int i, int j, boolean [][] vis, char [][] a,int n, int m)
    {
        vis[i][j]=true;
        
        for(int [] d: dir)
        {
            int r=i+d[0];
            int c=j+d[1];
            
            if(r>=0 && r<n && c>=0 && c<m && a[r][c]=='O' && vis[r][c]==false)
            {
                dfs(r,c,vis,a,n,m);
            }
        }
        
    }
    
    
    
}
//{ Driver Code Starts
//Initial Template for Java

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
            String[] s1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            char[][] grid = new char[n][m];
            for(int i = 0; i < n; i++){
                String S = br.readLine().trim();
                for(int j = 0; j < m; j++){
                    grid[i][j] = S.charAt(j);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            int[][] ans = obj.searchWord(grid, word);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
            if(ans.length==0)
            {
                System.out.println("-1");
            }

        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public class pair{
        int x;
        int y;
        
        pair(int x, int y)
        {
            this.x=x;
            this.y=y;
        }
    }
    
    
    public int[][] searchWord(char[][] mat, String str)
    {
        // Code here
        
         ArrayList<pair> ans=new ArrayList<>();
         

        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[0].length;j++)
            {
                int val=solve(i,j,mat,str,str.length(),0,0);
                
                if(val>0)
                {
                    pair p=new pair(i,j);
                    ans.add(p);
                }
                
            }

        }

        
       int [][] res=new int[ans.size()][2];
       
       for(int i=0;i<ans.size();i++)
       {
           pair temp=ans.get(i);
           
           res[i][0]=temp.x;
           res[i][1]=temp.y;
       }
return res;
       
    }
    
     public int solve(int i, int j, char [][] mat, String str, int len, int idx,int dir)
    {
        int found=0;
        if(i>=0 && j>=0 && i<mat.length && j<mat[0].length && str.charAt(idx)==mat[i][j])
        {
            idx=idx+1;

            if(idx==str.length())
            {
                found=1;
            }
            else
            {
                if(dir==0)
                {
                found+=solve(i+1,j,mat,str,str.length(),idx,7);
                found+=solve(i-1,j,mat,str,str.length(),idx,3);
                found+=solve(i,j+1,mat,str,str.length(),idx,1);
                found+=solve(i,j-1,mat,str,str.length(),idx,5);
                
                //diagonal
                
                 found+=solve(i-1,j-1,mat,str,str.length(),idx,4);
                  found+=solve(i-1,j+1,mat,str,str.length(),idx,2);
                  found+=solve(i+1,j+1,mat,str,str.length(),idx,8);
                  found+=solve(i+1,j-1,mat,str,str.length(),idx,6);
                }
                else if(dir==1)
                {
                       found+=solve(i,j+1,mat,str,str.length(),idx,1);
                    
                }
                else if(dir==2)
                {
                     found+=solve(i-1,j+1,mat,str,str.length(),idx,2);
                }
                else if(dir==3)
                {
                    found+=solve(i-1,j,mat,str,str.length(),idx,3);
                }
                else if(dir==4)
                {
            found+=solve(i-1,j-1,mat,str,str.length(),idx,4);
                }
                else if(dir==5)
                {
                        found+=solve(i,j-1,mat,str,str.length(),idx,5);
                }
                else if(dir==6)
                {
                      found+=solve(i+1,j-1,mat,str,str.length(),idx,6);
                    
                }
                else if(dir==7)
                {
                       found+=solve(i+1,j,mat,str,str.length(),idx,7); 
                }
                else if(dir==8)
                {
                         found+=solve(i+1,j+1,mat,str,str.length(),idx,8);
                    
                }
            }

        
        }

        return found;
    }
    
}
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
            int N = Integer.parseInt(br.readLine().trim());
            String[] S1 = br.readLine().trim().split(" ");
            String[] S2 = br.readLine().trim().split(" ");
            int[] KnightPos = new int[2];
            int[] TargetPos = new int[2];
            for(int i = 0; i < 2; i++){
                KnightPos[i] = Integer.parseInt(S1[i]);
                TargetPos[i] = Integer.parseInt(S2[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minStepToReachTarget(KnightPos, TargetPos, N);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends


class Solution
{
    class pair{
        int i;
        int j;
        int steps;
        
        pair(int i, int j, int steps)
        {
            this.i=i;
            this.j=j;
            this.steps=steps;
        }
    }
    
    
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int knightPos[], int TargetPos[], int N)
    {
        Queue<pair> q=new LinkedList<>();
        
        boolean vis[][]=new boolean[N][N];
        
        q.add(new pair(knightPos[0]-1, knightPos[1]-1, 0));
        
        while(q.size()>0)
        {
            pair temp=q.poll();
            
            if(vis[temp.i][temp.j]==true)
            {
                continue;
            }
            
            vis[temp.i][temp.j]=true;
            
            if(temp.i==TargetPos[0]-1 && temp.j==TargetPos[1]-1)
            {
                return temp.steps;
            }
            
            add(temp.i-2,temp.j-1,temp.steps+1,vis,q);
            add(temp.i-2,temp.j+1,temp.steps+1,vis,q);
            add(temp.i-1,temp.j-2,temp.steps+1,vis,q);
            add(temp.i-1,temp.j+2,temp.steps+1,vis,q);
            add(temp.i+1,temp.j-2,temp.steps+1,vis,q);
            add(temp.i+1,temp.j+2,temp.steps+1,vis,q);
            add(temp.i+2,temp.j-1,temp.steps+1,vis,q);
            add(temp.i+2,temp.j+1,temp.steps+1,vis,q);
        }
        return 0;
    }
    
    public void add(int i, int j, int steps,boolean [][] vis, Queue<pair>q)
    {
        if(i<0 || j<0 || i>=vis.length || j>=vis[0].length )
        {
            return;
        }
        else if( vis[i][j]==true)
        {
            return;
        }
        
        q.add(new pair(i,j,steps));
    }
    
    
    
    
}
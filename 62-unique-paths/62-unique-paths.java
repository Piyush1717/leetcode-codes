class Solution {
    
    public static boolean inRange(int i,int j, int m , int n){
     
        if(i < 0 || i >= m || j < 0 || j >= n)
            return false;
        return true;
    }

    public static int  mazePath_01(int sr,int sc,int m,int n,int [][]dir, int [][] dp)
    {
             if(sr == m-1 && sc == n-1){
            return dp[sr][sc]=1;
        }
        
        if(dp[sr][sc]!=0)
        {
            return dp[sr][sc];
        }
        
        
                int count  = 0;
        for(int d = 0; d < dir.length; d++){
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if(inRange(r,c,m,n)){
                count += mazePath_01(r,c, m,n, dir,dp);
            }
        }
        return dp[sr][sc]=count;

    }
    
    
    public int uniquePaths(int m, int n) {
 int sr=0;
        int sc=0;
        
        int [][] dir = {{0,1}, {1,0}};
int [][] dp=new int[m][n];
        
         int ans = mazePath_01(sr,sc,m,n,dir,dp);
        return ans;
    }
}
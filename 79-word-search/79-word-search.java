class Solution {
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(board[i][j]!=word.charAt(0))
                {
                    continue;
                }
                else
                {
                    boolean res=search(board,i,j,0,word);
                        if(res)
                        {
                            return true;
                        }
                }
                
            }
        }
        
        return false;
    }
    
    int [][] dir={{1,0},{0,1},{-1,0},{0,-1}};
    
    public boolean search(char [][] board, int i, int j, int si, String s)
    {
        if(si==s.length())
        {
            return true;
        }
        
            if(i<0 || j<0 || i>=board.length || j>=board[0].length )
        {
            return false;
        }
        
        if(s.charAt(si)!=board[i][j])
        {
            return false;
        }
        
    
        
        char temp=board[i][j];
        board[i][j]='@';
        
        for(int [] d: dir)
        {
            int r=i + d[0];
             int c=j + d[1];
            
            boolean res=search(board,r,c,si+1,s);
            if(res)
            {
                board[i][j]=temp;
                return true;
            }
        }
        board[i][j]=temp;
        return false;
        
        
        
        
    }
    
    
    
}
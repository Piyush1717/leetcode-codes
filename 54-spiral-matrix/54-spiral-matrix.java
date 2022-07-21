class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int left=0;
        int right=m-1;
            int top=0;
        int bottom=n-1;
            int dir=0;
        List<Integer> ans=new ArrayList<>();
        
        while(top<=bottom && left<=right)
        {
            if(dir==0)
            {
                for(int i=left;i<=right;i++)
                {
                    ans.add(matrix[top][i]);
                }
                top+=1;
            }
            else if(dir==1)
            {
                for(int i=top;i<=bottom;i++)
                {
                    ans.add(matrix[i][right]);
                }
                right-=1;
            }
            else if(dir==2)
             {
                for(int i=right;i>=left;i--)
                {
                    ans.add(matrix[bottom][i]);
                }
                bottom-=1;
            }
            else if(dir==3)
             {
                for(int i=bottom;i>=top;i--)
                {
                    ans.add(matrix[i][left]);
                }
                left+=1;
            }
                dir=(dir+1)%4;
        }
        
        return ans;
            
            
        
    }
}
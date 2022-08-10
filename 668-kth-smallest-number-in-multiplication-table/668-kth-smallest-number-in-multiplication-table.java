class Solution {
    public int findKthNumber(int m, int n, int k) {
        
        
        int low=1;
        int hi=m*n;
        int reqd=k;
        
        while(low<hi)
        {
            int mid=low+(hi-low)/2;
            
            int actual=0;
            int j=n;
            
            for(int i=1;i<=m;i++)
            {
                while(j>=1 && i*j>mid)
                {
                    j--;
                }
                
                actual+=j;
                
            }
            
            if(actual<reqd)
            {
                low=mid+1;
                
            }
            else
            {
                hi=mid;
                
            }
        }
        
        return low;
    }
}
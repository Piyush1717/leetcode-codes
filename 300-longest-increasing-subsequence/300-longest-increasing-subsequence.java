class Solution {
    public int lengthOfLIS(int[] A) {
   
        int [] lis=new int[A.length];
        lis[0]=1;
        
        for(int i=1;i<A.length;i++)
        {
            int max=0;
            
            for(int j=0;j<i;j++)
            {
                if(A[j]<A[i])
                {
                    max=Math.max(max,lis[j]);
                    
                }
                
            }
            
            lis[i]=max+1;
            
            
        }
        
        
        int len=0;
        for(int ele: lis)
        {
            len=Math.max(len,ele);
        }
        
        return len;
        
        
        
    }
}
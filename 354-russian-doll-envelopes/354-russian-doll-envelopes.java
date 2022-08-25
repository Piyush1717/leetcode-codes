class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        
        Arrays.sort(envelopes,(a,b)->{
           
            if(a[0]!=b[0])
            {
                return a[0]-b[0];
            }
            else
            {
               return b[1]-a[1];
            }
        });
        
   
        int [] tails=new int[envelopes.length];
        int len=1;
        tails[0]=envelopes[0][1];
        
        for(int i=1;i<envelopes.length;i++)
        {
            if(envelopes[i][1]>tails[len-1] )
            {
                len++;
                tails[len-1]=envelopes[i][1];
            }
            else
            {
                int idx=Arrays.binarySearch(tails,0,len-1,envelopes[i][1]);
                if(idx<0)
                {
                    idx=-idx;
                    idx=idx-1;   
                }
                   tails[idx]=envelopes[i][1]; 
            }
        }
        
        return len;
        
        
    }
}
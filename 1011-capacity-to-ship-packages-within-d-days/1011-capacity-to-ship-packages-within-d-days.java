class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
              int las=Integer.MIN_VALUE;
        int has=0;
        
        for(int num:weights)
        {
            las=Math.max(las,num);
            has+=num;
        }
        
        while(las<has)
        {
            int as=(las+has)/2;
            
            int partPos=1;
            int currPartSum=0;
            
            for(int num:weights)
            {
                if(currPartSum+num<=as)
                {
                    currPartSum+=num;
                }
                else
                {
                    partPos++;
                    currPartSum=num;
                }
            }
            
            if(partPos>days)
            {
                las=as+1;
            }
            else
            {
                has=as;
            }
            
        }
        
        return las;
        
        
        
    }
}
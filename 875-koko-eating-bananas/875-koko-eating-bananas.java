class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
              int las=1;
        int has=0;
        
        for(int num:piles)
        {
            has=Math.max(has,num);
        }
        
        while(las<has)
        {
            int as=(las+has)/2;
            
         int totaltime=0;
            
            for(int num:piles)
            {
                
                int time=(num+as-1)/as;
                totaltime+=time;
            }
            
            if(totaltime>h)
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
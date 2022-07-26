class Solution {
    public int reachNumber(int target) {
        int tar=Math.abs(target);
        
        int x=0;
        
        while(true)
        {
            int range=(x*(x+1))/2;
            
            if(tar<=range && tar%2==range%2)
            {
                break;
            }
            x++;
        }
        
        return x;
        
    }
}
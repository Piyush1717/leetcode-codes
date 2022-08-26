class Solution {
    public int findFinalValue(int[] nums, int original) {
        
        
        while(true)
        {
            boolean flag=false;
            
            for(int ele:nums)
            {
                if(ele==original)
                {
                    flag=true;
                }
            }
            
            if(flag==true)
            {
                original=2*original;
            }
            else
            {
                
                break;
            }
            
        }
        
        return original;
        
    }
}
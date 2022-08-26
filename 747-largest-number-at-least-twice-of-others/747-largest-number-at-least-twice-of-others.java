class Solution {
    public int dominantIndex(int[] nums) {
        
        int idx=0;
        int max=Integer.MIN_VALUE;
        
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>max)
            {
                max=nums[i];
                idx=i;
            }
        }
        
        boolean flag=true;
        for(int i=0;i<nums.length;i++)
        {
            if(i!=idx)
            {
                if(2*nums[i]>nums[idx])
                {
                    flag=false;
                }
            }
            
            
        }
        
        if(flag==false)
        {
            return -1;
        }
        
        return idx;
        
    }
}
class Solution {
    public int singleNonDuplicate(int[] nums) {
        
        int lo=0;
        int hi=nums.length-2;
        
        while(lo<=hi)
        {
            int mid=(lo+hi)/2;
            if(nums[mid]==nums[mid^1])
            {
                lo=mid+1;
            }
            else
            {
                hi=mid-1;
            }
        }
        
        
        
        return nums[lo];
    }
}
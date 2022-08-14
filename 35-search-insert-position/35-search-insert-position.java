class Solution {
    public int searchInsert(int[] nums, int target) {
        
        int low=0;
        int hi=nums.length-1;
        
        while(low<hi)
        {
            int mid=(low+hi)/2;
            
            if(nums[mid]>target)
            {
                hi=mid;
            }
            else if(nums[mid]==target)
            {
                return mid;
            }
            else
            {
                low=mid+1;
            }
        }
        
        if(target>nums[low])
        {
            return low+1;
        }
        
        return low;
        
    }
}
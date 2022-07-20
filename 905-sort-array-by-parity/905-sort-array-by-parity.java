class Solution {
    public int[] sortArrayByParity(int[] nums) {
        
        int i=0;
        int j=0;
        
        while(i<nums.length)
        {
            if(nums[i]%2==1)
            {
                i++;
            }
            else
            {
                int temp=nums[j];
                nums[j]=nums[i];
                nums[i]=temp;
                
                i++;
                j++;
            }
        }
        
        return nums;
        
        
    }
}
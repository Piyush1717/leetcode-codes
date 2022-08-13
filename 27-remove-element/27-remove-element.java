class Solution {
    public int removeElement(int[] nums, int val) {
   
        int count=0;
        
        for(int i=0;i<nums.length;i++)
        {
            
            if(nums[i]!=val)
            {
                count++;
            }
        }
        
        int i=0;
        int j=0;
        
        while(j<nums.length)
        {
            
            if(nums[j]!=val)
            {
                nums[i]=nums[j];
                i++;
                j++;
            }
            else
            {
                j++;
            }
      
        }
        
        
   return count;
        
    }
}
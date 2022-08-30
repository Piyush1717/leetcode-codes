class Solution {
    public int minimumDifference(int[] nums, int k) {
        
        Arrays.sort(nums);
        
        int i=0;
        int j=k-1;
        
        int min=Integer.MAX_VALUE;
        
        while(j<nums.length)
        {
            int diff=nums[j]-nums[i];
            
            if(diff<min)
            {
                min=diff;
            }
            
            i++;
            j++;
            
        }
        
        
        return min;
        
    }
}
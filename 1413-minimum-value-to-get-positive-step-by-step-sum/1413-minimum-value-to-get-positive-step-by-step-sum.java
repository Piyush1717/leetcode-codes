class Solution {
    public int minStartValue(int[] nums) {
        
        int min=Integer.MAX_VALUE;
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            if(min>sum)
            {
                min=sum;
            }
            
        }
        
        
        if(min>=1)
        {
            return 1;
        }
        
        min=(min)*(-1);
        
        min++;
        
        return  min;
        
    }
}
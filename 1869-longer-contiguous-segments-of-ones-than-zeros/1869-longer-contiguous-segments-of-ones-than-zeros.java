class Solution {
    public boolean checkZeroOnes(String s) {
        
        char [] nums=s.toCharArray();
        
             int count=0;
        int max=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]=='1')
            {
                count++;
                
            }else
            {
                count=0;
            }
            
            max=Math.max(max,count);
        }
        
        
                 count=0;
        int max2=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]=='0')
            {
                count++;
                
            }else
            {
                count=0;
            }
            
            max2=Math.max(max2,count);
        }
        
        if(max>max2)
        {
            return true;
        }
        
        return false;
        
        
        
    }
}
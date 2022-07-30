class Solution {
    public boolean checkOnesSegment(String s) {
        
           char [] nums=s.toCharArray();
        
        int n=nums.length;
  int count=0;
        int i=0;
        while(i<n)
        {
            
            if(nums[i]=='1')
            {
                count++;
                
                while(nums[i]=='1' && i<n-1)
                {
                    i++;
                }
                
            }
            i++;
        }
        
        if(count==1)
        {
            return true;
        }
        
        return false;
        
    }
}
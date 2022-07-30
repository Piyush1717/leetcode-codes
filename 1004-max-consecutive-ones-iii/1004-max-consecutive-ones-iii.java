class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int ans=0;
        int i=0;
        int j=0;
        int countZ=0;
        int n=nums.length;
        while(j<n)
        {
            if(nums[j]==0)
            {
                countZ++;
            }
            
            while(countZ>k)
            {
                if(nums[i]==0)
                {
                    countZ--;
                }
                i++;
            }
            
            ans=Math.max(ans,j-i+1);
            j++;
        }
        
        return ans;
        
        
    }
}
class Solution {

    
    public void nextPermutation(int[] nums) {
     
        int n=nums.length;
        if(n==1)
        {
            return;
        }
        
        int lastPeak=-1;
        int i=1;
        while(i<n)
        {
            if(nums[i]>nums[i-1])
            {
                lastPeak=i;
            }
            i++;
        }
        
        if(lastPeak==-1)
        {
            Arrays.sort(nums);
            return;
        }
        
        int index=lastPeak;
        int val=nums[lastPeak];
        
        for(int j=lastPeak+1;j<n;j++)
        {
            if(nums[j]>nums[lastPeak-1] && nums[j]<nums[index])
            {
                index=j;
            }
        }
        
        //swap
        int temp=nums[index];
        nums[index]=nums[lastPeak-1];
        nums[lastPeak-1]=temp;
        
        Arrays.sort(nums,lastPeak,n);
        
   
    }
}
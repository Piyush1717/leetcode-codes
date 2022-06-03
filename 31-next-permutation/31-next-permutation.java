class Solution {

    
    public void nextPermutation(int[] nums) {
        
        int n=nums.length;
        
        if(nums.length==1)
        {
            return;
        }
        
        
        int i=1;
        int lastInd=-1;
        
        while(i<n)
        {
            if(nums[i]>nums[i-1])
            {
                lastInd=i;
            }
            i++;
        }
        
        if(lastInd==-1)
        {
            Arrays.sort(nums);
            return;
        }
        
        int index=lastInd;
        for(int j=lastInd+1;j<n;j++)
        {
            if(nums[j]>nums[lastInd-1] && nums[j]<nums[index])
            {
                index=j;
            }
        }
        
        // swap(nums,index,lastIdx-1);
        
        int temp=nums[index];
        nums[index]=nums[lastInd-1];
        nums[lastInd-1]=temp;
        
        Arrays.sort(nums,lastInd,n);
   
    }
}
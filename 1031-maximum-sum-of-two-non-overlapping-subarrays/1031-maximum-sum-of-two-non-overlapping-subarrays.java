class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int f1, int s1) {
        
        int max1=getMax(nums,f1,s1);
        int max2=getMax(nums,s1,f1);
        
        return Math.max(max1,max2);
    }
    
    public int getMax(int[] nums, int f1, int s1)
    {
        int [] left=new int[nums.length];
        
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            if(i==f1-1)
            {
                left[i]=sum;
            }else if(i>=f1)
            {
                sum-=nums[i-f1];
                left[i]=Math.max(left[i-1],sum);
            }
        }
        
        
        int [] right=new int[nums.length];
        sum=0;
        
        for(int i=nums.length-1;i>=0;i--)
        {
            sum+=nums[i];
            if(i==nums.length-s1)
            {
                right[i]=sum;
            }
            else if(i<nums.length-s1)
            {
                sum-=nums[i+s1];
                right[i]=Math.max(right[i+1],sum);
            }
        }
        
        int max=Integer.MIN_VALUE;
        
        for(int i=f1-1;i<nums.length-s1;i++)
        {
            max=Math.max(max,left[i]+right[i+1]);
        }
        
        return max;
    
    }
    
    
    
}
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        
        int [] left=new int[n];
        int [] right=new int[n];
        int [] output=new int[n];
        
        
        int lsum=1;
        for(int i=0;i<n;i++)
        {
            lsum*=nums[i];
            left[i]=lsum;
        }
        
                int rsum=1;
        for(int i=n-1;i>=0;i--)
        {
            rsum*=nums[i];
            right[i]=rsum;
        }
        
        
        output[0]=right[1];
        output[n-1]=left[n-2];
        
        for(int i=1;i<n-1;i++)
        {
            output[i]=left[i-1]*right[i+1];
        }
        
        return output;
        
        
    }
}
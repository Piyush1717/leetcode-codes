class Solution {
    
    
    public int sumSubseqWidths(int[] nums) {
 
        Arrays.sort(nums);
        long ans=0;
        long p=1;
        
        int j=nums.length-1;
        
        for(int i=0;i<nums.length;i++)
        {
            ans=(ans+ p*nums[i] - p*nums[j])%1000000007;
            j--;
            p=(p*2)%1000000007;
        }
        
        return (int)ans;
        
        
    }
}
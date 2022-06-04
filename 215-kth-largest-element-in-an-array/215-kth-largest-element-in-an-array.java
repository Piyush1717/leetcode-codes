class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        int m=n-1;
        
        for(int i=0;i<k-1;i++)
        {
            m=m-1;;
        }
        
        return nums[m];
        
    }
}
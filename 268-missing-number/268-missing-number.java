class Solution {
    public int missingNumber(int[] nums) {
        
        int n=nums.length;
        
        boolean [] arr=new boolean [n+1];
        
        for(int ele: nums)
        {
            arr[ele]=true;
        }
        
        
        int ans=0;
        
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==false)
            {
                ans=i;
            }
        }
        
        return ans;
        
    }
}
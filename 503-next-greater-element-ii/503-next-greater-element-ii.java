class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        int n=nums.length;
        
        Stack<Integer> st=new Stack<>();
        
        for(int i=n-2;i>=0;i--)
        {
            while(st.size()>0 && nums[i]>st.peek())
            {
                st.pop();
            }
            st.push(nums[i]);
        }
        
        int [] ans=new int[n];
        
        
        for(int i=n-1;i>=0;i--)
        {
            while(st.size()>0 && nums[i]>=st.peek())
            {
                st.pop();
            }
            
            ans[i]=st.size()>0?st.peek():-1;
            
            st.push(nums[i]);
        }
        
        return ans;
        
        
    }
}
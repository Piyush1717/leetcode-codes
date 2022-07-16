class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    
        int [] ngr=nextGreater(nums2);
     
        HashMap<Integer, Integer> hm=new HashMap<>();
        
        for(int i=0;i<nums2.length;i++)
        {
            
            hm.put(nums2[i],ngr[i]);
        }
        
        int [] ans=new int [nums1.length];
        
        for(int i=0;i<nums1.length;i++)
        {
            ans[i]=hm.get(nums1[i]);
        }
        
        return ans;
    }
    
    public int [] nextGreater(int [] nums2)
    {
        Stack<Integer> st=new Stack<>();
        
        int [] ans=new int[nums2.length];
        
        for(int i=ans.length-1;i>=0;i--)
        {
            while(st.size()>0 && st.peek()<nums2[i])
            {
                st.pop();
            }
            ans[i]=st.size()>0?st.peek():-1;
            st.push(nums2[i]);
        }
        
        
        return ans;
        
    }
    
    
}
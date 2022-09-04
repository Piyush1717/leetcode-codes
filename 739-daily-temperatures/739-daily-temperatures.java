class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int [] ans=new int[temperatures.length];
        
        int count=0;
        int j=0;
        
        Stack<Integer> st=new Stack<>();
        
        for(int i=temperatures.length-1;i>=0;i--)
        {
        
            while(st.size()>0 && temperatures[st.peek()]<=temperatures[i])
            {
                st.pop();
            }
            
           ans[i]=(st.size()>0)? st.peek()-i : 0;
            
            st.push(i);
            
            
        }
        
        
        return ans;
        
        
    }
}
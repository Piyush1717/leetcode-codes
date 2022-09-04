class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int [] left=nextSmallerToLeft(heights);
          int [] right=nextSmallerToRight(heights);
        
        int max=0;
        
        for(int i=0;i<left.length;i++)
        {
            max=Math.max(max, heights[i] * (right[i]-left[i]-1));
        }
        
        return max;
    }
    
    public int [] nextSmallerToRight(int [] arr)
    {
        
        
        int [] ans=new int[arr.length];
        
        Arrays.fill(ans,arr.length);
        
        Stack<Integer> st=new Stack<>();
        
        for(int i=0;i<arr.length;i++)
        {
            while(st.size()>0 && arr[st.peek()]>arr[i])
            {
                ans[st.peek()]=i;
                st.pop();
            }
            
            st.push(i);            
        }
        
        
        return ans;
        
    }
    
    
    
    public int [] nextSmallerToLeft(int [] arr)
    {
        int [] ans=new int[arr.length];
        Stack<Integer> st=new Stack<>();
        
        Arrays.fill(ans,-1);
        
        for(int i=arr.length-1;i>=0;i--)
        {
            while(st.size()>0 && arr[st.peek()]>arr[i])
            {
                ans[st.peek()]=i;
                st.pop();
            }
            
            st.push(i);            
        }
        
        
        return ans;
        
    }
    
    
    
}
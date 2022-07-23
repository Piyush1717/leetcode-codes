class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int [] right=new int [n];
        
        Stack<Integer> st=new Stack();
        st.push(n-1);
        right[n-1]=n;
        
        for(int i=n-2;i>=0;i--)
        {
            while(st.size()>0 && heights[i]<=heights[st.peek()])
            {
                st.pop();
            }
            
            if(st.size()==0)
            {
                right[i]=n;
            }
            else
            {
                right[i]=st.peek();
            }
            
            st.push(i);
        }
        
        
         int [] left=new int [n];
        
         st=new Stack();
        st.push(0);
        left[0]=-1;
        
        for(int i=1;i<=n-1;i++)
        {
            while(st.size()>0 && heights[i]<heights[st.peek()])
            {
                st.pop();
            }
            
            if(st.size()==0)
            {
                left[i]= -1;
            }
            else
            {
                left[i]=st.peek();
            }
            
            st.push(i);
        }
        
        int max=0;
        
        for(int i=0;i<n;i++)
        {
            int width=right[i]-left[i]-1;
            int area=width*heights[i];
            
            if(area>max)
            {
                max=area;
            }
            
        }
        
        
        
        return max;
        
    }
}
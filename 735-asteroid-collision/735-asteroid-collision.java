class Solution {
    public int[] asteroidCollision(int[] a) {
        
        Stack<Integer> st=new Stack<>();
        
        for(int i=0;i<a.length;i++)
        {
            if(st.size()==0)
            {
                st.push(a[i]);
            }
            else if(a[i]>0)
            {
                st.push(a[i]);
            }
            else if(st.peek()<0)
            {
                st.push(a[i]);
            }
            else
            {
                while(st.size()>0 && st.peek()>0 && st.peek()< Math.abs(a[i]))
                {
                    st.pop();
                }
            
                if(st.size()==0)
                {
                    st.push(a[i]);
                }
                else if(st.peek()<0)
                {
                    st.push(a[i]);
                }
                else if(st.peek()== Math.abs(a[i]))
                {
                    st.pop();
                }
                else if(st.peek()> Math.abs(a[i]))
                {
                   
                }
                
            }
        }
        
        int [] ans=new int[st.size()];
        
        
        int idx=st.size()-1;
        
        while(st.size()>0)
        {
            ans[idx--]=st.pop();
            
        }
        
        return ans;
    }
}
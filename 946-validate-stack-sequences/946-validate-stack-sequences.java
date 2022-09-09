class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        
        int i=0;
        int j=0;
        
        Stack<Integer> st=new Stack<>();
        
        while(i<pushed.length)
        {
            st.push(pushed[i]);
            i++;
            
            while(st.size()>0 && j<popped.length && st.peek()==popped[j])
            {
                st.pop();
                j++;
            }
            
            
            
            
        }
        
        if(j==popped.length)
        {
            return true;
        }
        
        return false;
        
        
    }
}
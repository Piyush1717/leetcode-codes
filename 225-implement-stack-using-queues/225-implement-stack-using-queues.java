class MyStack {
    
       Queue<Integer> q1;
         Queue<Integer> q2;

    public MyStack() {
        
       q1=new LinkedList<>();
        q2=new LinkedList<>();
    }
    
    public void push(int x) {
        
        q2.add(x);
        
        while(!q1.isEmpty())
        {
            q2.add(q1.remove());
        }
        
        
        while(!q2.isEmpty())
        {
            q1.add(q2.remove());
        }
        
        
    }
    
    public int pop() {
       int ans= q1.remove();
        return ans;
    }
    
    public int top() {
       int res= q1.peek();
        return res;
    }
    
    public boolean empty() {
        
        if(q1.isEmpty()==true)
        {
            return true;
        }
        
        return false;
        
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
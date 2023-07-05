//{ Driver Code Starts
import java.util.Scanner;
import java.util.Stack;
class SpeStack{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			Stack<Integer> s=new Stack<>();
			GfG g=new GfG();
			while(!g.isEmpty(s)){
			    g.pop(s);
			}
			while(!g.isFull(s,n)){
				g.push(sc.nextInt(),s);
			}
		System.out.println(g.min(s));
		}
	}
}
// } Driver Code Ends


/*Complete the function(s) below*/
class GfG{
    
    int minEle;
    
	public void push(int a,Stack<Integer> s)
	{
	    //add code here.
	    if(s.size()==0)
	    {
	        s.push(a);
	        minEle=a;
	    }
	    else
	    {
	        if(a>= minEle)
	        {
	            s.push(a);
	        }
	        else
	        {
	            int val=2*a-minEle;
	            s.push(val);
	            minEle=a;
	        }
	    }
	    
	}
	public int pop(Stack<Integer> s)
        {
            //add code here.
            if(s.peek()>minEle)
            {
                int val=s.pop();
                return val;
            }
            else
            {
                int val=2*minEle-s.pop();
                int temp=minEle;
                minEle=val;
                return temp;
            }
            
            
	}
	public int min(Stack<Integer> s)
        {
           //add code here.
           return minEle;
           
	}
	public boolean isFull(Stack<Integer>s, int n)
        {
           //add code here.
           
           if(s.size()==n)
           {
               return true;
           }
           return false;
           
	}
	public boolean isEmpty(Stack<Integer>s)
        {
           //add code here.
           if(s.size()==0)
           {
               return true;
           }
           return false;
	}
}
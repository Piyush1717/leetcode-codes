//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    System.out.println(new Solution().evaluatePostFix(br.readLine().trim()));
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String S)
    {
        // Your code here
        
        Stack<Integer> st=new Stack<>();
        
        for(int i=0;i<S.length();i++)
        {
            char ch=S.charAt(i);
        if(ch>='0' && ch<='9')
        {
            int val=(int)(ch-'0'); 
            st.push(val);
        }
        else
        {
            if(ch=='+')
            {
                int val1=st.pop();
                int val2=st.pop();
                
                int sum=val2+val1;
                st.push(sum);
                
            }
            else if(ch=='-')
            {
                
                int val1=st.pop();
                int val2=st.pop();
                
                int diff=val2-val1;
                st.push(diff);
            }
            else if(ch=='*')
            {
                int val1=st.pop();
                int val2=st.pop();
                
                int prod=val2*val1;
                st.push(prod);
                
            }
            else if(ch=='/')
            {
                
                int val1=st.pop();
                int val2=st.pop();
                
                int div=val2/val1;
                st.push(div);
            }
        }
        }
        
        return st.pop();
        
    }
}
// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] s = br.readLine().trim().split(" ");
            int[][] Intervals = new int[n][2];
            int j = 0;
            for(int i = 0; i < n; i++){
                Intervals[i][0] = Integer.parseInt(s[j]);
                j++;
                Intervals[i][1] = Integer.parseInt(s[j]);
                j++;
            }
            Solution obj = new Solution();
            int[][] ans = obj.overlappedInterval(Intervals);
            for(int i = 0; i < ans.length; i++){
                for(j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution
{
    public class pair {
        int st;
        int et;
        
        pair(int st , int et)
        {
            this.st=st;
            this.et=et;
        }
    
 
    }
    
    public int[][] overlappedInterval(int[][] Intervals)
    {
        pair [] pairs=new pair[Intervals.length];
        for(int i=0;i<Intervals.length;i++)
        {
            pairs[i]=new pair(Intervals[i][0],Intervals[i][1]);
        }
        
        Arrays.sort(pairs, (a,b)-> a.st-b.st);
        Stack<pair> st=new Stack<>();
        
        for(int i=0;i<pairs.length;i++)
        {
            if(i==0)
            {
                st.push(pairs[i]);
            }
            else{
                
                pair p=st.peek();
                if(pairs[i].st>p.et)
                {
                    st.push(pairs[i]);
                }else
                {
                    p.et=Math.max(pairs[i].et,p.et);
                }
            }
        }
        
        Stack<pair> res=new Stack<>();
        int count=0;
        while(st.size()>0)
        {
            res.push(st.pop());
            count++;
        }
        int [][] ans=new int [count][2];
        
        for(int i=0;i<count;i++)
        {
            pair temp=res.pop();
            ans[i][0]=temp.st;
            ans[i][1]=temp.et;
            
        }
        
        return ans;
        
        
        
        
    }
}
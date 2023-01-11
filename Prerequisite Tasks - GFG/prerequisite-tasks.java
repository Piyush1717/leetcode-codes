//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
		while(t>0)
		{
		    int N = sc.nextInt();
		    int P = sc.nextInt();
		    int prerequisites[][] = new int[P][2];
		    for(int i=0;i<P;i++)
		    {
		        for(int j=0;j<2;j++)
		        {
		            prerequisites[i][j] = sc.nextInt();
		        }
		    }
			Solution ob = new Solution();
			if(ob.isPossible(N,prerequisites))
			{
			    System.out.println("Yes");
			}
			else{
			    System.out.println("No");
			}
			t--;
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public boolean isPossible(int N, int[][] prerequisites)
    {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        
        for(int i=0;i<N;i++)
        {
            adj.add(new ArrayList<>());
        }
        
        for(int [] arr:prerequisites )
        {
            int x=arr[0];
            int y=arr[1];
            
            adj.get(x).add(y);
        }
        
        int [] in=new int[N];
        
        for(int i=0;i<N;i++)
        {
            for(int ele: adj.get(i))
            {
                in[ele]++;
            }
        }
        
        ArrayDeque<Integer> q=new ArrayDeque<>();
        
        for(int i=0;i<N;i++)
        {
            if(in[i]==0)
            {
                q.add(i);
            }
        }
        ArrayList<Integer> res=new ArrayList<>();
        
        while(q.size()>0)
        {
            int rem=q.poll();
            
            res.add(rem);
            
            for(int ele: adj.get(rem))
            {
                in[ele]--;
                
                if(in[ele]==0)
                {
                    q.add(ele);
                }
            }
        }
        
        if(res.size()==N)
        {
            return true;
        }
        
        return false;
        
        
        
        
        
    }
    
}
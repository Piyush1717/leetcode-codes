//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0){
			int n = sc.nextInt();
			int[][] a = new int[n][n];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					a[i][j] = sc.nextInt();
			Solution T = new Solution();
			ArrayList<Integer> arr= T.mergeKArrays(a, n);
			for(int i = 0; i < n*n ; i++)
			    System.out.print(arr.get(i)+" ");
		    System.out.println();
		    
		    t--;
		}
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to merge k sorted arrays.
    
    public static class Node implements Comparable<Node>{
        int value;
        int array;
        int idx;
        
        Node(int value, int i, int j)
        {
            this.value=value;
            this.array=i;
            this.idx=j;
        }
        
        public int compareTo(Node n)
        {
            // if(this.value<=n.value)
            // {
            //     return -1;
            // }
            // else
            // {
            //     return 1;
            // }
            
            return this.value-n.value;
            
        }
    }
    
    
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int k) 
    {
        // Write your code here.
        ArrayList<Integer> res=new ArrayList<>();
        
        PriorityQueue<Node> pq=new PriorityQueue<>();
        
        for(int i=0;i<k;i++)
        {
            pq.add(new Node(arr[i][0], i, 0));
        }
        
        while(pq.isEmpty()==false)
        {
            Node temp=pq.poll();
            res.add(temp.value);
            
            int ii=temp.array;
            int jj=temp.idx;
            
            if(jj+1<k)
            {
                pq.add(new Node(arr[ii][jj+1],ii,jj+1));
            }
            
            
            
        }
        
        return res;
        
        
        
        
    }
}
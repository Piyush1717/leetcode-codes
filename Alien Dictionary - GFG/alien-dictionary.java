// { Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String findOrder(String [] dict, int N, int K)
    {
        ArrayList<Integer> [] graph=new ArrayList[K];
        
        for(int i=0;i<K;i++)
        {
            graph[i]=new ArrayList<>();
        }
        
        for(int i=0;i<dict.length-1;i++)
        {
            String w1=dict[i];
                String w2=dict[i+1];
            
            for(int j=0;j<Math.min(w1.length(),w2.length());j++)
            {
                char ch1=w1.charAt(j);
                char ch2=w2.charAt(j);
                
                if(ch1!=ch2)
                {
                    graph[ch1-'a'].add(ch2-'a');
                    break;
                }
            }
        }
        
        boolean [] vis=new boolean[K];
        Stack<Integer> st=new Stack<>();
        
        for(int i=0;i<K;i++)
        {
            if(vis[i]==false)
            {
                tsort(i,vis,st,graph);
            }
            
            
        }
        String ans="";
        
        while(st.size()>0)
        {
            
            char ch=(char)(st.pop()+'a');
            ans+=ch;
        }
        
        return ans;
    }
    
    public void tsort(int i,boolean [] vis,Stack<Integer> st ,ArrayList<Integer> [] graph)
    {
        vis[i]=true;
        
        for(int nbr:graph[i]){
            if(!vis[nbr])
            {
                tsort(nbr,vis,st,graph);
            }
            
            
        }
        
        
        
        st.push(i);
    }
    
    
    
}
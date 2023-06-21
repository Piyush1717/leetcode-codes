//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            String[] nk = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            Solution sln = new Solution();
            ArrayList<ArrayList<Integer>> ans = sln.fourSum(a, k);
            for (ArrayList<Integer> v : ans) {
                for (int u : v) {
                    System.out.print(u + " ");
                }
                System.out.print("$");
            }
            if (ans.isEmpty()) {
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// arr[] : int input array of integers
// k : the quadruple sum required

class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        // code here
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        int n=arr.length;
        Arrays.sort(arr);
        
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                int start=j+1;
                int end=n-1;
                
                int tar=k-(arr[i]+arr[j]);
                
                while(start<end)
                {
                    if(arr[start]+arr[end]<tar)
                    {
                        start++;
                    }
                    else if(arr[start]+arr[end]>tar)
                    {
                        end--;
                    }
                    else
                    {
                        ArrayList<Integer> temp=new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[start]);
                        temp.add(arr[end]);
                        
                        res.add(temp);
                        
                        while(start<end && arr[start]==temp.get(2))
                        {
                            start++;
                        }
                        
                        while(end>start && arr[end]==temp.get(3))
                        {
                            end--;
                        }
                    }
                    
                    
                }
                
                while(j+1<n && arr[j]==arr[j+1])
                {
                    j++;
                }
            }
            
            
            while(i+1<n && arr[i]==arr[i+1])
            {
                i++;
            }
            
            
        }
        
        return res;
        
    }
}








//JAVA 4POINTER APPROACH

// class Solution {
//     public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
//         // code here
//         ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
       
//         int n=arr.length;
//         Arrays.sort(arr);
//         for(int i=0;i<n;i++)
//         {
//             for(int j=i+1;j<n;j++)
//             {
//                 int target=k-arr[i]-arr[j];
//                 int start=j+1;
//                 int end=n-1;
//                 while(start<end)
//                 {
//                     int twosum=arr[start]+arr[end];
//                     if(twosum<target) start++;
//                     else if (twosum>target) end--;
//                     else //then sum=k
//                     {
//                         ArrayList<Integer> quad=new ArrayList<>();
//                         quad.add(arr[i]);
//                         quad.add(arr[j]);
//                         quad.add(arr[start]);
//                         quad.add(arr[end]);
//                         list.add(quad);
                        
//                       //to handle duplicates 


//                       while(start<end && arr[start]==quad.get(2))  
//                       ++start;
                      
//                       while(start<end && arr[end]==quad.get(3))  
//                       --end;
//                     }
//                 }
//             while(j+1<n && arr[j+1]==arr[j]) ++j;   //to handle duplicates
//         }
//         while(i+1<n && arr[i+1]==arr[i]) ++i;
        
//     }
//     return list;
    
// }
// }
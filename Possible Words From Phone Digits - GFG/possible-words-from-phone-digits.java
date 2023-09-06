//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class PhoneDigit
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();//testcases
        
        
        while(t-- > 0)
        {
            int n = sc.nextInt(); // input size of array
            int arr[] = new int[n]; //input the elements of array that are keys to be pressed
            
            for(int i = 0; i < n; i++)
               arr[i] = sc.nextInt();//input the elements of array that are keys to be pressed
            ArrayList <String> res = new Solution().possibleWords(arr, n);
            for (String i : res) System.out.print (i + " ");
             System.out.println();
              
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find list of all words possible by pressing given numbers.
    static ArrayList <String> possibleWords(int a[], int N)
    {
        // your code here  
        
        ArrayList<String> res=new ArrayList<>();
        res.add("");
        
        HashMap<Integer, String> map=new HashMap<>();
        
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        
        for(int i=N-1;i>=0;i--)
        {
            ArrayList<String> temp=new ArrayList<>();
            
            int num=a[i];
            String str=map.get(num);
            
            for(int j=0;j<str.length();j++)
            {
             char ch=str.charAt(j);
             
             for(String ele: res)
             {
                 temp.add(ch+ele);
             }
            }
            
            res=temp;
            
        }
        
        return res;
        
    }
}



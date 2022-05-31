// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- >0)
        {
            String str = read.readLine();
            System.out.println(new Reverse().reverseWord(str));
        }
    }
}// } Driver Code Ends


//User function Template for Java


class Reverse
{
    // Complete the function
    // str: input string
    public static String reverseWord(String str)
    {
        char [] c=str.toCharArray();
        
        int i=0;
        int j=c.length-1;
        
        while(i<j)
        {
       char temp=c[i];
       c[i]=c[j];
       c[j]=temp;
            i++;
            j--;
        }
        
        return String.valueOf(c);
        
        
    }
}
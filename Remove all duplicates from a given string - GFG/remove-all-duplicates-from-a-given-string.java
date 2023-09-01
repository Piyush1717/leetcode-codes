//{ Driver Code Starts
//Initial Template for Java



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String str = br.readLine().trim();

            String ans = new Solution().removeDuplicates(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    String removeDuplicates(String str) {
        // code here
        
        HashSet<Character> set=new HashSet<>();
        
        StringBuilder sb=new StringBuilder();
        
        for(int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);
            
            if(set.contains(ch)==false)
            {
                sb.append(ch);
            }
            
            set.add(ch);
        }
        
        return sb.toString();
        
    }
}


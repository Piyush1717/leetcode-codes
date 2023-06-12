//{ Driver Code Starts
import java.util.*;
class GenIP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            Solution sln = new Solution();
            ArrayList<String> str = sln.genIp(s);
            Collections.sort(str);
            if(str.size() == 0)
                System.out.println(-1);
            else{
                for (String u : str) {
                    System.out.println(u);
                }
            }
        }
    }
}
// } Driver Code Ends


/*complete the Function*/

class Solution {
    public ArrayList<String> genIp(String s) {
     
       ArrayList<String> res=new ArrayList<>();

        helper(0, 0, s, "", res);
        
        return res;
     
     
     
    }
    
    public void helper(int i, int par, String s, String ans, ArrayList<String> res )
{
    if(i==s.length() || par==4)
    {
        if(i==s.length() && par==4)
        {
            ans=ans.substring(0,ans.length()-1);
res.add(ans);
return;
        }
    }

if(i+1<=s.length())
{
helper(i+1, par+1, s, ans+s.charAt(i)+".", res);
}


if(i+2<=s.length() && isvalid(s.substring(i,i+2))==true)
{
helper(i+2, par+1, s, ans+s.substring(i,i+2)+".", res);
}


if(i+3<=s.length() && isvalid(s.substring(i,i+3))==true)
{

helper(i+3, par+1, s, ans+s.substring(i,i+3)+".", res);

}

}

public boolean isvalid(String s)
{
if(s.charAt(0)=='0')
{
    return false;
}

int val=Integer.parseInt(s);

if(val>255)
{
    return false;
}
return true;

}


    
    
    
}
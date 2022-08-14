class Solution {
    public int strStr(String haystack, String needle) {
        
        if(needle.length()==0)
        {
            return 0;
        }
        
        int [] lps=getLps(needle);
        
        int i=0;
        int j=0;
        
        while(i<haystack.length())
        {
            if(haystack.charAt(i)==needle.charAt(j))
            {
                i++;
                j++;
                
                if(j==needle.length())
                {
                  return i-needle.length();
                }
            }
            else if(j==0)
            {
                i++;
            }
            else
            {
                j=lps[j-1];
            }
        }
        
        return -1;
        
    }
    
    public int [] getLps(String pat)
    {
        int [] lps=new int [pat.length()];
        
        int len=0;
        int i=1;
        
        while(i<lps.length)
        {
            if(pat.charAt(i)==pat.charAt(len))
            {
                lps[i]=len+1;
                i++;
                len++;
            }
            else if(len==0)
            {
                i++;
            }
            else
            {
                len=lps[len-1];
            }
            
        }
        
        return lps;
        
        
        
    }
    
    
    
    
    
}
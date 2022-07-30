class Solution {
    public int maxPower(String s) {
        int max=0;
        int count=0;
        char prev='@';
        
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            
            if(ch==prev)
            {
                count++;
            }
            else
            {
                count=0;
            }
            
            max=Math.max(max,count+1);
            prev=ch;
        }
        
        return max;
        
    }
}
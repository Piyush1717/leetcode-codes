class Solution {
    public boolean rotateString(String s, String goal) {
        int n=s.length();
        
        if(s.equals(goal))
        {
            return true;
        }
        
        for(int i=1;i<n;i++)
        {
            StringBuilder sb=new StringBuilder();
            
            sb.append(s.substring(i,n));
            sb.append(s.substring(0,i));
            
            String res=sb.toString();
            
            if(goal.equals(res))
            {
                return true;
            }
            
            
        }
        
        
        return false;
    }
}
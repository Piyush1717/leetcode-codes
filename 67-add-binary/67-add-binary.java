class Solution {
    public String addBinary(String a, String b) {
        
        int carry=0;
        String ans="";
        
        int i=a.length()-1;
        int j=b.length()-1;
        
        while(i>=0 || j>=0 || carry!=0)
        {
            int sum=0;
            
            if(i>=0)
            {
                sum=sum+a.charAt(i)-'0';
                i--;
            }
            
            
            if(j>=0)
            {
                sum=sum+b.charAt(j)-'0';
                  j--;
            }
                              
                              sum+=carry;
            
            carry=sum/2;
            sum=sum%2;
            
            String add=sum+"";
            
ans=add+ans;
            
        }
        
        return ans;
        
    }
}
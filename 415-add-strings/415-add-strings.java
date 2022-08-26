class Solution {
    public String addStrings(String num1, String num2) {
        
        int i=num1.length()-1;
        int j=num2.length()-1;
        
        int carry=0;
        
        String ans="";
        
        while(carry!=0 || i>=0 || j>=0)
        {
            int sum=0;
            
            if(i>=0)
            {
            sum=sum+ num1.charAt(i)-'0';
                i--;
            }
            
            
            if(j>=0)
            {
            sum=sum+ num2.charAt(j)-'0';
                j--;
            }
            
            sum=sum+carry;
            
            carry=sum/10;
            sum=sum%10;
            
            String res=sum+"";
            
            ans=res+ans;
            
            
            
            
            
            
            
            
        }
        
        return ans;
        
    }
}
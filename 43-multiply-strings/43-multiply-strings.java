class Solution {
    public String multiply(String num1, String num2) {
        
        if(num1.equals("0") || num2.equals("0"))
        {
            return "0";
        }
        
        int [] res=new int[num1.length() + num2.length()];
        
        int i=num2.length()-1;
        
        int pf=0;
        while(i>=0)
        {
            
            int ival=num2.charAt(i)-'0';
            i--;
            
            int j=num1.length()-1;
            
            int k=res.length-1-pf;
            
            int carry=0;
            
            
            while(j>=0 || carry!=0)
            {
                
                int jval=j>=0? num1.charAt(j)-'0': 0;
                j--;
                
            int prod=ival*jval+carry+res[k];
                
                carry=prod/10;
                prod=prod%10;
                
                res[k]=prod;
                k--;
                
            }
            
            pf++;
               
        }
        
        
        String str="";
        
        boolean flag=false;
        
        for(int ele:res)
        {
            if(ele==0 && flag==false)
            {
                continue;
            }
            else
            {
                flag=true;
                str+=ele;
                
            }
            
            
            
        }
        
        
        return str;
        
    }
}
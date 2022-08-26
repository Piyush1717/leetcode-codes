class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        
                int carry=0;
      List<Integer> ans=new ArrayList<>();
        String b=k+"";
        int i=num.length-1;
        int j=b.length()-1;
        
        while(i>=0 || j>=0 || carry!=0)
        {
            int sum=0;
            
            if(i>=0)
            {
                sum=sum+num[i];
                i--;
            }
            
            
            if(j>=0)
            {
                sum=sum+b.charAt(j)-'0';
                  j--;
            }
                              
                              sum+=carry;
            
            carry=sum/10;
            sum=sum%10;
            
            ans.add(0,sum);
            
        }
        
        return ans;
        
    }
}
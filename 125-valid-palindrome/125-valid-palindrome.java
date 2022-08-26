class Solution {
    public boolean isPalindrome(String s) {
        
        String s1=s.toLowerCase();
        int left=0;
        int right=s1.length()-1;
        
        while(left<right)
        {
            if(!Character.isLetterOrDigit(s1.charAt(left)))
            {
                left++;
                continue;
            }
            else if(!Character.isLetterOrDigit(s1.charAt(right)))
            {
                right--;
                continue;
            }
            else if(s1.charAt(left)!=s1.charAt(right))
            {
                return false;
                
            }
            else
            {
                left++;
                right--;
            }
            
            
        }
        
        
        return true;
        
    }
}
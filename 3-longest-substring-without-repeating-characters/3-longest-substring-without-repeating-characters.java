class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans=0;
       
        
        HashMap<Character, Integer> map=new HashMap<>();
        int i=-1;
        int j=-1;
        while(true)
        {
             boolean flag1=false;
        boolean flag2=false;
        while(i<s.length()-1)
        {
            flag1=true;
            i++;
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault( ch, 0) +1 );
            
            if(map.get(ch)==2){
                break;
            }
            else
            {
                int len=i-j;
                if(len>ans)
                {
                    ans=len;
                }
                
            }  
        }
        
        while(j<i)
        {
             flag2=true;
            j++;
            char ch=s.charAt(j);
            map.put(ch,map.get(ch)-1);
            
            if(map.get(ch)==1)
            {
                break;
            }
        }
        
        if (flag1==false && flag2==false)
            break;
       
        
        }
         return ans;
        
        
    }
}
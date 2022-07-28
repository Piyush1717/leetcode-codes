class Solution {
    public boolean isHappy(int n) {
        
        HashMap<Integer, Integer> hm=new HashMap<>();
        
        while(true)
        {
            
            int val=0;
            while(n!=0)
            {
                int index=n%10;
                val+=index*index;
                n=n/10;
            }
            
            if(val==1)
            {
                return true;
            }
            else
            {
                if(hm.containsKey(val)==true)
                {
                    return false;
                }
            }
            
            hm.put(val,1);
            n=val;
        }
        
        
    }
}
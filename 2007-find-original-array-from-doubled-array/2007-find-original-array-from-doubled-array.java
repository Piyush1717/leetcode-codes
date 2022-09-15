class Solution {
    public int[] findOriginalArray(int[] changed) {
        
        if(changed.length==1)
        {
            return new int [] {};
        }
        
        int n=changed.length;
        
        int [] res=new int[n/2];
        int count=0;
        HashMap<Integer, Integer> hm=new HashMap<>();
        
        for(int ele:changed)
        {
            hm.put(ele , hm.getOrDefault(ele,0)+1);
        }
        
        Arrays.sort(changed);
        
        for(int i=0;i<changed.length;i++)
        {
            int val=changed[i];
            
            if(hm.containsKey(val)==true && hm.containsKey(2*val) )
            {
                
                if(val==0)
                {
                  if(hm.get(val)==1)
                  {
                      return new int [] {};
                  }
                    
                }
                
                
                
                res[count]=val;
                count++;
                
                int v1=hm.get(val);
                if(v1==1)
                {
                    hm.remove(val);
                }
                else
                {
                    hm.put(val, v1-1);
                    
                }
                
                
                int v2=hm.get(2*val);
                if(v2==1)
                {
                    hm.remove(2*val);
                }
                else
                {
                    hm.put(2*val, v2-1);
                    
                }
                
                
            }
            else if(hm.containsKey(val))
            {
                return new int [] {};
            }
            else
            {
                continue;
                
            }
            
            
            
            
            
        }
        
        
        
        
        return res;
        
        
    }
}
class Solution {
    public boolean checkIfExist(int[] arr) {
        
        boolean flag=false;
        
        HashSet<Integer> set=new HashSet();
        
        for(int i=0;i<arr.length;i++)
        {
            if(set.contains(2*arr[i]) )
            {
                return true;
            }
            
            if(arr[i]%2==0 )
            {
                if(set.contains(arr[i]/2))
                {
                    return true;
                }
                
            }
            
            
            set.add(arr[i]);
        }
        
        
        
        
        
        return flag;
        
    }
}
class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        
        Arrays.sort(properties,(b1,b2)->{
           if(b1[0]!=b2[0])
           {
              return b1[0]-b2[0];
           }
            else
            {
               return b2[1]-b1[1];
            }
        });
        
int count=0;
        int n=properties.length-1;
        int max=properties[properties.length-1][properties[0].length-1];
        for(int i=properties.length;i>0;i--)
        {
            if(properties[i-1][1]<max)
            {
                count++;
            }
            else
            {
                max=properties[i-1][1];
                
            }
            
            
            
            
            
            
        }
        return count;
        
    }
}
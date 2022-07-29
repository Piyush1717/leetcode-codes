class Solution {
    public int longestConsecutive(int[] nums) {
        
        int longestStreak=0;
        
        Set<Integer> hm=new HashSet<Integer>();
        
        for(int num: nums)
        {
            hm.add(num);
        }
        
        for(int num: nums)
        {
            if(!hm.contains(num-1))
            {
                int currNum=num;
                int currStreak=1;
                
                while(hm.contains(currNum+1))
                {
                    currNum+=1;
                    currStreak+=1;
                }
                 longestStreak=Math.max(longestStreak, currStreak);
            }
            
           
            
        }
        
        
        return longestStreak;
    }
}
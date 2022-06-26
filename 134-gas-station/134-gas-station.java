class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int prev=0;
        int ans=0;
        int curr=0;
        
        for(int i=0;i<gas.length;i++)
        {
            if(curr<0)
            {
                prev+=curr;
                curr=0;
                ans=i;
                
            }
            curr+=gas[i]-cost[i];
        }
        
        if(prev+curr>=0)
        {
            return ans;
        }
        return -1;
        
        
    }
}
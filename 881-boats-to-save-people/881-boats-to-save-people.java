class Solution {
    public int numRescueBoats(int[] people, int limit) {
        
        int l=0;
        Arrays.sort(people);
        int r=people.length-1;
        
        int ans=0;
        
        while(l<=r)
        {
            int val=people[l]+people[r];
            
            if(val<=limit)
            {
                ans++;
                l++;
                r--;
            }
            else
            {
                ans++;
                r--;   
            }
        }
        
        return ans;
        
    }
}
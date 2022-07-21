class Solution {
    public int maxDistToClosest(int[] seats) {
        int n=seats.length;
        int prev=-1;
        int res=0;
        
        for(int i=0;i<n;i++)
            {
            if(seats[i]==1)
            {
                res= prev<0 ? i : Math.max(res,(i-prev)/2);
                prev=i;
            }
            }
        
        res=Math.max(res,n-prev-1);
        
        return res;
}
            }
            
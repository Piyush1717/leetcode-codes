class Solution {
    public int countHousePlacements(int n) {
        
        long s=1;
        long b=1;
        
        
        for(int i=2;i<=n;i++){
            
            long ns=(s+b)%1000000007;
            long nb=s;
            
            s=ns;
            b=nb;
            
        }
        
        long tot=(s+b)%1000000007;
        tot=(tot*tot)%1000000007;
        return (int)tot;
        
    }
}
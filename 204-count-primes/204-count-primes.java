class Solution {
    public int countPrimes(int n) {
        if(n<2)
        {
            return 0;
        }
        
        boolean [] primes=new boolean[n+1];
        Arrays.fill(primes, true);
        
        primes[0]=false;
        primes[1]=false;
        
        for(int div=2;div*div<=n;div++)
        {
            if(primes[div]==false)
            {
                continue;
            }
            
            for(int ja=div;div*ja<=n;ja++)
            {
                primes[div*ja]=false;
            }
        }
        
        int count=0;
        for(int i=0;i<n;i++)
        {
            if(primes[i]==true)
            {
                count++;
            }
        }
        
        return count;
    }
}
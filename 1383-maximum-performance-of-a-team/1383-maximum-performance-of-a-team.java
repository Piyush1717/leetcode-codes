class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        
        int [][] eng=new int[n][2];
        
        // ArrayList<ArrayList<Integer>> eng=new ArrayList<>();
        
//         for(int i=0;i<n;i++)
//         {
//             eng.add(new ArrayList<>());
//         }
        
        
        for(int i=0;i<n;i++)
        {   
            eng[i][0]=efficiency[i];
            
             eng[i][1]=speed[i];   
                     }
            
        
        Arrays.sort(eng, (a,b)->{
            if(a[0]!=b[0])
            {
               return a[0]-b[0];
            }
            else 
            {
               return a[1]-b[1];
            }
        });
        
        
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        long res=0;
        long sum=0;
        long ans=0;
        
        
        for(int i=eng.length-1;i>=0;i--)
        {
            sum=sum+eng[i][1];
                      
            pq.add(eng[i][1]);
            
            if(pq.size()>k)
            {
                long temp=pq.remove();
                sum=(sum-temp);
            }
            
            ans=(sum*eng[i][0]);
            
            res=Math.max(res,ans);
            
        }
        
        return (int) ( res % 1000000007);
        
        
    }
}
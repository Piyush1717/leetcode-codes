class Solution {
    
    public class pair{
        int bus;
        int csf;
        
        pair(int bus, int csf)
        {
            this.bus=bus;
            this.csf=csf;
        }
    }
    
    
    public int numBusesToDestination(int[][] routes, int source, int target) {
        
        if(source==target)
        {
            return 0;
        }
        
        HashMap<Integer, ArrayList<Integer>> map=new HashMap<>();
        for(int bus=0;bus<routes.length;bus++)
        {
            for(int stop:routes[bus])
            {
               if(map.containsKey(stop)==false)
               {
                   map.put(stop, new ArrayList<>());
               }
                map.get(stop).add(bus);
            }
        }
        
        ArrayDeque<pair> q=new ArrayDeque<>();
        
        for(int bus: map.get(source))
        {
            q.add(new pair(bus,1));
        }
        
        boolean [] visited=new boolean[routes.length];
        while(q.size()>0)
        {
            //r m w a
            pair rem=q.poll();
            
            if(visited[rem.bus]==true)
            {
                continue;
            }
            
            visited[rem.bus]=true;
            
            for(int rstop: routes[rem.bus])
            {
                if(rstop==target)
                {
                    return rem.csf;
                }
            }
            
            for(int rstop:routes[rem.bus])
            {
                for(int bus: map.get(rstop))
                {
                    if(visited[bus]==false)
                    {
                        q.add(new pair(bus, rem.csf+1));
                    }
                }
                
                
            }
            
            
            
            
        }
        
        
        return -1;
        
    }
}
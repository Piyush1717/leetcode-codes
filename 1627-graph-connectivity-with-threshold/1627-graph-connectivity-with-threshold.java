class Solution {
    
    int [] p;
    int [] r;
    
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        p=new int[n+1];
         r=new int[n+1];
        
        for(int i=0;i<p.length;i++)
        {
            p[i]=i;
            r[i]=0;
        }
        
        for(int i=threshold+1;i<=n;i++)
        {
            for(int m=1;m*i<=n;m++)
            {
                union(i,m*i);
            }
        }
        
        ArrayList<Boolean> res=new ArrayList<>();
        for(int[] query: queries)
        {
            int n1=query[0];
            int n2=query[1];
            
            boolean flag;
            if(find(n1)==find(n2))
            {
                flag=true;
            }
            else
            {
                flag=false;
            }
            
            res.add(flag);
            
        }
        
        return res;
    }
    
    
    public int find(int x)
    {
        if(p[x]==x)
        {
            return x;
        }
        else
        {
            p[x]=find(p[x]);
            return p[x];
        }
    }
    
    public void union(int x, int y)
    {
        int X=find(x);
        int Y=find(y);
        
        if(X==Y)
        {
            return;
        }
        
        if(r[X]<r[Y])
        {
            p[X]=Y;
        }
        else if(r[Y]<r[X])
        {
            p[Y]=X;
        }
        else
        {
            p[X]=Y;
            r[Y]++;
            
        }
            
        
        
        
    }
    
    
    
}
class Solution {
    
    int [] res;
    
    class pair{
        
        int idx;
        int val;
        
        pair(int idx, int val){
            this.idx=idx;
            this.val=val;
        }
    }
    
    public List<Integer> countSmaller(int[] nums) {
        pair [] pairs=new pair[nums.length];
        
        for(int i=0;i<nums.length;i++)
        {
            pairs[i]=new pair(i,nums[i]);
        }
        
          res=new int[nums.length];
        
        merge(pairs,0,pairs.length-1);
        
        ArrayList<Integer> ans=new ArrayList<>();
        
        for(int val:res)
        {
            ans.add(val);
        }
        
        return ans;
    }
    
    public pair [] merge(pair [] pairs, int low, int hi )
    {
        if(low==hi)
        {
            pair [] base=new pair[1];
            base[0]=new pair(low,pairs[low].val);
            return base;
        }
        
        int mid=(low+hi)/2;
        
        pair [] fh=merge(pairs,low ,mid);
          pair [] sh=merge(pairs,mid+1 ,hi);
        
        pair [] ans=merge2(fh,sh);
        
        return ans;
    }
    
    public pair [] merge2(pair [] fh,pair [] sh)
    {
        
        pair [] p=new pair[fh.length+sh.length];
        
        int i=0;
          int j=0;
          int k=0;
        
        
        while(i<fh.length && j<sh.length)
        {
            if(fh[i].val>sh[j].val)
            {
                p[k]=fh[i];
                
                res[fh[i].idx]+=sh.length-j;
                
                i++;
                k++;
            }
            else
            {
                p[k]=sh[j];
                j++;
                k++;
            }
            
        }
        
             while(i<fh.length)
        {
                p[k]=fh[i];
                
                i++;
                k++;
            
        }
        
        
              while(j<sh.length)
        {
                p[k]=sh[j];
                
                j++;
                k++;
        }
        
        return p;
    }
      
}
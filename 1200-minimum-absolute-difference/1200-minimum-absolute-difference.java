class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        
        int md=Integer.MAX_VALUE;
        
        Arrays.sort(arr);
        
        for(int i=0;i<arr.length-1;i++)
        {
            if(arr[i+1]-arr[i]<md)
            {
                md=arr[i+1]-arr[i];
            }
        }
        
        
        List<List<Integer>> ans=new ArrayList<>();
        
        
        
        for(int i=0;i<arr.length-1;i++)
        {
            List<Integer> res=new ArrayList<>();
            if(arr[i+1]-arr[i]==md)
            {
                res.add(arr[i]);
                res.add(arr[i+1]);
                
                ans.add(res);
            }
        }
        
        return ans;
        
        
        
        
    }
}
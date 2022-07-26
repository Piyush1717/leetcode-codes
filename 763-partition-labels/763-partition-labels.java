class Solution {
    public List<Integer> partitionLabels(String s) {
        int [] map=new int [26];
        
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            map[ch-'a']=i;
        }
        
        ArrayList<Integer> ans=new ArrayList<>();
        int start=0;
        int end=0;
        
        for(int j=0;j<s.length();j++)
        {
            char ch=s.charAt(j);
            end=Math.max(end,map[ch-'a']);
            
            if(j==end)
            {
                int len=end-start+1;
                ans.add(len);
                end++;
                start=end;
            }
            
            
        }
        
        return ans;
        
    }
}
class Solution {
    public int maxScore(int[] cardPoints, int k) {
   int total=0;
        int min=0;
        
        for(int i=0;i<cardPoints.length;i++)
        {
            total+=cardPoints[i];
        }
        
        int len=cardPoints.length-k;
        
        for(int i=0;i<len;i++)
        {
            min+=cardPoints[i];
        }
        int next=len;
        int prev=0;
        int temp=min;
        while(next<cardPoints.length)
        {
            temp=temp-cardPoints[prev];
            temp=temp+cardPoints[next];
            
            if(temp<min)
            {
                min=temp;
            }
            
            next++;
            prev++;
            
        }
        return total-min;
        
        
        
    }
}
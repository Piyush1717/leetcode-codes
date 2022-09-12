class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        
        if(tokens.length==0)
        {
            return 0;
        }
        
        Arrays.sort(tokens);
        
        int score=0;
        int max=0;
        
        int i=0;
        int j=tokens.length-1;
        
        
        while(i<=j)
        {
            if(tokens[i]<=power)
            {
                power-=tokens[i];
                score++;
                i++;
            }
            else
            {
                if(score>0)
                {
                   score--;
                    power+=tokens[j];
                    j--;
                }
                else
                {
                    break;
                }
            }
            
            max=Math.max(max, score);
      
            
        }
        
        return max;
        
    }
}
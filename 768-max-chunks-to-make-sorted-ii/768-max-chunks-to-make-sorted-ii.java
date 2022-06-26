class Solution {
    public int maxChunksToSorted(int[] arr) {
int count =0;
        int [] leftMax=new int [arr.length];
         int [] rightMin=new int [arr.length+1];
        
        leftMax[0]=arr[0];
        rightMin[arr.length]=Integer.MAX_VALUE;
        for(int i=1;i<leftMax.length;i++)
        {
            leftMax[i]=Math.max(leftMax[i-1],arr[i]);
        }
        
        
        for(int i=rightMin.length-2;i>=0;i--)
        {
            rightMin[i]=Math.min(arr[i],rightMin[i+1]);
        }
        
        for(int i=0;i<leftMax.length;i++)
        {
            if(leftMax[i]<=rightMin[i+1])
            {
                count++;
            }
            
        }
        
        return count;
}
}